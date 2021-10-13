package com.testing.tests.xyzbank;

import com.codeborne.selenide.Selenide;
import com.testing.pages.XYZBankPage;
import com.testing.tests.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

@Test(groups = {"XYZBank"})
@Owner("Андрей Жуков")
@Epic("Журнал транзанкций")
@Feature("Создание депозита")
@Story("Проверка создания нового депозита")
public class AddNewDepositeTest extends BaseTest {
    XYZBankPage page = new XYZBankPage();

    @Test(description = "Проверка создания нового депозита")
    public void testAddingNewDeposite() throws InterruptedException {

        open("https://www.globalsqa.com/angularJs-protractor/BankingProject");
        page.customerLoginButton().click();
        page.userSelectList().selectOption(1);
        String username = page.userSelectList().getSelectedOption().text();
        page.loginButton().click();
        page.userName().shouldHave(text(username));
        int startBalance = Integer.parseInt(page.userBalance().text());
        page.depositChooseButton().click();
        int addedBalance = 666;
        page.amountField().setValue(Integer.toString(addedBalance));
        page.depositButton().click();
        int expectedBalance = startBalance + addedBalance;
        page.userBalance().shouldHave(text(Integer.toString(expectedBalance)));
        page.transactionStatus().shouldHave(text("Deposit Successful"));
        page.transactionsChooseButton().click();
        page.dateTimeSortChoose().click();
        page.lastTransactionAmount().shouldHave(text("666"));
        page.lastTransactionType().shouldHave(text("Credit"));
    }
}
