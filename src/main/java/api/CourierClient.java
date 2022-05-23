package api;

import courier.Courier;

public class CourierClient extends RestAssuredClient {
    private final String ROOT = "/courier";
    private final String LOGIN = ROOT + "/login";
    private final String COURIER = ROOT + "/{courierId}";

    public boolean createCourier(Courier courier, int statusCode, String responseMessage){
        return  reqSpec
                .body(courier)
                .post(ROOT)
                .then()
                .assertThat()
                .statusCode(statusCode)
                .extract()
                .path(responseMessage);
    }
    public String processCourier(Courier courier,  int statusCode, String responseMessage){
        return  reqSpec
                .body(courier)
                .post(ROOT)
                .then()
                .assertThat()
                .statusCode(statusCode)
                .extract()
                .path(responseMessage);
    }
    public int loginCourier(CourierCredentials creds, int statusCode, String responseMessage ){
        return reqSpec
                .body(creds)
                .when()
                .post(LOGIN)
                .then()
                .assertThat()
                .statusCode(statusCode).log().all()
                .extract()
                .path(responseMessage);
    }

    public String loginCourierWithWrongParams(CourierCredentials creds, int statusCode, String responseMessage ){
        return reqSpec
                .body(creds)
                .when()
                .post(LOGIN)
                .then()
                .assertThat()
                .statusCode(statusCode).log().all()
                .extract()
                .path(responseMessage);
    }

    public void deleteCourier(int courierId, int statusCode){
        reqSpec
                .pathParam("courierId", courierId)
                .when()
                .delete(COURIER)
                .then()
                .log().all()
                .assertThat()
                .statusCode(statusCode);
    }
}