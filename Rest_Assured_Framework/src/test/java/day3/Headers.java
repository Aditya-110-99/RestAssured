package day3;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.*;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Headers {

    @Test
    void getHeaders() {
        Response res = given()
                .when().get("https://www.google.com/");
        res.getHeaders();
    }
}
