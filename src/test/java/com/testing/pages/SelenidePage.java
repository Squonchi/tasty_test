package com.testing.pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.testing.tests.BaseTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SelenidePage {
    protected BaseTest test;

    /*public SelenidePage(BaseTest test) {
        this.test = test;
    }*/

    public SelenideElement body() {
        return $("body").as("Тело страницы");
    }

    public ElementsCollection mainMenuPages() {
        return body().$(".main-menu-pages").$$("li").as("Меню навигации");
    }

    public SelenideElement bigCaptionUnderHeader() { return $(".wrapper-color-content"); }


    public void openMainMenuElement(int index) {
        mainMenuPages().get(index).click();
    }

    public void checkCaptionUnderHeader() {
        bigCaptionUnderHeader().$("h4")
                .shouldHave(text("Плохой софт не имеет документации. Отличный софт не нуждается в документации."));
    }
}
