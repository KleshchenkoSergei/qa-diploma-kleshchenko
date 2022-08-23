package ru.netology.test.credit;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.pages.StartPage;
import ru.netology.pages.PaymentPage;
import ru.netology.test.TestPreparation;

import java.io.IOException;

import static ru.netology.data.CardData.*;

public class CreditCardHolderFieldTest extends TestPreparation{

    StartPage startPage = new StartPage();
    PaymentPage paymentPage = new PaymentPage();

    @BeforeEach
    void setUpForPayWithCredit() {
        startPage.payWithCredit();
    }

    @Test
    public void shouldFailurePaymentCardholderNameEmpty() {
        val cardData = getInvalidCardholderIsEmpty();
        paymentPage.listCardData(cardData);
        paymentPage.shouldEmptyFieldNotification();
    }

    @Test
    public void shouldFailurePaymentCardholderNameOneWord() throws IOException {
        val cardData = getInvalidCardholderIsOneWord();
        paymentPage.listCardData(cardData);
        paymentPage.shouldIncorrectFormatNotification();
    }

    @Test
    public void shouldFailurePaymentCardholderNameThreeWords() throws IOException {
        val cardData = getInvalidCardholderIsThreeWords();
        paymentPage.listCardData(cardData);
        paymentPage.shouldIncorrectFormatNotification();
    }

    @Test
    public void shouldFailurePaymentCardholderNameRusLang() throws IOException {
        val cardData = getInvalidCardholderRusLang();
        paymentPage.listCardData(cardData);
        paymentPage.shouldIncorrectFormatNotification();
    }

    @Test
    public void shouldFailurePaymentCardholderNameNumeric() {
        val cardData = getInvalidCardholderNumeric();
        paymentPage.listCardData(cardData);
        paymentPage.shouldIncorrectFormatNotification();
    }

    @Test
    public void shouldFailurePaymentCardholderNameSpecialSign() {
        val cardData = getInvalidCardholderIsSpecialSign();
        paymentPage.listCardData(cardData);
        paymentPage.shouldIncorrectFormatNotification();
    }
}
