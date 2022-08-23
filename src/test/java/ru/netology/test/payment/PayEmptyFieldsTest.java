package ru.netology.test.payment;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.pages.StartPage;
import ru.netology.pages.PaymentPage;
import ru.netology.test.TestPreparation;

import static com.codeborne.selenide.Selenide.$$;
import static ru.netology.data.CardData.getInvalidCardDataIsEmpty;

public class PayEmptyFieldsTest extends TestPreparation{

    StartPage startPage = new StartPage();
    PaymentPage paymentPage = new PaymentPage();

    @BeforeEach
    void setUpForPayWithCard() {
        startPage.payWithCard();
    }

    @Test
    public void shouldFailurePaymentFieldsEmpty() {
        val cardData = getInvalidCardDataIsEmpty();
        paymentPage.listCardData(cardData);
        final ElementsCollection fieldSubscription = $$(".input__sub");
        final SelenideElement cardNumberFieldSub = fieldSubscription.get(1);
        final SelenideElement monthFieldSub = fieldSubscription.get(2);
        final SelenideElement yearFieldSub = fieldSubscription.get(3);
        final SelenideElement cardholderFieldSub = fieldSubscription.get(4);
        final SelenideElement cvcFieldSub = fieldSubscription.get(5);

        String notEmptyNote = "Поле обязательно для заполнения";
        cardNumberFieldSub.shouldHave(Condition.text(notEmptyNote));
        monthFieldSub.shouldHave(Condition.text(notEmptyNote));
        yearFieldSub.shouldHave(Condition.text(notEmptyNote));
        cardholderFieldSub.shouldHave(Condition.text(notEmptyNote));
        cvcFieldSub.shouldHave(Condition.text(notEmptyNote));
    }
}
