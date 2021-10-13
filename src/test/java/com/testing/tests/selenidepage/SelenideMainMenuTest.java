package com.testing.tests.selenidepage;


import com.testing.pages.SelenidePage;
import com.testing.tests.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

@Test(groups = {"SelenidePage"})
@Owner(value = "Жуков Андрей")
@Epic("Сайт Selenide")
@Feature("Страница документации")
@Story("Проверка надписи под хедером")
public class SelenideMainMenuTest extends BaseTest {
    SelenidePage page = new SelenidePage();

    @Test(enabled = false)
    public void testSearchVTBWithGoogle() {
        open("https://google.ru");
        element(byName("q")).setValue("vtb").pressEnter();
        elements("#search .g").shouldHave(sizeGreaterThan(2)).first().shouldHave(text("Банк ВТБ (ПАО) (Объединенные ВТБ , ВТБ24 и Банк Москвы)"))
                .$(".yuRUbf>a").click();
    }


    @Test(enabled = false)
    public void testSearchSelenideWithXPath() {
        $x("//input[@name='q']").setValue("selenide").pressEnter();
        $$x("//h3[@class='LC20lb DKV0Md']").first().shouldHave(text("Selenide: лаконичные и стабильные UI тесты на Java"))
                .click();
        switchTo().window("Selenide: лаконичные и стабильные UI тесты на Java");
        $x("//ul[@class='main-menu-pages']//a[contains(text(), 'Док')]").click();
        $x("//div[@class='wrapper-color-content']/h4").shouldHave(text("Плохой софт не имеет документации. Отличный софт не нуждается в документации."));
    }

    @Test(enabled = false)
    public void testSearchSelenideWithCSS() {
        searchWordWithGoogle("selenide");
        openSomeGoogleResult(0);
        page.openMainMenuElement(1);
        page.checkCaptionUnderHeader();
    }

    @BeforeClass
    public void openSelenidePage() {
        searchWordWithGoogle("selenide");
        openSomeGoogleResult(0);
    }

    @DataProvider(name = "main_menu_elements")
    private Object[][] mainMenuElements() {
        return new Object[][]{{0, "С чего начать?"}, {1, "Кок"}, {2, "ЧАВО"}, {3, "Блог"}, {4, "Javadoc"}, {5, "Пользователи"}, {6, "Отзывы"}};
    }

    @Test(dataProvider = "main_menu_elements", description = "Проверка элементов навигационного меню")
    public void dataProviderTest(int index, String name) {
        page.mainMenuPages().get(index).shouldHave(text(name));
    }
}
