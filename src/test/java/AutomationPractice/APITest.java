package AutomationPractice;

import RestAPIRahul.Payload;
import RestAPIRahul.ReusableMethods;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class APITest {
    //Validate if Add Place API is working as expected

    //given - all input details
    //when - Submit the API, http method
    //then - validate the response

    //content of the file to String



    @BeforeTest
    public void beforeTests() {
        baseURI = "https://rahulshettyacademy.com";

    }

    @Test
    public static void addNewPlace() throws IOException {
        //POST request

        String newPlaceResponse = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body(Payload.AddPlace()).when().post("maps/api/place/add/json").then().assertThat().statusCode(200)

                // If the Json file is on External location
                //.body(new String (Files.readAllBytes(Paths.get("C:\\Users\\Ievgen\\Documents\\addPlace.json")))).when().post("maps/api/place/add/json").then().assertThat().statusCode(200)
                .body("scope", equalTo("APP")).header("server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();

        //System.out.println("Response :" + response);
        JsonPath js = ReusableMethods.newPlaceResponse(newPlaceResponse);
        String placeId = js.getString("place_id");
        System.out.println("Place Id: " + placeId);



//   public void updatePlaceWithNewAddress()  PUT request
        String newAddress = "70 winter walk, USA";

        given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body("{\n" +
                        "\"place_id\":\"" + placeId + "\",\n" +
                        "\"address\":\"" + newAddress + "\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}")
                .when().put("maps/api/place/update/json")
                .then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));


//    public void getPlace() { GET - request
        String getPlaceResponse = given().log().all().queryParam("key", "qaclick123")
                .queryParam("place_id", placeId)
                .when().get("maps/api/place/get/json")
                .then()
                .assertThat().log().all().statusCode(200).extract().response().asString();

        JsonPath js1 = ReusableMethods.rawToJson(getPlaceResponse);
        String actualAddress = js1.getString("address");

        Assert.assertTrue(actualAddress.equals(newAddress));

    }
    @Test
    public void complexJsonParse() {
        JsonPath js = new JsonPath(Payload.coursePrice());

        //Print No of courses returned by API
        int count = js.getInt("courses.size()");
        System.out.println(count);

        //Print purchase amount
        int totalAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println(totalAmount);

        //Print title of the first course
        String firstCourseTitle = js.getString("courses[0].title");
        System.out.println(firstCourseTitle);
        System.out.println();

        // Print all course titles and their respective Price
        //String allCorsesInfo = js.getString("courses");
        for (int i = 0; i < count; i++) {
            String courseTitles = js.get("courses[" + i + "].title");
            int prices = js.get("courses[" + i + "].price");
            int copies = js.get("courses[" + i + "].copies");


            System.out.println("Course titles: " + " " + courseTitles + "; " + "price: " + prices + " " + " copies" + "; " + copies);
        }

        //Print No of copies sold by RPA Course
        for (int i = 0; i < count; i++) {
            String courseTitles = js.get("courses[" + i + "].title");
            if (courseTitles.equalsIgnoreCase("RPA")) {
                int copies = js.get("courses[" + i + "].copies");
                System.out.println("The numbers of copies RPA Course is: " + " " + copies);
            }

        }

    }

    @Test
    // Verify if Sum of all Course prices matches with Purchase Amount.
    public void sumOfCourses() {

        int sum = 0;
        JsonPath js = new JsonPath(Payload.coursePrice());
        int count = js.getInt("courses.size()");
        for(int i = 0; i < count; i++) {
            int price = js.get("courses["+i+"].price");
            int copies = js.get("courses["+i+"].copies");
            int amount = price * copies;
            System.out.println("Amount is :" + " " + amount);
            sum = sum + amount;

        }
        System.out.println(sum);
        int purchaseAmount = js.get("dashboard.purchaseAmount");
        Assert.assertEquals(sum, purchaseAmount);
    }

}
