package rs.ac.singidunum.nosql.product;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

@Data
@NoArgsConstructor
@Document(collection = "product")
public class Product {

    @Id
    String id;
    @Indexed(unique = true)
    String name;
    String category;
    Integer available;
    Long price;
    Integer rating;
    HashMap<String, String> characteristics;

    public Product(String name, String category, Integer available, Long price, Integer rating, HashMap<String, String> characteristics) {
        this.name = name;
        this.category = category;
        this.available = available;
        this.price = price;
        this.rating = rating;
        this.characteristics = characteristics;
    }

    public void setRating(Integer rating) {
        this.rating = Math.min(Math.max(rating, 0), 5);
    }

}
