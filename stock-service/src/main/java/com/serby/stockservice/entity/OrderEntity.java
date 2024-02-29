package com.serby.stockservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="orders")
public class OrderEntity {

    @Id
    private UUID id;

    @Column(nullable = false)
    @Length(min = 3, max = 15)
    private String name;

    @Column(nullable = false)
    private int qty;

    @Column(nullable = false)
    @Positive
    private double price;
}