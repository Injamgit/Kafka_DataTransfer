package com.example.KafkaProject.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.KafkaProject.service.MessageProducer;
import com.example.KafkaProject.util.JwtUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

//import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


    @AutoConfigureMockMvc(addFilters = false)
    @WebMvcTest(MessageController.class)
    class MessageControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private JwtUtil jwtUtil;


        @MockBean
        private MessageProducer producer;

        //@WithMockUser
        @Test
        void shouldSendMessage() throws Exception {
            // given
            String msg = "hello kafka";

            // when & then
            mockMvc.perform(
                            post("/api/kafka/send")
                                    .param("msg", msg)
                    )
                    .andExpect(status().isOk());
                    //.andExpect(content().string("Message sent: " + msg));

            //verify(producer, times(1)).sendMessage(msg);
        }
    }

