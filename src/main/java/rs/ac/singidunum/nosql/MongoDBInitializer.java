package rs.ac.singidunum.nosql;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rs.ac.singidunum.nosql.customer.Address;
import rs.ac.singidunum.nosql.customer.Customer;
import rs.ac.singidunum.nosql.customer.CustomerRepository;
import rs.ac.singidunum.nosql.order.Order;
import rs.ac.singidunum.nosql.order.OrderRepository;
import rs.ac.singidunum.nosql.order.OrderStatus;
import rs.ac.singidunum.nosql.product.Product;
import rs.ac.singidunum.nosql.product.ProductRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;

@Configuration
public class MongoDBInitializer {

    @Bean
    CommandLineRunner runner(ProductRepository productRepository,
                             CustomerRepository customerRepository,
                             OrderRepository orderRepository) {
        return args -> {

            //Products
/*
            HashMap<String, String> characteristics = new HashMap<>();

            //CPU
            characteristics.put("cores", "6");
            characteristics.put("threads", "6");
            characteristics.put("clock", "3.6GHz");
            characteristics.put("turbo", "4.3GHz");
            characteristics.put("TDP", "95W");
            characteristics.put("socket", "1151");
            characteristics.put("virtualization", "yes");
            Product product = new Product("Intel i5 8600K", "Processor",54, 35960L, 5, characteristics);
            productRepository.insert(product);

            characteristics.put("cores", "4");
            characteristics.put("threads", "4");
            characteristics.put("clock", "3.6GHz");
            characteristics.put("TDP", "65W");
            characteristics.put("socket", "1151");
            characteristics.put("virtualization", "yes");
            product = new Product("INTEL Core i3-9100 3.6GHz", "Processor",6, 18999L, 4, characteristics);
            productRepository.insert(product);

            characteristics.put("cores", "6");
            characteristics.put("threads", "12");
            characteristics.put("clock", "3.6GHz");
            characteristics.put("turbo", "4.2GHz");
            characteristics.put("TDP", "65W");
            characteristics.put("virtualization", "yes");
            characteristics.put("socket", "1151");
            product = new Product("AMD Ryzen 5 3600", "Processor",20, 38999L, 4, characteristics);
            productRepository.insert(product);

            //Motherboards

            characteristics = new HashMap<>();
            characteristics.put("socket", "1151");
            characteristics.put("memory", "DDR4");
            characteristics.put("format", "ATX");
            product = new Product("GIGABYTE Z370P v1.0", "Motherboard",12, 11250L, 5, characteristics);
            productRepository.insert(product);

            characteristics = new HashMap<>();
            characteristics.put("socket", "1200");
            characteristics.put("memory", "DDR4");
            characteristics.put("format", "Micro ATX");
            product = new Product("ASUS PRIME H570M-PLUS", "Motherboard",12, 18990L, 0, characteristics);
            productRepository.insert(product);

            characteristics = new HashMap<>();
            characteristics.put("socket", "AM4");
            characteristics.put("memory", "DDR4");
            characteristics.put("format", "Micro ATX");
            product = new Product("GIGABYTE B450M S2H", "Motherboard",12, 8999L, 4, characteristics);
            productRepository.insert(product);

            //GPU

            characteristics = new HashMap<>();
            characteristics.put("memory", "4GB");
            characteristics.put("type", "GDDR5");
            characteristics.put("bus", "128bit");
            product = new Product("ASUS Phoenix GeForce GTX 1650 OC", "GPU",3, 44999L, 5, characteristics);
            productRepository.insert(product);

            characteristics = new HashMap<>();
            characteristics.put("memory", "6GB");
            characteristics.put("type", "GDDR6");
            characteristics.put("bus", "192bit");
            product = new Product("GIGABYTE GeForce RTX 2060 D6", "GPU",5, 44999L, 5, characteristics);
            productRepository.insert(product);

            characteristics = new HashMap<>();
            characteristics.put("memory", "8GB");
            characteristics.put("type", "GDDR6");
            characteristics.put("bus", "128bit");
            product = new Product("AMD Radeon RX 6600 XT", "GPU",0, 104999L, 5, characteristics);
            productRepository.insert(product);

            //RAM

            characteristics = new HashMap<>();
            characteristics.put("size", "8GB");
            characteristics.put("type", "DDR4");
            characteristics.put("clock", "3733MHz");
            characteristics.put("latency", "CL19");
            product = new Product("KINGSTON Beast 8GB DDR4", "RAM",15, 8999L, 5, characteristics);
            productRepository.insert(product);

            characteristics = new HashMap<>();
            characteristics.put("size", "8GB x2");
            characteristics.put("type", "DDR4");
            characteristics.put("clock", "3600MHz");
            characteristics.put("latency", "CL18");
            product = new Product("CORSAIR Vengeance RGB PRO SL 16GB", "RAM",14, 14999L, 5, characteristics);
            productRepository.insert(product);

            characteristics = new HashMap<>();
            characteristics.put("size", "8GB x2");
            characteristics.put("type", "DDR4");
            characteristics.put("clock", "3200MHz");
            characteristics.put("latency", "CL16");
            product = new Product("GEIL Super Luce RGB Sync 16GB", "RAM",5, 12999L, 4, characteristics);
            productRepository.insert(product);


            //Customers

            Address address = new Address("Serbia", "Belgrde", 11000, "Savska 10");
            Customer customer = new Customer("mika.12@gmail.com", "Mile", "Miskovic", address, "+38164423423");
            customerRepository.insert(customer);

            address = new Address("Serbia", "Novi Sad", 21000, "Dunavska 32");
            customer = new Customer("pele.pelinho@yahoo.com", "Petar", "Radojcic", address, "+38165633439");
            customerRepository.insert(customer);

            address = new Address("Serbia", "Kikinda", 23300, "Svetosavska 15");
            customer = new Customer("neca.11@live.com", "Nebojsa", "Zivic", address, "+381691327565");
            customerRepository.insert(customer);



            //Orders

            HashMap<String, Integer> items = new HashMap<>();
            items.put("61e48735c66e6349b415411f", 1);
            items.put("61e48735c66e6349b4154122", 1);
            items.put("61e48735c66e6349b4154127", 3);

            Order order = new Order(
                    12300321L,
                    "61e48735c66e6349b415412a",
                    OrderStatus.DELIVERED,
                    LocalDateTime.now(),
                    address,
                    items);

            orderRepository.insert(order);
*/
        };
    }


}
