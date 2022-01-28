package rs.ac.singidunum.nosql.customer;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/shop/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/all")
    public List<Customer> fetchAllProducts(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/emailSearch/{email}")
    public Customer getCustomerByEmail(@PathVariable (name = "email") String email) {
        return customerService.getCustomerByEmail(email);
    }

    @GetMapping("/phoneSearch/{phone}")
    public Customer getCustomerByName(@PathVariable (name = "phone") String phone) {
        return customerService.getCustomerByPhone(phone);
    }

    @PostMapping(path = "/add")
    public void pushCustomer(@RequestBody Customer customer){ customerService.pushCustomer(customer); }

    @PutMapping(path = {"/update/{id}"})
    public void updateCustomer(@PathVariable (name = "id") String id,
                            @RequestParam (name = "email", required = false) String email,
                            @RequestParam (name = "name", required = false) String name,
                            @RequestParam (name = "lastname", required = false) String lastname,
                            @RequestParam (name = "phone", required = false) String phone,
                            @RequestBody (required = false) Address newAddress) {
        customerService.updateCustomer(id, email, name, lastname, phone, newAddress);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteCustomer(@PathVariable (name = "id") String id) {
        customerService.deleteCustomer(id);
    }

}
