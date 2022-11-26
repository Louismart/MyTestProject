package AutomationPractice;

import RestAPIRahul.Payload;
import RestAPIRahul.ReusableMethods;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class DynamicJsonTest {

    @DataProvider(name = "booksData")
    public static Object[][] booksDataProvider() {
        return new Object[][] {{"ojfrftwgty", "923763"}, {"cwevsdtte", "42253"}, {"okmfvbdet", "48433"}};
    }

    @BeforeTest
    public void beforeTests() {
        baseURI = "http://216.10.245.166";

    }

    //Add new 3 books  , using DataProvider annotation
    @Test(dataProvider = "booksData")
    public void addBookTest(String isbn, String aisle ) {

        String response = given().header("Content-Type", "application/json").
                body(Payload.Addbook(isbn, aisle))
                .when()
                .post("/Library/Addbook.php")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();
        JsonPath js = ReusableMethods.rawToJson(response);
        String book_id = js.get("ID");
        System.out.println("ID : " + book_id);

        //delete book using the @DataProvider

        String deleteBookResponse = given().log().all()
                .queryParam(" ID",book_id )
                .when().delete("/Library/Addbook.php")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();


    }





}
