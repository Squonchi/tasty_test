package com.testing.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.jetbrains.annotations.NotNull;

import static io.restassured.RestAssured.given;

public class RestAPIHelper {
    private static final RequestSpecification REQ_SPEC =
            new RequestSpecBuilder()
                    .setBaseUri("https://reqres.in/api")
                    .setContentType("application/json; charset=UTF-8")
                    .build();

    public static Response sendGet(@NotNull String path, Integer expectedCode) {
        return given()
                .spec(REQ_SPEC)
                .basePath(path)
                .when().get()
                .then()
                .log().body()
                .statusCode(expectedCode)
                .extract().response();
    }

    public static Response sendPost(Object body, String path, Integer expectedCode) {
        return given()
                .spec(REQ_SPEC)
                .basePath(path)
                .body(body)
                .when().post()
                .then()
                .log().body()
                .statusCode(expectedCode)
                .extract().response();
    }

}
