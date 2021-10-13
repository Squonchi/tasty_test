package com.testing.tests;


import com.codeborne.selenide.logevents.SelenideLogger;
import com.testing.utils.UIListener;
import io.qameta.allure.restassured.AllureRestAssured;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

@Listeners({UIListener.class})
public abstract class BaseTest{
    public void openGoogle() {
        open("https://google.ru");
    }

    @BeforeSuite
    public void beforeSuite() {
        RestAssured.filters(new AllureRestAssured());
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    public void searchWordWithGoogle(String word) {
        openGoogle();
        $(".gLFyf.gsfi").setValue(word).pressEnter();
    }

    public void openSomeGoogleResult(int index) {
        $$(".LC20lb.DKV0Md").get(index).click();
        switchTo().window(1);
    }
}
