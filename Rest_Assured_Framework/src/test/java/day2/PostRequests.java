package day2;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PostRequests {
    String id;

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
//    @Test
//    void testJsonLibrary() {
//        JSONObject data = new JSONObject();
//        data.put("name", "Aditya");
//        data.put("gender", "Male");
//        data.put("physics", 55);
//        data.put("maths", 97);
//        data.put("english", 77);
//
//      Response response =  given().contentType("application/json")
//                .body(data.toString())
//                .when().post("http://localhost:3000/students");
//               id = response.jsonPath().getString("id");
//
//                response.then().statusCode(201)
//                .body("name", equalTo("Aditya"))
//                .body("gender", equalTo("Male"))
//                .body("physics", equalTo(55))
//                .body("maths", equalTo(97))
//                .body("english", equalTo(77))
//                .header("Content-Type", "application/json")
//                .log().all();
//
//
//    }


    //using POJO
//    @Test
//    void usingPojo() {
//        Pojo_PostRequest data = new Pojo_PostRequest();
//        data.setName("Riya");
//        data.setGender("Female");
//        data.setPhysics(55);
//        data.setMaths(97);
//        data.setEnglish(77);
//
//
//        Response response = given().contentType("application/json")
//                .body(data)
//                .when().post("http://localhost:3000/students");
//        id = response.jsonPath().getString("id");
//
//        response.then().statusCode(201)
//                .body("name", equalTo("Riya"))
//                .body("gender", equalTo("Female"))
//                .body("physics", equalTo(55))
//                .body("maths", equalTo(97))
//                .body("english", equalTo(77))
//                .header("Content-Type", "application/json")
//                .log().all();
//
//    }

    //using External Json File
    @Test
    void usingExternalJsonFile() throws Exception
    {
        File file = new File("TestData/body.json ");
        FileReader fr = new FileReader(file);
        JSONTokener jt = new JSONTokener(fr);
        JSONObject data = new JSONObject(jt);

        Response response = given().contentType("application/json")
                .body(data.toString())
                .when().post("http://localhost:3000/students");
        id = response.jsonPath().getString("id");

        response.then().statusCode(201)
                .body("name", equalTo("arun"))
                .body("gender", equalTo("Male"))
                .body("physics", equalTo(88))
                .body("maths", equalTo(87))
                .body("english", equalTo(78))
                .header("Content-Type", "application/json")
                .log().all();


    }


    @Test
    void createStudent() {

        JSONObject data = new JSONObject();
        data.put("name", "Aditya");
        data.put("gender", "Male");
        data.put("physics", 55);
        data.put("maths", 97);
        data.put("english", 77);

        given().contentType("application/json")
                .body(data)
                .when().get("http://localhost:3000/students")
                .then().statusCode(200)
                .log().all();
    }


    @Test(priority = 2, dependsOnMethods = {"usingExternalJsonFile"})
    void testDelete() {
        given()
                .when().delete("http://localhost:3000/students/" + id)
                .then().statusCode(200).log().all();

    }


}
