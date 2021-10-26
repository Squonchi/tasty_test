package com.testing.tests.apitest.steps;

import com.testing.pojo.AddUserRequestPojo;
import com.testing.pojo.AddUserResponsePojo;
import com.testing.pojo.UserPojo;

import static com.testing.utils.RestAPIHelper.*;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserSteps {
    public static List<UserPojo> getUsers() {
        return sendGet("/users", 200)
                .jsonPath().getList("data", UserPojo.class);
    }

    public static AddUserResponsePojo postUser(AddUserRequestPojo body) {
        return sendPost(body, "/users", 201).then().extract().as(AddUserResponsePojo.class);
    }
}
