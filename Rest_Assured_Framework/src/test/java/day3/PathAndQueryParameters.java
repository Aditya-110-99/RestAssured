package day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class PathAndQueryParameters {
// https://reqres.in/api/users?page=2&id=5
    @Test
    void testQueryAndPathParameters()
    {
        given().header("x-api-key", "reqres-free-v1")
                .pathParam("mypath","users")
                .queryParam("page",2)
                .queryParam("id",5)
                .when().get("https://reqres.in/api/{mypath}")
                .then().statusCode(200).log().all();
    }
}
