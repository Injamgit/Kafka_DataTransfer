package com.example.KafkaProject.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;


    @ExtendWith(SpringExtension.class)
    @ContextConfiguration(classes = OpenApiConfig.class)
    class OpenApiConfigTest {

        @Test
        void contextLoads() {
            // If the context starts, annotations are valid
            assertTrue(true);
        }
    }

