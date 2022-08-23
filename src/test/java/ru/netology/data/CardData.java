package ru.netology.data;

import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.IOException;

@NoArgsConstructor

public class CardData {

    @Value
    public static class CardInfo {
        String number;
        String month;
        String year;
        String holder;
        String cvv;
    }

    public static CardInfo getApprovedCard() throws IOException {
        var cardHolderFullName = DataGenerator.generateCardHolderFullName("en");
        var cvc = DataGenerator.generateCvc();
        return new CardInfo("4444 4444 4444 4441", "10", "26", cardHolderFullName, cvc);
    }

    public static CardInfo getDeclinedCard() throws IOException {
        var cardHolderFullName = DataGenerator.generateCardHolderFullName("en");
        var cvc = DataGenerator.generateCvc();
        return new CardInfo("4444 4444 4444 4442", "10", "26", cardHolderFullName, cvc);
    }

    public static CardInfo getInvalidCardDataIsEmpty() {
        return new CardInfo("", "", "", "", "");
    }


    public static CardInfo getInvalidCardNumberIsEmpty() throws IOException {
        var cardHolderFullName = DataGenerator.generateCardHolderFullName("en");
        var cvc = DataGenerator.generateCvc();
        return new CardInfo("", "10", "26", cardHolderFullName, cvc);
    }

    public static CardInfo getInvalidCardNumberLess() throws IOException {
        var cardHolderFullName = DataGenerator.generateCardHolderFullName("en");
        var cvc = DataGenerator.generateCvc();
        return new CardInfo("4444 4444 4444 4", "10", "26", cardHolderFullName, cvc);
    }

    public static CardInfo getInvalidCardNumberNotFromList() throws IOException {
        var cardNumber = DataGenerator.generateCardNumber("en");
        var cardHolderFullName = DataGenerator.generateCardHolderFullName("en");
        var cvc = DataGenerator.generateCvc();
        return new CardInfo(cardNumber, "10", "26", cardHolderFullName, cvc);
    }

    public static CardInfo getInvalidMonthIsEmpty() throws IOException {
        var cardHolderFullName = DataGenerator.generateCardHolderFullName("en");
        var cvc = DataGenerator.generateCvc();
        return new CardInfo("4444 4444 4444 4441", "", "26", cardHolderFullName, cvc);
    }

    public static CardInfo getInvalidMonthIsOneSign() throws IOException {
        var cardHolderFullName = DataGenerator.generateCardHolderFullName("en");
        var cvc = DataGenerator.generateCvc();
        return new CardInfo("4444 4444 4444 4441", "1", "26", cardHolderFullName, cvc);
    }

    public static CardInfo getInvalidMonthMoreLimit() throws IOException {
        var cardHolderFullName = DataGenerator.generateCardHolderFullName("en");
        var cvc = DataGenerator.generateCvc();
        return new CardInfo("4444 4444 4444 4441", "22", "26", cardHolderFullName, cvc);
    }

    public static CardInfo getInvalidMonthIsZero() throws IOException {
        var cardHolderFullName = DataGenerator.generateCardHolderFullName("en");
        var cvc = DataGenerator.generateCvc();
        return new CardInfo("4444 4444 4444 4441", "00", "26", cardHolderFullName, cvc);
    }


    public static CardInfo getInvalidYearIsEmpty() throws IOException {
        var cardHolderFullName = DataGenerator.generateCardHolderFullName("en");
        var cvc = DataGenerator.generateCvc();
        return new CardInfo("4444 4444 4444 4441", "10", "", cardHolderFullName, cvc);
    }

    public static CardInfo getInvalidYearIsOneSign() throws IOException {
        var cardHolderFullName = DataGenerator.generateCardHolderFullName("en");
        var cvc = DataGenerator.generateCvc();
        return new CardInfo("4444 4444 4444 4441", "10", "1", cardHolderFullName, cvc);
    }

    public static CardInfo getInvalidYearIsBack() throws IOException {
        var cardHolderFullName = DataGenerator.generateCardHolderFullName("en");
        var cvc = DataGenerator.generateCvc();
        return new CardInfo("4444 4444 4444 4441", "10", "21", cardHolderFullName, cvc);
    }

    public static CardInfo getInvalidYearIsZero() throws IOException {
        var cardHolderFullName = DataGenerator.generateCardHolderFullName("en");
        var cvc = DataGenerator.generateCvc();
        return new CardInfo("4444 4444 4444 4441", "10", "00", cardHolderFullName, cvc);
    }

    public static CardInfo getInvalidYearIsFarFuture() throws IOException {
        var cardHolderFullName = DataGenerator.generateCardHolderFullName("en");
        var cvc = DataGenerator.generateCvc();
        return new CardInfo("4444 4444 4444 4441", "10", "50", cardHolderFullName, cvc);
    }


    public static CardInfo getInvalidCardholderIsEmpty() {
        var cvc = DataGenerator.generateCvc();
        return new CardInfo("4444 4444 4444 4441", "10", "26", "", cvc);
    }

    public static CardInfo getInvalidCardholderIsOneWord() throws IOException {
        var cardHolderFirstName = DataGenerator.generateCardHolderName("en");
        var cvc = DataGenerator.generateCvc();
        return new CardInfo("4444 4444 4444 4441", "10", "26", cardHolderFirstName, cvc);
    }

    public static CardInfo getInvalidCardholderIsThreeWords() throws IOException {
        var cardHolderName = DataGenerator.generateCardHolderTreeWords("en");
        var cvc = DataGenerator.generateCvc();
        return new CardInfo("4444 4444 4444 4441", "10", "26", cardHolderName, cvc);
    }

    public static CardInfo getInvalidCardholderRusLang() throws IOException {
        var cardHolderFullName = DataGenerator.generateCardHolderFullName("ru");
        var cvc = DataGenerator.generateCvc();
        return new CardInfo("4444 4444 4444 4441", "10", "26", cardHolderFullName, cvc);
    }

    public static CardInfo getInvalidCardholderNumeric() {
        var cvc = DataGenerator.generateCvc();
        return new CardInfo("4444 4444 4444 4441", "10", "26", "123 56789", cvc);
    }

    public static CardInfo getInvalidCardholderIsSpecialSign() {
        var cvc = DataGenerator.generateCvc();
        return new CardInfo("4444 4444 4444 4441", "10", "26", "$^%*!", cvc);
    }


    public static CardInfo getInvalidCvcIsEmpty() throws IOException {
        var cardHolderFullName = DataGenerator.generateCardHolderFullName("en");
        return new CardInfo("4444 4444 4444 4441", "10", "26", cardHolderFullName, "");
    }

    public static CardInfo getInvalidCvcIsOneSign() throws IOException {
        var cardHolderFullName = DataGenerator.generateCardHolderFullName("en");
        return new CardInfo("4444 4444 4444 4441", "10", "26", cardHolderFullName, "1");
    }

    public static CardInfo getInvalidCvcIsTwoSign() throws IOException {
        var cardHolderFullName = DataGenerator.generateCardHolderFullName("en");
        return new CardInfo("4444 4444 4444 4441", "10", "26", cardHolderFullName, "11");
    }

    public static CardInfo getInvalidCvcIsZeros() throws IOException {
        var cardHolderFullName = DataGenerator.generateCardHolderFullName("en");
        return new CardInfo("4444 4444 4444 4441", "10", "26", cardHolderFullName, "000");
    }

}
