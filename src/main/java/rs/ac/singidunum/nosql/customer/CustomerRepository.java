package rs.ac.singidunum.nosql.customer;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

    Optional<List<Customer>> findCustomersByPhone(String phone);

    Optional<List<Customer>> findCustomersByEmail(String email);

}
