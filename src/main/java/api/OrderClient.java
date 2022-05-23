package api;

import courier.Order;
import courier.Orders;

import static org.apache.http.HttpStatus.SC_CREATED;

public class OrderClient extends RestAssuredClient {

    private final String ROOT = "/orders";

    public int createNewOrder(Order order){
        return reqSpec
                .body(order)
                .post(ROOT)
                .then()
                .log().all()
                .assertThat()
                .statusCode(SC_CREATED)
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
            .statusCode(SC_CREATED)
            .extract()
            .path("track");
    }
}
