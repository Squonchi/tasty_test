package com.testing.tests.apitest.steps;

import com.testing.pojo.ColorResponse;

import java.util.List;

import static com.testing.utils.RestAPIHelper.sendGet;

public class ColorsSteps {
    public static List<ColorResponse> getColors() {
        return sendGet("/unknown", 200).jsonPath().getList("data", ColorResponse.class);
    }

    public static ColorResponse getColorByName(String colorName) {
        return sendGet("/unknown", 200).jsonPath().getObject("data.find{it.name=='" + colorName + "'}", ColorResponse.class);
    }
}
