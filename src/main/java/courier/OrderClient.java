package courier;

public class OrderClient extends RestAssuredClient {
    private final String ROOT = "/orders";

    public int create(Order order){
        return  reqSpec
                .body(order)
                .post(ROOT)
                .then()
                .log().all()
                .assertThat()
                .statusCode(201)
                .extract()
                .path("track");
    }

    public Orders getAllOrders(Orders orders){
        return reqSpec
            .body(orders)
            .get(ROOT)
            .then()
            .log().all()
            .assertThat()
            .statusCode(200)
            .extract()
            .path("track");
    }
}
