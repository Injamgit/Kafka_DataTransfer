package com.example.KafkaProject.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MessageProducerTest {

    @InjectMocks
    private MessageProducer messageProducer;

    @Mock
    private KafkaTemplate kafkaTemplate;

    @Test
    void shouldSendMessage(){
        String message = "hello kafka";
        messageProducer.sendMessage(message);
    }
}