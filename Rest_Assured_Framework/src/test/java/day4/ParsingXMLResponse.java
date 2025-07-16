package day4;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ParsingXMLResponse {
    @Test
    void testXMLResponse() {
//        given()
//                .when().get("https://mocktarget.apigee.net/xml")
//                .then().header("Content-Type", "application/xml; charset=utf-8")
//                .body("root.city", equalTo("San Jose"))
//                .body("root.firstName", equalTo("John"))
//                .log().all();
//    }

        Response res = given().when().get("https://mocktarget.apigee.net/xml");

        Assert.assertEquals(res.getStatusCode(), 200);
        Assert.assertEquals(res.header("Content-Type"), "application/xml; charset=utf-8");

        String cityName = res.xmlPath().get("root.city").toString();
        Assert.assertEquals(cityName, "San Jose");
    }


    @Test(priority = 2)
    void TestXMLResponseBody() {

        Response res = given().when().get("https://mocktarget.apigee.net/xml");

        XmlPath xmlobj = new XmlPath(res.asString());

        //Verifying to tal number of cities
        List<String> cityNames = xmlobj.getList("root.city");
        Assert.assertEquals(cityNames.size(),1);

    }
}