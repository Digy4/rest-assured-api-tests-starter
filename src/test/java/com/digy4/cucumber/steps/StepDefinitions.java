package com.digy4.cucumber.steps;

import com.google.gson.Gson;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class StepDefinitions {

    @Given("the get call is made")
    public void get() {
        doGetCall();
    }

    @And("the put call is made")
    public void put() {
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

    @And("the delete call is made")
    public void delete() {
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
