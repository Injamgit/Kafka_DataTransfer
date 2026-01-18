package com.example.KafkaProject.repository;

import com.example.KafkaProject.model.Order;
import com.example.KafkaProject.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
