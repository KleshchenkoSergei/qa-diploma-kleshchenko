package ru.netology.test.api;

import lombok.val;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.netology.data.APIData.*;
import static ru.netology.data.CardData.getApprovedCard;
import static ru.netology.data.CardData.getDeclinedCard;

public class APITest {

    @Test
    void shouldGetStatusApprovedPayment() throws IOException {
        val validApprovedCard = getApprovedCard();
        val status = PaymentPageForm(validApprovedCard);
        assertTrue(status.contains("APPROVED"));
    }

    @Test
    void shouldGetStatusDeclinedPayment() throws IOException {
        val declinedCard = getDeclinedCard();
        val status = PaymentPageForm(declinedCard);
        assertTrue(status.contains("DECLINED"));
    }

    @Test
    void shouldGetStatusApprovedCredit() throws IOException {
        val approvedCard = getApprovedCard();
        val status = CreditPageForm(approvedCard);
        assertTrue(status.contains("APPROVED"));
    }

    @Test
    void shouldGetStatusDeclinedCredit() throws IOException {
        val declinedCard = getDeclinedCard();
        val status = CreditPageForm(declinedCard);
        assertTrue(status.contains("DECLINED"));
    }
}
