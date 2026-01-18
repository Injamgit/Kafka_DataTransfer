package com.example.KafkaProject.service;

import com.example.KafkaProject.model.Order;
import com.example.KafkaProject.model.OrderEntity;
import com.example.KafkaProject.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderConsumerTest {
    @InjectMocks
    private OrderConsumer orderConsumer;

    @Mock
    private OrderRepository orderRepository;

//    @Mock
//    private Order order;
    @Test
    void shouldSaveOrder() {

    Order order = new Order();
        order.setOrderId("1L");
        order.setItemName("Laptop");
        order.setPrice(75000.0);

    // when
        orderConsumer.consumeOrder(order);

    }
}