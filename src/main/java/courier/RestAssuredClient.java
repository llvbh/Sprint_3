package courier;

import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class RestAssuredClient {
    protected final String URL = "http://qa-scooter.praktikum-services.ru/api/v1";

    protected final RequestSpecification reqSpec =  given()
         .header("Content-type", "application/json").baseUri(URL);
}
