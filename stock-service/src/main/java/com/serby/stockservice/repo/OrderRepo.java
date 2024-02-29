package com.serby.stockservice.repo;

import com.serby.basedomains.dto.OrderDto;
import com.serby.stockservice.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderRepo extends JpaRepository<OrderEntity, UUID> {

    List<OrderEntity> findAllByName(String name);
}
