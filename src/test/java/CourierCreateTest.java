import api.CourierClient;
import courier.Courier;
import org.junit.*;
import static org.junit.Assert.*;
import io.qameta.allure.junit4.DisplayName;

public class CourierCreateTest {

    private CourierClient courierClient;
    private String messageWithError;

    @Before
    public void setUp() {
        courierClient = new CourierClient();
    }

    @Test
    @DisplayName("Check courier add method With all Params")
    public void checkCreateCourier(){
        Courier courier = new Courier("Ibyrai_science1", "qwerty12", "Altynsarin");
        boolean createCourier = courierClient.createCourier(courier, 201, "ok");
        assertTrue(createCourier);
    }

    @Test
    @DisplayName("Check courier add method With dublicate params")
    public void checkCreateCourierWithSameParams(){
            Courier courier = new Courier("Ibyrai_science", "qwerty12", "Altynsarin");
            messageWithError = courierClient.processCourier(courier, 409, "\"message\"");
            assertEquals("Этот логин уже используется. Попробуйте другой.", messageWithError);
    }

    @Test
    @DisplayName("Check courier add method Without Login")
    public void checkCreateCourierWithNoLogin() {
        Courier courier = new Courier("", "vdfvdf", "Konil");
        String emptyLoginCourier = courierClient.processCourier(courier, 400, "\"message\"");
        assertEquals("Недостаточно данных для создания учетной записи", emptyLoginCourier);
    }

    @Test
    @DisplayName("Check courier add method Without Pass")
    public void checkCreateCourierWithNoPass() {
        Courier courier = new Courier("David", "", "Konil");
        String emptyPassCourier = courierClient.processCourier(courier, 400, "\"message\"");
        assertEquals("Недостаточно данных для создания учетной записи", emptyPassCourier);
    }
}
