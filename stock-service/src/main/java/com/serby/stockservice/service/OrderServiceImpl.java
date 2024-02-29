package com.serby.stockservice.service;

import com.serby.basedomains.dto.OrderDto;
import com.serby.stockservice.entity.OrderEntity;
import com.serby.stockservice.mapper.OrderMapper;
import com.serby.stockservice.repo.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements StockService{

    private OrderRepo orderRepo;

    public OrderServiceImpl(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Override
    public OrderDto saveOrder(OrderDto dto) {
        OrderEntity created = orderRepo.save(OrderMapper.mapToEntity(dto));
        return OrderMapper.mapToDto(created);
    }

    @Override
    public OrderDto findOrderByUUID(String uuid) {
        OrderEntity found = orderRepo.findById(UUID.fromString(uuid)).get();
        return OrderMapper.mapToDto(found);
    }

    @Override
    public List<OrderDto> findOrdersByName(String name) {
        List<OrderEntity> found = orderRepo.findAllByName(name);
        return found.stream().map(OrderMapper::mapToDto).collect(Collectors.toList());
    }
}
