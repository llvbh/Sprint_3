package api;

import courier.Order;
import courier.Orders;

import static org.apache.http.HttpStatus.SC_CREATED;

public class OrderClient extends RestAssuredClient {

    private final String ROOT = "/orders";

    public int createNewOrder(Order order, int statusCode, String responseMessage){
        return reqSpec
                .body(order)
                .post(ROOT)
                .then()
                .log().all()
                .assertThat()
                .statusCode(statusCode)
                .extract()
                .path(responseMessage);
    }

    public Orders getAllOrders(Orders orders, int statusCode, String responseMessage ){
        return reqSpec
            .body(orders)
            .get(ROOT)
            .then()
            .log().all()
            .assertThat()
            .statusCode(statusCode)
            .extract()
            .path(responseMessage);
    }
}
