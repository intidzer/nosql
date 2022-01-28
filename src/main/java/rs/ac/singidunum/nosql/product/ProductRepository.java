package rs.ac.singidunum.nosql.product;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    Optional<List<Product>> findProductsByCategory(String name);

    Optional<Product> findProductById(String id);

    Optional<List<Product>> findProductByIdIn(List<String> ids);

    Optional<Product> findProductByName(String name);

    @Query(value = "{ $and: [  " +
                        "{ $or: [ { null: ?0 }, { 'category': { $regex: /?0/, $options: 'i' } } ] }, " +
                        "{ $or: [ { $where: '?1 == null' }, { 'price': { $gte: ?1 } } ] }," +
                        "{ $or: [ { $where: '?2 == null' }, { 'price': { $lte: ?2 } } ] } " +
                    "] }")
    Optional<List<Product>> findProductsByCategoryAndPrice(String category, Long from, Long to);

    Optional<List<Product>> findProductsByPriceBetween(Long from, Long to);

    Optional<List<Product>> findProductsByPriceLessThan(Long maxPrice);

    Optional<List<Product>> findProductsByPriceGreaterThan(Long minPrice);

}
