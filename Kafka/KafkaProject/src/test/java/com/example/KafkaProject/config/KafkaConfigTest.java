package com.example.KafkaProject.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = KafkaConfig.class)
class KafkaConfigTest {

    @Autowired
    private ProducerFactory<String, String> producerFactory;

    @Test
    void producerFactoryBeanShouldBeCreated() {
        assertNotNull(producerFactory);
    }
}