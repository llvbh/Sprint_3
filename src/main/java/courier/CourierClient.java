package courier;

public class CourierClient extends RestAssuredClient {
    private final String ROOT = "/courier";
    private final String LOGIN = ROOT + "/login";
    private final String COURIER = ROOT + "/{courierId}";

    public boolean create(Courier courier){
    return  reqSpec
            .body(courier)
            .post(ROOT)
            .then()
            .log().all()
            .assertThat()
            .statusCode(201)
            .extract()
            .path("ok");
    }

    public String createNoParams(Courier courier){
        return  reqSpec
                .body(courier)
                .post(ROOT)
                .then()
                .assertThat()
                .statusCode(400)
                .extract()
                .path("\"message\"");
    }
    public String createDublicatedLogin(Courier courier){
        return  reqSpec
                .body(courier)
                .post(ROOT)
                .then()
                .assertThat()
                .statusCode(409)
                .extract()
                .path("\"message\"");
    }

    public int login(CourierCredentials creds){
        return reqSpec
            .body(creds)
            .when()
            .post(LOGIN)
            .then()
            .assertThat()
            .statusCode(200).log().all()
            .extract()
            .path("id");
    }

    public void delete(int courierId){
        reqSpec
            .pathParam("courierId", courierId)
            .when()
            .delete(COURIER)
            .then()
            .log().all()
            .assertThat()
            .statusCode(200);
    }
}
