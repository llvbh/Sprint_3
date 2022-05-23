package courier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Order{
    private String firstName;
    private String lastName;
    private String address;
    private String metroStation;
    private String  phone;
    private int rentTime;
    private String deliveryDate;
    private String comment;
    private  String[] color;

    public Order() {
    }

    public Order(String firstName, String lastName, String address, String metroStation, String phone, int rentTime, String deliveryDate, String comment, String[] color) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentTime = rentTime;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
        this.color = color;
    }
}

