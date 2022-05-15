import courier.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertNotEquals;

public class OrderTest {
    private OrderClient orderClient;
    private int orderId;
    @Before
    public void setUp() {
        orderClient = new OrderClient();
    }
    @Test
    @DisplayName("Check new order without color")
    public void newOrderWithNoColor() {
        Order  order = new Order("firstName", "lastName", "address", "metroStation", "88888888", 87,  "12.08.12", "DDDcomment", new String[]{""});
        orderId = orderClient.create(order);
        assertNotEquals(0, orderId);
    }
    @Test
    @DisplayName("Check new order with one color")
    public void newOrderWithOneColor() {
        Order  order = new Order("firstName", "lastName", "address", "metroStation", "88888888", 87,  "12.08.12", "DDDcomment", new String[]{"black"});
        orderId = orderClient.create(order);
        assertNotEquals(0, orderId);
    }
    @Test
    @DisplayName("Check new order with colors")
    public void newOrderWithTwoColor() {
        Order  order = new Order("firstName", "lastName", "address", "metroStation", "88888888", 87,  "12.08.12", "DDDcomment", new String[]{"black", "grey"});
        orderId = orderClient.create(order);
        assertNotEquals(0, orderId);
    }
    @Test
    @DisplayName("Get all orders")
    public void getAllOrders(){
        Orders  orders = new Orders();
        Orders ordersList = orderClient.getAllOrders(orders);
        assertNotEquals(0, ordersList);
    }
}
