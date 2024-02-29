package com.serby.emailservice.service;

import com.serby.basedomains.dto.OrderDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService{

    private ApiClient feignClient;
    @Override
    public OrderDto getOrderByUUID(String uuid) {
        return feignClient.findOrderByUUID(uuid).getBody();
    }

    @Override
    public List<OrderDto> getOrdersByName(String name) {
        return feignClient.findOrdersByName(name).getBody();
    }
}
