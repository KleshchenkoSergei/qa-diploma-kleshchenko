package ru.netology.test.payment;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.pages.StartPage;
import ru.netology.pages.PaymentPage;
import ru.netology.test.TestPreparation;

import java.io.IOException;

import static ru.netology.data.CardData.*;

public class PayMonthFieldTest extends TestPreparation{

    StartPage startPage = new StartPage();
    PaymentPage paymentPage = new PaymentPage();

    @BeforeEach
    void setUpForPayWithCard() {
        startPage.payWithCard();
    }

    @Test
    public void shouldFailurePaymentMonthEmpty() throws IOException {
        val cardData = getInvalidMonthIsEmpty();
        paymentPage.listCardData(cardData);
        paymentPage.shouldEmptyFieldNotification();
    }

    @Test
    public void shouldFailurePaymentMonthOneSign() throws IOException {
        val cardData = getInvalidMonthIsOneSign();
        paymentPage.listCardData(cardData);
        paymentPage.shouldIncorrectFormatNotification();
    }

    @Test
    public void shouldFailurePaymentMonthMoreLimit() throws IOException {
        val cardData = getInvalidMonthMoreLimit();
        paymentPage.listCardData(cardData);
        paymentPage.shouldInvalidExpiredDateNotification();
    }

    @Test
    public void shouldFailurePaymentMonthZero() throws IOException {
        val cardData = getInvalidMonthIsZero();
        paymentPage.listCardData(cardData);
        paymentPage.shouldInvalidExpiredDateNotification();
    }
}
