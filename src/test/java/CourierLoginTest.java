import api.CourierClient;
import courier.Courier;
import api.CourierCredentials;
import org.junit.*;
import static org.junit.Assert.*;
//import io.qameta.allure.junit4.DisplayName;

public class CourierLoginTest {
    private CourierClient courierClient;
    private int courierId;
    private String messageWithError;

    @Before
    public void setUp() {
        courierClient = new CourierClient();
    }
     @Test
    //DisplayName("Check courier Login method")
    public void checkLoginCourier(){
        try{
            Courier courier = new Courier("Ibyrai_science", "qwerty12", "Altynsarin");
            CourierCredentials cred = CourierCredentials.from(courier);
            courierId = courierClient.loginCourier(cred, 200, "id");
            assertNotEquals(0, courierId);
        }
        finally{
            System.out.println("+++++++++++");
            System.out.println(courierId);
            if(courierId > 0) {courierClient.deleteCourier(courierId, 200);}

            System.out.println("-----------");
        }
    }
    @Test
    //DisplayName("Check courier Login method Without Pass")
    public void checkLoginCourierWithoutPass(){
        Courier courier = new Courier("Ibyrai", "", "Altynsarin");
        CourierCredentials cred = CourierCredentials.from(courier);
        String courierIdNotFound = courierClient.loginCourierWithWrongParams(cred, 400, "\"message\"");
        assertEquals("Недостаточно данных для входа", courierIdNotFound);
    }
    @Test
    //DisplayName("Check courier With Wrong Params")
    public void checkLoginCourierWithWrongParams(){
        Courier courier = new Courier("Ddd123", "1234", "Dick");
        CourierCredentials cred = CourierCredentials.from(courier);
        String courierIdNotFound = courierClient.loginCourierWithWrongParams(cred, 404, "\"message\"");
        assertEquals("Учетная запись не найдена", courierIdNotFound);
    }
}
