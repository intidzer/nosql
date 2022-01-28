package rs.ac.singidunum.nosql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import rs.ac.singidunum.nosql.customer.Address;
import rs.ac.singidunum.nosql.product.Product;
import rs.ac.singidunum.nosql.product.ProductRepository;

import java.util.HashMap;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
