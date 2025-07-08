package day1;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class HTTPRequest {
    int id;

    @Test(priority = 1)
    void getUsers() {
        given().header("x-api-key", "reqres-free-v1")
                .when().get("https://reqres.in/api/users?page=2")
                .then().statusCode(200)
                .body("page", equalTo(2))
                .log().all();
    }

    @Test(priority = 2)
    void createUser() {
        HashMap data = new HashMap();
        data.put("name", "Aditya");
        data.put("job", "QA Automation Engineer");


        id = given().contentType("application/json")
                .body(data)
                .header("x-api-key", "reqres-free-v1")
                .when().post("https://reqres.in/api/users").jsonPath().getInt("id");


    }

    @Test(priority = 3, dependsOnMethods = {"createUser"})
    void updateUser() {
        HashMap data = new HashMap();
        data.put("name", "Riya");
        data.put("job", "Web Developer");

        given().contentType("application/json")
                .body(data).header("x-api-key", "reqres-free-v1")
                .when().post("https://reqres.in/api/users/" + id)
                .then().statusCode(201).log().all();
    }

    @Test(priority = 4, dependsOnMethods = {"updateUser"})
    void deleteUser() {
        given().header("x-api-key", "reqres-free-v1")
                .when().delete("https://reqres.in/api/users/" + id)
                .then().statusCode(204).log().all();

    }

}
