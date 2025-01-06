package com.example.demo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private Integer orderNumber;

    @Min(value = 0)
    // TODO унести в команды
    private Double totalPrice;
    private String orderStatus;
    private LocalDateTime orderDate;
    private LocalDateTime deliveryDate;
    private LocalDateTime shippedDate;
    private LocalDateTime paidStatus;
    private LocalDateTime shippedStatus;
    private Integer totalQuantity;
}
