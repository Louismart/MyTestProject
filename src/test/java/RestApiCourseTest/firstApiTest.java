package RestApiCourseTest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

/*
spec for this API under test https://punkapi.com/documentation/v2
 */
public class firstApiTest {

    private static RequestSpecification requestSpec;
    private static final int PER_PAGE = 80;

    @BeforeClass
    public static void createRequestSpecification() {
        requestSpec = new RequestSpecBuilder().
                setBaseUri("https://api.punkapi.com").
                setBasePath("v2").
                setAccept(ContentType.TEXT).
                setBody("test").// Works for POST, PUT and DELETE requests, here for GET just example
                build();
    }

    //https://api.punkapi.com/v2/beers?page=2&per_page=80
    @Test
    public void test() {
        given().
                spec(requestSpec).
                pathParam("endpoint", "beers").
                param("page", 2).
                param("per_page", 80).
                log().all().
                get("{endpoint}").
                then().
                log().
                body().
                statusCode(200);
    }

    @Test
    public void test1() {
        given().
                log().headers().
                // all().
                        when().
                get("https://google.com").
                then().log().all().
                statusCode(200);
    }

    @Test
    public void test2() {
        when().
                get("https://google.com").
                then().log().headers().
                statusCode(200);
    }

    //https://api.punkapi.com/v2/beers?page=2&per_page=80
    @Test
    public void testWithParameters3() {
        given().
                pathParam("endpoint", "beers").
                param("per_page", 76).
                param("page", 2).
                when().
                get("https://api.punkapi.com/v2/{endpoint}").
                then().
                log().
                body().
                statusCode(200);
    }

    //https://api.punkapi.com/v2/beers?page=2&per_page=80
    @Test
    public void testWithPathParameters4() {
        given().
                pathParam("endpoint", "beers").
                pathParam("xyz", "abc").
                when().
                get("https://api.punkapi.com/v2/{endpoint}/{xyz}").
                then().
                log().body().
                statusCode(200);
    }

    @Test
    public void testWithPathParameters5() {
        given().
                accept(ContentType.JSON).
                pathParam("endpoint", "beers").
                param("page", 4).
                param("per_page", 80).
                log().
                headers().
                when().
                get("https://api.punkapi.com/v2/{endpoint}").
                then().
                log().
                body().
                statusCode(200);
    }

    @Test
    public void testWithHeaders() {
        given().
                header("x", "y").
                accept(ContentType.TEXT).log().headers().
                pathParam("endpoint", "beers").
                param("page", 2).
                param("per_page", 80).
                when().
                get("https://api.punkapi.com/v2/{endpoint}").
                then().
                log().
                body().
                statusCode(200);

    }
    //https://api.punkapi.com/v2/beers?page=2&per_page=80
    @Test
    public void badRequestTest1() {
        given().
                header("x", "y").
                accept(ContentType.TEXT).log().headers().
                pathParam("endpoint", "beers").
                param("page", 0). //change to invalid parameter
                param("per_page", 80).
                when().
                get("https://api.punkapi.com/v2/{endpoint}").
                then().
                log().
                all().
                statusCode(400);

    }

    @Test
    public void badRequestTest2() {
        given().
                when().
                get("https://api.punkapi.com/v2/beers?brewed_before=11-2012&abv_gt=").  //parameter was deleted
                then().log().all().
                statusCode(400);
    }

    @Test
    public void selectedBeerTest() {
        given().
                when().
                get("https://api.punkapi.com/v2/beers?ids=22|23|45").  //parameter was deleted
                then().log().all().
                statusCode(200);
    }
}

