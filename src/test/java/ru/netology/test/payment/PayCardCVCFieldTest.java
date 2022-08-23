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

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$$;
import static ru.netology.data.CardData.*;

public class PayCardCVCFieldTest extends TestPreparation{

    StartPage startPage = new StartPage();
    PaymentPage paymentPage = new PaymentPage();

    @BeforeEach
    void setUpForPayWithCard() {
        startPage.payWithCard();
    }

    @Test
    public void shouldFailurePaymentEmptyCvc() throws IOException {
        val cardData = getInvalidCvcIsEmpty();
        paymentPage.listCardData(cardData);
        final ElementsCollection fieldSub = $$(".input__sub");
        final SelenideElement cvvFieldSub = fieldSub.get(2);
        cvvFieldSub.shouldHave(Condition.text("Поле обязательно для заполнения"));
    }

    @Test
    public void shouldFailurePaymentCvcOneSign() throws IOException {
        val cardData = getInvalidCvcIsOneSign();
        paymentPage.listCardData(cardData);
        paymentPage.shouldIncorrectFormatNotification();
    }

    @Test
    public void shouldFailurePaymentCvcTwoSign() throws IOException {
        val cardData = getInvalidCvcIsTwoSign();
        paymentPage.listCardData(cardData);
        paymentPage.shouldIncorrectFormatNotification();
    }

    @Test
    public void shouldFailurePaymentCvcZeros() throws IOException {
        val cardData = getInvalidCvcIsZeros();
        paymentPage.listCardData(cardData);
        paymentPage.shouldIncorrectFormatNotification();
    }
}
