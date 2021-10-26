package com.testing.tests.apitest;

import com.testing.pojo.AddUserRequestPojo;
import com.testing.pojo.AddUserResponsePojo;
import com.testing.tests.BaseTest;
import com.testing.tests.apitest.steps.UserSteps;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


@Test(groups = {"RestTest"})
@Owner("Жуков Андрей")
@Epic("Reqres.in")
@Feature("Users")
@Story("Проверка имени нового пользователя")
public class NewUserNameTest extends BaseTest {

    @Test(description = "Создание нового пользователя")
    public void postUser() {
        AddUserRequestPojo rq = new AddUserRequestPojo();
        rq.setName("Dron");
        rq.setJob("test");
        AddUserResponsePojo rs = UserSteps.postUser(rq);
        checkName(rs);
    }

    @Step("Проверка имени пользователя в ответе")
    private void checkName(AddUserResponsePojo rs) {
        assertThat(rs).extracting(AddUserResponsePojo::getName).isEqualTo("Dron");
    }
}
