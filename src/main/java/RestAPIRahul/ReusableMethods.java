package RestAPIRahul;

import io.restassured.path.json.JsonPath;

//method allows to reuse it in different Test classes
public class ReusableMethods {

    public static JsonPath newPlaceResponse(String response) {

        JsonPath js = new JsonPath(response); // for parsing Json
        return js;
    }

    public static JsonPath rawToJson(String response) {

        JsonPath js1 = new JsonPath(response);  // for parsing Json
        return js1;
    }
}
