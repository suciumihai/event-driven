package com.serby.emailservice.service;

import com.serby.basedomains.dto.OrderDto;

import java.util.List;

public interface OrderService {

    OrderDto getOrderByUUID(String uuid);

    List<OrderDto> getOrdersByName(String name);
}
