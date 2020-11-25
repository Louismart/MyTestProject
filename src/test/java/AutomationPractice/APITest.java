package AutomationPractice;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class APITest {
    //Validate if Add Place API is working as expected

    //given - all input details
    //when - Submit the API, http method
    //then - validate the response


    @BeforeTest
    public void beforeTests() {
        baseURI = "https://rahulshettyacademy.com";

    }

    @Test
    public void addNewPlace() {
        //PUT request


        given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"location\": {\n" +
                        "    \"lat\": -38.383494,\n" +
                        "    \"lng\": 33.427362\n" +
                        "  },\n" +
                        "  \"accuracy\": 50,\n" +
                        "  \"name\": \"Frontline house\",\n" +
                        "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                        "  \"address\": \"29, side layout, cohen 09\",\n" +
                        "  \"types\": [\n" +
                        "    \"shoe park\",\n" +
                        "    \"shop\"\n" +
                        "  ],\n" +
                        "  \"website\": \"http://google.com\",\n" +
                        "  \"language\": \"French-IN\"\n" +
                        "}").when().post("maps/api/place/add/json").then().log().all().assertThat().statusCode(200)
                .body("scope", equalTo("APP")).header("server", "Apache/2.4.18 (Ubuntu)");
    }
   @Test
   public void getPlace() {
       given().log().all().queryParam("key", "qaclick123", "place_id", "29c57fb2f5e697c4e704fab04d4a23d3").when().get("maps/api/place/get/json").then()
               .log().all().assertThat().statusCode(200);



   }
   @Test
   public void updatePlaceWithNewAddress() {

       given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
               .body("{\n" +
                       "\"place_id\":\"29c57fb2f5e697c4e704fab04d4a23d3\",\n" +
                       "\"address\":\"70 winter walk, USA\",\n" +
                       "\"key\":\"qaclick123\"\n" +
                       "}")
               .when().put("maps/api/place/update/json").then().log().all().assertThat().statusCode(200);

   }

}
