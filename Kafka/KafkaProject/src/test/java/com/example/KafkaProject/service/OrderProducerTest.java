package com.example.KafkaProject.service;


import com.example.KafkaProject.model.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

import javax.management.MXBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderProducerTest {

    @InjectMocks
    private OrderProducer orderProducer;

    @Mock
    private KafkaTemplate kafkaTemplate;
    @Mock
    private Order order;

    @Test
    void shouldSendOrder(){
        orderProducer.sendOrder(order);
            }
}