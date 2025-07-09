package day2;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PostRequests {


//    //Using HashMap
//    @Test
//    void testPostHashMap() {
//        HashMap data = new HashMap();
//        data.put("name", "Aditya");
//        data.put("gender", "Male");
//        data.put("physics", 55);
//        data.put("maths", 97);
//        data.put("english", 77);
//
//        given().contentType("application/json")
//                .body(data)
//                .when().post("http://localhost:3000/students")
//
//
//                .then().statusCode(201)
//                .body("name", equalTo("Aditya"))
//                .body("gender", equalTo("Male"))
//                .body("physics", equalTo(55))
//                .body("maths", equalTo(97))
//                .body("english", equalTo(77))
//                .header("Content-Type", "application/json")
//
//
//                .log().all();
//
//
//    }

    //Using org.json library
    @Test
    void testJsonLibrary() {
        HashMap data = new HashMap();
        data.put("name", "Aditya");
        data.put("gender", "Male");
        data.put("physics", 55);
        data.put("maths", 97);
        data.put("english", 77);

        given().contentType("application/json")
                .body(data)
                .when().post("http://localhost:3000/students")


                .then().statusCode(201)
                .body("name", equalTo("Aditya"))
                .body("gender", equalTo("Male"))
                .body("physics", equalTo(55))
                .body("maths", equalTo(97))
                .body("english", equalTo(77))
                .header("Content-Type", "application/json")


                .log().all();


    }


    @Test
    void createStudent() {
        HashMap data = new HashMap();
        data.put("name", "Riya");
        data.put("gender", "Female");
        data.put("physics", 45);
        data.put("maths", 91);
        data.put("english", 17);
        given().contentType("application/json")
                .body(data)
                .when().get("http://localhost:3000/students")

                .then().statusCode(200)

                .log().all();
    }


    @Test(priority = 2, dependsOnMethods = {"testPostHashMap"})
    void testDelete() {
        given()
                .when().delete("http://localhost:3000/students/2")
                .then().statusCode(200).log().all();

    }


}
