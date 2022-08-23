package ru.netology.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class StartPage {
    public void payWithCard() {
        $$("button").find(exactText("Купить")).click();
        $("#root > div > h3").shouldHave(text("Оплата по карте"));
    }
    public void payWithCredit() {
        $$("button").find(exactText("Купить в кредит")).click();
        $("#root > div > h3").shouldHave(text("Кредит по данным карты"));
    }

}
