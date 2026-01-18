
package com.example.KafkaProject.controller;

//import com.example.KafkaProject.model.Order;
import com.example.KafkaProject.dto.OrderRequestDTO;
import com.example.KafkaProject.model.Order;
import com.example.KafkaProject.service.OrderProducer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Order APIs", description = "Kafka Order Producer APIs")
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderProducer producer;

    public OrderController(OrderProducer producer) {
        this.producer = producer;
    }

    //    @PostMapping("/send")
//    public String sendOrder1(@RequestBody Order order) {
//        producer.sendOrder(order);
//        return "Order Sent Successfully!";
//    }
//}
    @Operation(summary = "Send order to Kafka topic")
    @PostMapping("/send")
    public String sendOrder(@Valid @RequestBody OrderRequestDTO dto) {

        // convert DTO → Model
        Order order = new Order(
                UUID.randomUUID().toString(),   // generate orderId
                dto.getItemName(),
                dto.getPrice()
        );

        producer.sendOrder(order);

        return "Order Sent Successfully!";
    }
}

