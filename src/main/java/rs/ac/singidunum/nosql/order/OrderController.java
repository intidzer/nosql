package rs.ac.singidunum.nosql.order;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.nosql.customer.Address;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/shop/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping(path = "/all")
    public List<Order> fetchAllProducts(){
        return orderService.getAllOrders();
    }

    @GetMapping(path = "{id}")
    public Order getOrderById(@PathVariable (name = "id") String id) {
        return orderService.getOrdersById(id);
    }

    @GetMapping(path = "/order/{orderNo}")
    public Order getOrderByOrderNubmer(@PathVariable (name = "orderNo") Long orderNo) {
        return orderService.getOrderByOrderNo(orderNo);
    }

    @GetMapping(path = "/customer/{id}")
    public Order getOrderByCustomerId(@PathVariable (name = "id") String id) {
        return orderService.getOrderByCustomerId(id);
    }

    @PostMapping(path = "/add")
    public void pushOrder(@RequestBody Order order){ orderService.pushOrder(order); }

    @PutMapping(path = {"/update/{id}"})
    public void updateOrder(@PathVariable (name = "id") String id,
                            @RequestParam (name = "amount", required = false) Integer amount,
                            @RequestParam (name = "newItemId", required = false) String newItemId,
                            @RequestBody (required = false) Address newAddress) {
        orderService.updateOrder(id, amount, newItemId, newAddress);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteOrder(@PathVariable (name = "id") String id) {
        orderService.deleteOrder(id);
    }

}
