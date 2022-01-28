package rs.ac.singidunum.nosql.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import rs.ac.singidunum.nosql.customer.Address;

import java.time.LocalDateTime;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    OrderRepository repository;
    OrderService underTest;

    @BeforeEach
    void setUp() {
        underTest = new OrderService(repository);
        MockitoAnnotations.openMocks(repository);
    }

    @Test
    void getAllOrders() {

        underTest.getAllOrders();

        Mockito.verify(repository).findAll();

    }

    @Test
    @Disabled
    void getOrdersById() {
    }

    @Test
    @Disabled
    void getOrderByCustomerId() {
    }

    @Test
    @Disabled
    void getOrderByOrderNo() {
    }

    @Test
    @Disabled
    void updateOrder() {
    }

    @Test
    @Disabled
    void deleteOrder() {
    }

    @Test
    @Disabled
    void pushOrder_ShouldSaveOrder_IfOrderIsValid() {

        // given

        HashMap<String, Integer> items = new HashMap<>();
        items.put("61e48735c66e6349b415411f", 1);
        items.put("61e48735c66e6349b4154122", 1);
        items.put("61e48735c66e6349b4154127", 3);

        Order order = new Order(
                12300321L,
                "61e48735c66e6349b415412a",
                OrderStatus.DELIVERED,
                LocalDateTime.parse("2022-01-23T22:10:01.000"),
                new Address("Serbia", "Kikinda", 23300, "Svetosavska 15"),
                items);

        // when

        repository.save(order);

        // then

        ArgumentCaptor<Order> orderArgumentCaptor = ArgumentCaptor.forClass(Order.class);
        Mockito.verify(repository).save(orderArgumentCaptor.capture());

        Order capturedOrder = orderArgumentCaptor.getValue();
        Assertions.assertThat(capturedOrder).isEqualTo(order);

    }
}