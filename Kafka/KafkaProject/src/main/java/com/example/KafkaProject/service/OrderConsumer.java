
package com.example.KafkaProject.service;

import com.example.KafkaProject.model.Order;
import com.example.KafkaProject.model.OrderEntity;
import com.example.KafkaProject.repository.OrderRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

//    @KafkaListener(topics = "order-topic", groupId = "order-group")
//    public void consume(Order order) {
//        System.out.println("Received Order: " + order);
private final OrderRepository orderRepository;

    public OrderConsumer(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

@KafkaListener(topics = "orders", groupId = "order-group",
        containerFactory = "orderKafkaListenerContainerFactory")
public void consumeOrder(Order order) {
    OrderEntity entity = new OrderEntity(
            order.getOrderId(),
            order.getItemName(),
            order.getPrice()
    );
    System.out.println("Received ORDER: " + entity);
    orderRepository.save(entity);

}
}
