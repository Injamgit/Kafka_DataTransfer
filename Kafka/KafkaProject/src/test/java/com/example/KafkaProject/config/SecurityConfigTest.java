package com.example.KafkaProject.config;

import com.example.KafkaProject.security.JwtAuthenticationFilter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class SecurityConfigTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @RestController
    static class TestController {
        @GetMapping("/secure")
        public String secure() {
            return "secure";
        }

        @GetMapping("/auth/public")
        public String publicApi() {
            return "public";
        }
    }

    @Test
    void publicEndpointShouldBeAccessible() throws Exception {
        mockMvc.perform(get("/auth/public"))
                .andExpect(status().isOk());
    }

//    @Test
//    void secureEndpointShouldBeUnauthorized() throws Exception {
//        mockMvc.perform(get("/secure"))
//                .andExpect(status().isUnauthorized());
//    }
}
