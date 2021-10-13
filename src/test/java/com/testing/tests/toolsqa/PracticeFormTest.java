package com.testing.tests.toolsqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.testing.tests.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.*;

@Test(groups = {"ToolsQA"})
@Owner("Андрей Жуков")
@Epic("Forms")
@Feature("Student registration form")
@Story("Проверка заполнения полей формы")
public class PracticeFormTest extends BaseTest {

    @Test(description = "Проверка заполнения полей формы")
    public void fillingFormFieldsTest() {
        Configuration.startMaximized = true;
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Dron");
        $("#lastName").setValue("Dronov");
        $("#userEmail").setValue("asdasd@sasdas.com");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("88005553535");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--009").click();
        $("#dateOfBirthInput").shouldHave(value("09 Dec 2000"));
        $("#submit").scrollTo();
        $("#subjectsInput").setValue("m");
        $$(".subjects-auto-complete__menu .subjects-auto-complete__option").find(text("Economics")).click();
        $("#hobbies-checkbox-1").setSelected(true);
        $("#hobbies-checkbox-3").setSelected(true);
    }
}
