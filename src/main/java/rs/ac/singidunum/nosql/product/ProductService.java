package rs.ac.singidunum.nosql.product;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(String id) {

        log.debug("getProductById | ID: {}", id);

        Optional<Product> result = productRepository.findProductById(id);
        if(!result.isPresent()) {
            throw new IllegalStateException("No item with this id found");
        }
        return result.get();
    }

    public List<Product> getProductByOrderId(List<String> orderIds) {

        log.debug("getProductByOrderId | orderId: {}", Arrays.toString(orderIds.toArray()));

        Optional<List<Product>> result = productRepository.findProductByIdIn(orderIds);
        if (result.isPresent() && result.get().size() > 0)
            return result.get();
        else
            throw new IllegalStateException("No result found");
    }

    public List<Product> getProductsByCategory(String category){

        log.debug("getProductsByCategory | category: {}", category);

        Optional<List<Product>> products = productRepository.findProductsByCategory(category);
        if(!products.isPresent()){
            throw new IllegalStateException("No item in this category found");
        }
        return products.get();
    }

    public List<Product> getProductsByFilter(String category, Long priceMax, Long priceMin) {

        log.debug("getProductsByFilter | Category: {} | Min: {} | Max: {}", category, priceMin, priceMax);

        Optional<List<Product>> result = productRepository.findProductsByCategoryAndPrice(category, priceMin, priceMax);

        if (result.isPresent() && result.get().size() > 0)
            return result.get();
        else
            throw new IllegalStateException("No result found");

    }

    public void updateProduct(String id, String name, String category, Integer available, Long price, Integer rating, HashMap<String, String> characteristics) {

        log.debug("updateProduct | {}, {}, {}, {}. {}. {}. {}", id, name, category, available, price, rating, characteristics);

        Product result = productRepository.findById(id).orElseThrow(
                () -> { throw new IllegalStateException("No product found with ID: " + id); }
        );

        if (name != null && name.length() > 0 && !Objects.equals(result.getName(), name)) {
            result.setName(name);
        }
        if (category != null && category.length() > 0 && !Objects.equals(result.getCategory(), category)) {
            result.setCategory(category);
        }
        if (available != null && available > 0 && !Objects.equals(result.getAvailable(), available)) {
            result.setAvailable(available);
        }
        if (price != null && price > 0 && !Objects.equals(result.getPrice(), price)) {
            result.setPrice(price);
        }
        if (rating != null && !Objects.equals(result.getRating(), rating)) {
            result.setRating(rating);
        }
        if (characteristics != null && characteristics.size() > 0 && !Objects.equals(result.getCharacteristics(), characteristics)) {
            result.setCharacteristics(characteristics);
        }

        log.debug("Update product ID: {}", id);

        productRepository.save(result);

    }

    public void pushProduct(Product product) {

        Optional<Product> result = productRepository.findProductByName(product.getName());

        if (result.isPresent())
            throw new IllegalStateException("Product with Name: " + product.getName() + " already exists!");

        productRepository.insert(product);

        log.debug("Product saved: {}", product);

    }

    public void deleteProduct(String id) {

        log.debug("Delete Product: {}", id);

        productRepository.findById(id).orElseThrow(
                () ->  { throw new IllegalStateException("No Product found with ID: " + id); }
        );

        log.debug("Product deleted: {}", id);
        productRepository.deleteById(id);
    }

}
