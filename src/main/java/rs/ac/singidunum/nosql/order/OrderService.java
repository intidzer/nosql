package rs.ac.singidunum.nosql.order;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.nosql.customer.Address;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Order getOrdersById(String orderId){

        log.debug("getOrdersById | Order ID: {}", orderId);

        Optional<Order> order = orderRepository.findById(orderId);

        if (order.isPresent())
            return order.get();
        else
            throw new IllegalStateException("No order with ID: " + orderId + " found.");
    }

    public Order getOrderByCustomerId(String customerId) {

        log.debug("getOrderByCustomerId | Customer ID: {}", customerId);

        Optional<Order> result = orderRepository.findOrderByCustomerId(customerId);

        if (result.isPresent())
            return result.get();
        else
            throw new IllegalStateException("No result found");

    }

    public Order getOrderByOrderNo(Long orderNo) {

        log.debug("getOrderByOrderNo | OrderNo: {}", orderNo);

        Optional<Order> result = orderRepository.findOrderByOrderNo(orderNo);

        if (result.isPresent())
            return result.get();
        else
            throw new IllegalStateException("No result found");

    }

    public void updateOrder(String id, Integer amount, String newItemId, Address newAddress) {

        log.debug("Update Order: {}", id);

        Order order = orderRepository.findById(id).orElseThrow(
                () -> { throw new IllegalStateException("No order found with ID: " + id); }
        );

        if(newItemId != null && newItemId.length() > 0 && order.getOrderItemIds().get(newItemId) == null && amount != null && amount > 0)
            order.getOrderItemIds().put(newItemId, amount);
        if(newItemId != null && newItemId.length() > 0 && order.getOrderItemIds().get(newItemId) != null && amount != null && amount <= 0)
            order.getOrderItemIds().remove(newItemId);

        if (newAddress != null) {
            order.setAddress(newAddress);
        }

        orderRepository.save(order);

    }

    public void deleteOrder(String id) {

        log.debug("Delete Order: {}", id);

        orderRepository.findById(id).orElseThrow(
                () ->  { throw new IllegalStateException("No order found with ID: " + id); }
        );

        log.debug("Order deleted: {}", id);
        orderRepository.deleteById(id);

    }

    public void pushOrder(Order order) {

        if (orderRepository.findOrderByOrderNo(order.getOrderNo()).isPresent())
          throw new IllegalStateException("Order found with same order Number: " + order.getOrderNo());

        orderRepository.insert(order);

    }
}
