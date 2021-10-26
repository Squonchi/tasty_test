package com.testing.tests.apitest;

import com.testing.pojo.ColorResponse;
import com.testing.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.testing.tests.apitest.steps.ColorsSteps.getColorByName;
import static io.restassured.RestAssured.given;

@Test(groups = {"RestTestColor"})
public class ColorTest extends BaseTest {

    @DataProvider(name = "color_name")
    public Object[][] colorNameData() {
        return new Object[][] {{"cerulean", "#98B2D1"}, {"fuchsia rose", "#C74375"}, {"true red", "#BF1932"},
                            {"aqua sky", "#7BC4C4"}, {"tigerlily", "#E2583E"}, {"blue turquoise", "#53B0AE"}};
    }

    @Test(dataProvider = "color_name")
    public void colorNameEqual(String name, String color) {
        ColorResponse rs = getColorByName(name);
        Assert.assertEquals(rs.getColor(), color);
    }
}
