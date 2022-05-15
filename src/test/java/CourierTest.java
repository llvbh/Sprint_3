import courier.Courier;
import courier.CourierClient;
import courier.CourierCredentials;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import io.qameta.allure.junit4.DisplayName;

public class CourierTest {
    private CourierClient courierClient;
    private int courierId;
    private String messageWithError;

    @Before
    public void setUp() {
        courierClient = new CourierClient();
    }
    @After
    public void tearDown(){
        if(courierId > 0) {courierClient.delete(courierId);}
    }
    @Test
    @DisplayName("Check courier add method With No Params")
    public void addCourierWithNoParams() {
        Courier courier = new Courier(null, "", "");
        String created = courierClient.createNoParams(courier);
        assertEquals("Недостаточно данных для создания учетной записи", created);
    }
    @Test
    @DisplayName("Check courier add method With all Params")
    public void addCourier() {
        Courier courier = Courier.getRandomValues();
        boolean created = courierClient.create(courier);

        CourierCredentials creds = CourierCredentials.from(courier);

        courierId = courierClient.login(creds);
        messageWithError = courierClient.createDublicatedLogin(courier);

        assertTrue(created);
        assertNotEquals(0, courierId);
        assertEquals("Этот логин уже используется. Попробуйте другой.", messageWithError);

    }
}
