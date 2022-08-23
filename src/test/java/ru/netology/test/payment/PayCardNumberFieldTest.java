package ru.netology.test.payment;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.pages.StartPage;
import ru.netology.pages.PaymentPage;
import ru.netology.test.TestPreparation;

import java.io.IOException;

import static ru.netology.data.CardData.*;

public class PayCardNumberFieldTest extends TestPreparation{

    StartPage startPage = new StartPage();
    PaymentPage paymentPage = new PaymentPage();

    @BeforeEach
    void setUpForPayWithCard() {
        startPage.payWithCard();
    }

    @Test
    public void shouldFailurePaymentCardNumberEmpty() throws IOException {
        val cardData = getInvalidCardNumberIsEmpty();
        paymentPage.listCardData(cardData);
        paymentPage.shouldEmptyFieldNotification();
    }

    @Test
    public void shouldFailurePaymentCardNumberLess() throws IOException {
        val cardData = getInvalidCardNumberLess();
        paymentPage.listCardData(cardData);
        paymentPage.shouldIncorrectFormatNotification();
    }

    @Test
    public void shouldFailurePaymentCardNumberNotFromList() throws IOException {
        val cardData = getInvalidCardNumberNotFromList();
        paymentPage.listCardData(cardData);
        paymentPage.shouldFailureNotification();
    }
}
