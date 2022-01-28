package rs.ac.singidunum.nosql.order;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import rs.ac.singidunum.nosql.customer.Address;

import java.time.LocalDateTime;
import java.util.HashMap;

@Data
public class Order {

    @Id
    String id;
    @Indexed(unique = true)
    Long orderNo;
    String customerId;
    Address address;
    OrderStatus status;
    LocalDateTime order_time;
    HashMap<String, Integer> orderItemIds;

    public Order(Long orderNo, String customerId, OrderStatus status, LocalDateTime order_time, HashMap<String, Integer> orderItemIds) {
        this.orderNo = orderNo;
        this.customerId = customerId;
        this.status = status;
        this.order_time = order_time;
        this.orderItemIds = orderItemIds;
    }
}
