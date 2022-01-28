package rs.ac.singidunum.nosql.customer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {

    String country;
    String city;
    Integer postalCode;
    String street;

}
