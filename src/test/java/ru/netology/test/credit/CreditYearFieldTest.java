package ru.netology.test.credit;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.pages.StartPage;
import ru.netology.pages.PaymentPage;
import ru.netology.test.TestPreparation;

import java.io.IOException;

import static ru.netology.data.CardData.*;

public class CreditYearFieldTest extends TestPreparation{

    StartPage startPage = new StartPage();
    PaymentPage paymentPage = new PaymentPage();

    @BeforeEach
    void setUpForPayWithCredit() {
        startPage.payWithCredit();
    }

    @Test
    public void shouldFailurePaymentYearEmpty() throws IOException {
        val cardData = getInvalidYearIsEmpty();
        paymentPage.listCardData(cardData);
        paymentPage.shouldEmptyFieldNotification();
    }

    @Test
    public void shouldFailurePaymentYearOneSign() throws IOException {
        val cardData = getInvalidYearIsOneSign();
        paymentPage.listCardData(cardData);
        paymentPage.shouldIncorrectFormatNotification();
    }

    @Test
    public void shouldFailurePaymentBackYear() throws IOException {
        val cardData = getInvalidYearIsBack();
        paymentPage.listCardData(cardData);
        paymentPage.shouldExpiredDatePassNotification();
    }

    @Test
    public void shouldFailurePaymentYearZero() throws IOException {
        val cardData = getInvalidYearIsZero();
        paymentPage.listCardData(cardData);
        paymentPage.shouldExpiredDatePassNotification();
    }

    @Test
    public void shouldFailurePaymentYearFarFuture() throws IOException {
        val cardData = getInvalidYearIsFarFuture();
        paymentPage.listCardData(cardData);
        paymentPage.shouldInvalidExpiredDateNotification();
    }
}
