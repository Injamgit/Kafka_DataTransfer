package com.example.KafkaProject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class OrderRequestDTO {

    @NotBlank(message = "Item name cannot be empty")
    private String itemName;

    @Positive(message = "Price must be greater than zero")
    private double price;

    public OrderRequestDTO() {}

    public OrderRequestDTO(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
