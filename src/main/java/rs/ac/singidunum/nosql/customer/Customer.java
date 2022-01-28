package rs.ac.singidunum.nosql.customer;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(value = "customer")
public class Customer {

    @Id
    String id;
    @Indexed(unique = true)
    String email;
    String name;
    String lastname;
    Address address;
    @Indexed(unique = true)
    String phone;

    public Customer(String email, String name, String lastname, Address address, String phone) {
        this.email = email;
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.phone = phone;
    }

}
