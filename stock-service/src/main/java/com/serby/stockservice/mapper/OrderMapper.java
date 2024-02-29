package com.serby.stockservice.mapper;

import com.serby.basedomains.dto.OrderDto;
import com.serby.stockservice.entity.OrderEntity;

import java.util.UUID;

import static java.lang.Long.parseLong;

public class OrderMapper {

    public static OrderDto mapToDto(OrderEntity order) {
        return OrderDto.builder()
                .qty(order.getQty())
                .name(order.getName())
                .price(order.getPrice())
                .orderId(order.getId().toString())
                .build();
    }

    public static OrderEntity mapToEntity(OrderDto order) {
        return OrderEntity.builder()
                .qty(order.getQty())
                .name(order.getName())
                .price(order.getPrice())
                .id(UUID.fromString(order.getOrderId()))
                .build();
    }
}
