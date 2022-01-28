package rs.ac.singidunum.nosql.customer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer getCustomerByEmail(String email) {

        log.debug("getProductsByEmail: {}", email);

        Optional<List<Customer>> customers = customerRepository.findCustomersByEmail(email);

        return chechUserSearch(customers, "email");
    }

    public Customer getCustomerByPhone(String phone) {

        log.debug("getProductsByEmail: {}", phone);

        Optional<List<Customer>> customers = customerRepository.findCustomersByPhone(phone);

        return chechUserSearch(customers, "phone");

    }

    private Customer chechUserSearch(Optional<List<Customer>> customers, String searchType) {

        if (customers.isPresent() && customers.get().size() > 1) {
            throw new IllegalStateException("More than 1 user has this " + searchType);
        } else if (customers.isEmpty() || customers.get().size() == 0) {
            throw new IllegalStateException("No user with this " + searchType +" found");
        } else {
            return customers.get().get(0);
        }
    }

    public void pushCustomer(Customer customer) {

        if (customerRepository.findCustomersByEmail(customer.email).isPresent())
            throw new IllegalStateException("Customer found with same email: " + customer.email);
        else if (customerRepository.findCustomersByPhone(customer.phone).isPresent())
            throw new IllegalStateException("Customer found with same phone: " + customer.phone);

        customerRepository.insert(customer);

    }

    public void updateCustomer(String id, String email, String name, String lastname, String phone, Address newAddress) {

        log.debug("updateCustomer | the user: {}", id);

        Customer customer = customerRepository.findById(id).orElseThrow(
                () -> {  throw new IllegalStateException("No user with ID: " + id + " found"); }
        );

        if (email != null && email.length() > 0 && !Objects.equals(customer.email, email)) {
            customer.setEmail(email);
        }
        if (name != null && name.length() > 0 && !Objects.equals(customer.lastname, lastname)) {
            customer.setName(name);
        }
        if (lastname != null && lastname.length() > 0 && !Objects.equals(customer.lastname, lastname)) {
            customer.setLastname(lastname);
        }
        if (phone != null && phone.length() > 0 && !Objects.equals(customer.phone, phone)) {
            customer.setPhone(phone);
        }
        if (newAddress != null && !Objects.equals(customer.address, newAddress)) {
            customer.setAddress(newAddress);
        }

        log.debug("Saving changes to the user: {}", id);

        customerRepository.save(customer);

    }

    public void deleteCustomer(String id) {

        log.debug("Delete customer Id: {}", id);

        customerRepository.findById(id).orElseThrow(
                () ->  { throw new IllegalStateException("No Customer found with ID: " + id); }
        );

        log.debug("Customer deleted: {}", id);
        customerRepository.deleteById(id);

    }
}
