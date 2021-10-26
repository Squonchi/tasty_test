package com.testing.tests.apitest;

import com.testing.pojo.UserPojo;
import com.testing.tests.BaseTest;
import com.testing.tests.apitest.steps.UserSteps;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;


@Test(groups = {"RestTest"})
@Owner("Жуков Андрей")
@Epic("Тестирование API reqres.in")
@Feature("Ресурс users")
@Story("Проверка email пользователя")
public class UserEmailTest extends BaseTest {

    @Test(description = "Проверка email пользователя")
    public void getUsers() {
        List<UserPojo> users = UserSteps.getUsers();
        checkEmail(users);
    }

    @Step("Проверка email полученного пользователя")
    private void checkEmail(List<UserPojo> users) {
        assertThat(users).extracting(UserPojo::getEmail).contains("george.bluth@reqres.in");

    }
}
