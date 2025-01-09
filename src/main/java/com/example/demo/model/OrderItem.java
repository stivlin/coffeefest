package com.example.demo.model;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class OrderItem {

    Long orderId;
    Integer orderNumber;
    Double totalPrice;
    String orderStatus;
    LocalDateTime orderDate;
    LocalDateTime deliveryDate;
    LocalDateTime shippedDate;
    LocalDateTime paidStatus;
    LocalDateTime shippedStatus;
    // TODO: 3. Instant - погуглить
    Integer totalQuantity;

}
