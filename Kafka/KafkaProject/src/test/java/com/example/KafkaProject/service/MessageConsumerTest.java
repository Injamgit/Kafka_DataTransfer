package com.example.KafkaProject.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

import static org.junit.jupiter.api.Assertions.*;

//@ExtendWith(MockitoExtension.class)
@SpringBootTest
class MessageConsumerTest {

    @InjectMocks
    private MessageConsumer messageConsumer;


    @Test
    void shouldConsumeMessage() {
        // given
        String message = "hello kafka";

        // when
        messageConsumer.listen(message);

        // then
        // no exception = success
        // (you can also verify logs if logging is used)
    }
}
