package day3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class LoggingDemo {

    private static final Logger log = LoggerFactory.getLogger(LoggingDemo.class);

    @Test
    void testLogs() {
        given()
                .when().get("https://www.google.com/")
                .then().log().cookies()
//                .log().body()
//                .log().headers()
                    ;

    }

}
