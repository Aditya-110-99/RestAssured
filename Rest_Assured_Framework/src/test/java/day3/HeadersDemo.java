package day3;


import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class HeadersDemo
{

    @Test
    void getHeaders() {
        Response res = given().when().get("https://www.google.com/");

        res.then()
                .header("Content-Type", "text/html; charset=ISO-8859-1")
                .header("Content-Encoding", "gzip")
                .header("Server", "gws")
                .log().all();
    }


    @Test(priority = 2)
    void captureHeader() {
        Response res = given()
                .when().get("https://www.google.com/");

        //Capturing the value of single header
        String headerValue = res.getHeader("Content-Security-Policy-Report-Only");
        System.out.println("Value of Content-Security-Policy-Report-Only is : ====== " + headerValue);

    }


    @Test(priority = 3)
    void getAllHeadersValue() {

        Response res = given()
                .when().get("https://www.google.com/");
        Headers allHeaders = res.getHeaders();

        for (Header header : allHeaders) {
            System.out.println(header.getName() + "      " + header.getValue());
        }

    }
}
