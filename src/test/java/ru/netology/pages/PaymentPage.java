package ru.netology.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.CardData;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PaymentPage {

    private final SelenideElement transactionApproved =  $(byText("Операция одобрена Банком."));
    private final SelenideElement emptyField =  $(byText("Поле обязательно для заполнения"));
    private final SelenideElement incorrectFormat =  $(byText("Неверный формат"));
    private final SelenideElement transactionDenied =  $(byText("Ошибка! Банк отказал в проведении операции."));
    private final SelenideElement incorrectExpiredDate =  $(byText("Неверно указан срок действия карты"));
    private final SelenideElement expiredDatePassedCard =  $(byText("Истёк срок действия карты"));

    public void listCardData(CardData.CardInfo cardInfo) {
        $("input[placeholder='0000 0000 0000 0000']").setValue(cardInfo.getNumber());
        $("input[placeholder='08']").setValue(cardInfo.getMonth());
        $("input[placeholder='22']").setValue(cardInfo.getYear());
        $$(".input__control").get(3).setValue(cardInfo.getHolder());
        $("input[placeholder='999']").setValue(cardInfo.getCvv());
        $$("button").find(exactText("Продолжить")).click();
    }

    public void shouldIncorrectFormatNotification() {
        incorrectFormat.shouldBe(Condition.visible);
    }
    public void shouldEmptyFieldNotification() {
        emptyField.shouldBe(Condition.visible);
    }
    public void shouldInvalidExpiredDateNotification() {
        incorrectExpiredDate.shouldBe(Condition.visible);
    }
    public void shouldExpiredDatePassNotification() {
        expiredDatePassedCard.shouldBe(Condition.visible);
    }
    public void shouldSuccessNotification() { transactionApproved.shouldHave(visible, Duration.ofMillis(15000));}
    public void shouldFailureNotification() {
        transactionDenied.shouldHave(visible, Duration.ofMillis(15000));
    }

}
