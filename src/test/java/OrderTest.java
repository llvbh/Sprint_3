import courier.Orders;
import courier.Order;
import api.OrderClient;
import io.qameta.allure.junit4.DisplayName;
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
    //Алеся, помогите пожалуйста, на уроках по параметризованным тестам, мы не создавали массив строк отдельно new String[],
    // а здесь помогло только добавление new String[] перед аргументами. Где можно подробее про это почитать ?
    //на уроке было так, что сейчас приводит к ошибке missing argument:  public static Object[][] getTextData() {
    //        return new Object[][] { {"test ", "test"} }; }
    @Before
    public void setUp() {
        orderClient = new OrderClient();
    }
    @Test
    @DisplayName("Check create new order")
    public void createNewOrder() {
        Order order = new Order("Beckham1", "Beckham1", "address", "metroStation", "88888888", 87,  "12.08.12", "DDDcomment", color);
        orderId = orderClient.createNewOrder(order, 201, "track");
        assertNotEquals(0, orderId);
    }
    @Test
    @DisplayName("Get all orders")
    public void getAllOrders(){
        Orders  orders = new Orders();
        Orders ordersList = orderClient.getAllOrders(orders, 200, "track");
        assertNotEquals(0, ordersList);
    }
}




