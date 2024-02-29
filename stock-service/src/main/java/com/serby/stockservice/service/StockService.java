package com.serby.stockservice.service;

import com.serby.basedomains.dto.OrderDto;

import java.util.List;

public interface StockService {

    public OrderDto saveOrder(OrderDto dto);

    public OrderDto findOrderByUUID(String uuid);

    public List<OrderDto> findOrdersByName(String name);
}
