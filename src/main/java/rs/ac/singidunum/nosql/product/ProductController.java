package rs.ac.singidunum.nosql.product;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.nosql.customer.Address;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/shop/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping(path = "/all")
    public List<Product> fetchAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/item/{id}")
    public Product getProductById(@PathVariable (name = "id") String id) {
        return productService.getProductById(id);
    }

    @GetMapping("/orderItems")
    public List<Product> getProductByOrderIds(@RequestBody List<String> orderIds) {
        return productService.getProductByOrderId(orderIds);
    }

    @GetMapping(path = "/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable (name = "category") String category) {
        return productService.getProductsByCategory(category);
    }

    @GetMapping(path = "/filter")
    public List<Product> fetchProductsByFilter(
            @RequestParam(name = "category", required = false) String category,
            @RequestParam(name = "priceMax", required = false) Long priceMax,
            @RequestParam(name = "priceMin", required = false) Long priceMin){

        return productService.getProductsByFilter(category, priceMax, priceMin);
    }

    @PutMapping(path = "/add")
    public void pushProduct(@RequestBody Product product){ productService.pushProduct(product); }

    @PutMapping(path = {"/update/{id}"})
    public void updateProduct(@PathVariable (name = "id") String id,
                            @RequestParam (name = "name", required = false) String name,
                            @RequestParam (name = "category", required = false) String category,
                            @RequestParam (name = "available", required = false) Integer available,
                            @RequestParam (name = "price", required = false) Long price,
                            @RequestParam (name = "rating", required = false) Integer rating,
                            @RequestBody (required = false) HashMap<String, String> characteristics) {
        productService.updateProduct(id, name, category, available, price, rating, characteristics);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteProduct(@PathVariable (name = "id") String id) {
        productService.deleteProduct(id);
    }

}
