package rs.ac.singidunum.nosql.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import rs.ac.singidunum.nosql.customer.Address;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Optional;


@DataMongoTest
@ImportAutoConfiguration(exclude = EmbeddedMongoAutoConfiguration.class)
class OrderRepositoryTest {

    @Autowired
    OrderRepository underTest;
    Order expected;

    @BeforeEach
    void setUp() {

        HashMap<String, Integer> items = new HashMap<>();
        items.put("61e48735c66e6349b415411f", 1);
        items.put("61e48735c66e6349b4154122", 1);
        items.put("61e48735c66e6349b4154127", 3);

        expected = new Order(
                12300321L,
                "61e48735c66e6349b415412a",
                OrderStatus.DELIVERED,
                LocalDateTime.parse("2022-01-23T22:10:01.000"),
                new Address("Serbia", "Kikinda", 23300, "Svetosavska 15"),
                items);

        underTest.insert(expected);
    }

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void findOrderByCustomerId_ShouldFindOrder() {

        // when

        Optional<Order> result = underTest.findOrderByCustomerId("61e48735c66e6349b415412a");

        // then

        Assertions.assertThat(result.isPresent()).isTrue();
        Assertions.assertThat(result.get()).isEqualTo(expected);

    }

    @Test
    void findOrderByCustomerId_ShouldNotFindOrder() {

        // when

        Optional<Order> result = underTest.findOrderByCustomerId("61e48735c66e6349b415412a213");

        // then

        Assertions.assertThat(result.isPresent()).isFalse();

    }

    @Test
    void findOrderByOrderNo_ShouldFindOrder() {

        // when

        Optional<Order> result = underTest.findOrderByOrderNo(12300321L);

        // then

        Assertions.assertThat(result.isPresent()).isTrue();
        Assertions.assertThat(result.get()).isEqualTo(expected);

    }

    @Test
    void findOrderByOrderNo_ShouldNotFindOrder() {

        // when

        Optional<Order> result = underTest.findOrderByOrderNo(1230132L);

        // then

        Assertions.assertThat(result.isPresent()).isFalse();

    }

}