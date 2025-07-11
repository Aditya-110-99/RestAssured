package day3;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.*;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Cookies {
    @Test
    void testCookies() {

        given()
                .when().get("https://www.google.com/")
                .then().cookie("AEC", "AVh_V2giOrvDQWhnoeQ4AivN45wD08T0soa-An3HfDe8dDDoefo4f5n3a30")
                .log().all();
    }


    @Test
    void getCookieValue() {
        Response res = given()
                .when().get("https://www.google.com/");

        //to get single cookie
//      String cookieValue = res.getCookie("AEC");
//        System.out.println("Value of cookies is -------------->" + cookieValue);


        Map<String, String> cookiesData = res.getCookies();
        for (String keys : cookiesData.keySet()) {
            String cookieValue = res.getCookie(keys);
            System.out.println(keys + "     " + cookieValue);
        }

    }





}
