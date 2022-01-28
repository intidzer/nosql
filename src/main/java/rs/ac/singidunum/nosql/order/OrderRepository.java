package rs.ac.singidunum.nosql.order;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

    Optional<Order> findOrderByCustomerId(String customerId);

    Optional<Order> findOrderByOrderNo(Long orderNo);

}
