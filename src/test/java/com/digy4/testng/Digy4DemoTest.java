package com.digy4.testng;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Digy4DemoTest {

    @Test
    public void getTest() {
        doGetCall();
    }

    @Test
    public void putTest() {
        final Map<String, String> request = new HashMap<>();
        request.put("name", "Das");
        request.put("job", "QA");
        final String requestJson = new Gson().toJson(request);
        given().
                body(requestJson).
                when().
                put("https://reqres.in/api/users/2").
                then().statusCode(200);

        doGetCall();
    }

    @Test
    public void deleteTest() {
        given().
                body("{}").
                when().
                delete("https://reqres.in/api/users/2").
                then().statusCode(204);

        doGetCall();
    }

    private void doGetCall() {
        final Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        Assert.assertEquals(response.statusCode(), 200, "The API call failed.");
    }
}
