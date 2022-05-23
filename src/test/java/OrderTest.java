import courier.Orders;
import courier.Order;
import api.OrderClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertNotEquals;

@RunWith(Parameterized.class)
public class OrderTest {
    private OrderClient orderClient;
    private int orderId;
    private final String[] color;

    public OrderTest(String[] color){
        this.color = color;
    }
    @Parameterized.Parameters
    public static Object[][] getColor() {
        return new Object[][] {
                {new String[]{"BLACK"}},
                {new String[] {"GREY"}},
                {new String[]{"BLACK", "GREY"}}
        };
    }
    @Before
    public void setUp() {
        orderClient = new OrderClient();
    }
    @Test
    //@DisplayName("Check create new order")
    public void createNewOrder() {
        Order order = new Order("firstName", "lastName", "address", "metroStation", "88888888", 87,  "12.08.12", "DDDcomment", color);
        orderId = orderClient.createNewOrder(order);
        assertNotEquals(0, orderId);
    }
    @Test
    //@DisplayName("Get all orders")
    public void getAllOrders(){
        Orders  orders = new Orders();
        Orders ordersList = orderClient.getAllOrders(orders);
        assertNotEquals(0, ordersList);
    }
}




