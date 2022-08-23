package ru.netology.data;

import com.github.javafaker.Faker;

import java.io.*;

import java.util.Locale;
import java.lang.String;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateCvc() {
        String cvc = String.valueOf(100 + (int) (Math.random() * 999));
        return cvc;
    }

    public static String generateCardHolderFullName(String locale) throws IOException {
        Faker faker = new Faker(new Locale(locale));
        String cardHolder = faker.name().firstName() + " " + faker.name().lastName();
        return cardHolder;
    }

    public static String generateCardHolderTreeWords(String locale) throws IOException {
        Faker faker = new Faker(new Locale(locale));
        String cardHolder = faker.name().firstName() + " " + faker.name().lastName() + " " + faker.name().lastName();
        return cardHolder;
    }

    public static String generateCardHolderName(String locale) throws IOException {
        Faker faker = new Faker(new Locale(locale));
        String cardHolderName = faker.name().firstName();
        return cardHolderName;
    }

    public static String generateCardNumber(String locale) throws IOException {
        Faker faker = new Faker(new Locale(locale));
        String cardNumber = faker.numerify("#### #### #### ####");
        return cardNumber;
    }

}
