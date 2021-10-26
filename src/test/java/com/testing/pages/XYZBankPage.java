package com.testing.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class XYZBankPage {
    public SelenideElement customerLoginButton() {
        return $("button[ng-click='customer()']");
    }

    public SelenideElement bankManagerLoginButton() {
        return $("button[ng-click='manager()']");
    }

    public SelenideElement userSelectList() {
        return $("select[ng-model='custId']").as("Выбор пользователя");
    }

    public SelenideElement loginButton() {
        return $("button[type='submit']").shouldHave(text("Login"));
    }

    public SelenideElement transactionsChooseButton() throws InterruptedException {
        Thread.sleep(500);
        return $("[ng-click='transactions()']").shouldBe();
    }

    public SelenideElement depositChooseButton() {
        return $("[ng-click='deposit()']");
    }

    public SelenideElement withdrawlChooseButton() {
        return $("[ng-click='withdrawl()']");
    }

    public SelenideElement amountField() {
        return $("input[ng-model='amount']");
    }

    public SelenideElement depositButton() {
        return $("button[type='submit']").shouldHave(text("Deposit"));
    }

    public SelenideElement withdrawButton() {
        return $("button[type='submit']").shouldHave(text("Withdraw"));
    }

    public SelenideElement userName() {
        return $("span.fontBig.ng-binding");
    }

    public SelenideElement accountSelect() {
        return $("#accountSelect");
    }

    public SelenideElement transactionStatus() {
        return $("span.error.ng-binding");
    }

    public SelenideElement dateTimeSortChoose() {
        return $$("thead a").first();
    }

    public SelenideElement lastRowTransaction() {
        return $("table > tbody > tr");
    }

    public SelenideElement lastTransactionAmount() {
        return lastRowTransaction().$$("td").get(1);
    }

    public SelenideElement lastTransactionType() {
        return lastRowTransaction().$$("td").get(2);
    }

    public SelenideElement userBalance() {
        return $$("div[ng-hide='noAccount'] > strong").get(1);
    }


}

