package com.serby.stockservice.controller;

import com.serby.basedomains.dto.OrderDto;
import com.serby.stockservice.service.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private StockService stockService;

    public OrderController(StockService stockService) {

        this.stockService = stockService;
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<OrderDto> findOrderByUUID(@PathVariable String uuid) {

        OrderDto orderDto = stockService.findOrderByUUID(uuid);
        return ResponseEntity.ok(orderDto);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<OrderDto>> findOrdersByName(@PathVariable String name) {

        List<OrderDto> orders = stockService.findOrdersByName(name);
        return ResponseEntity.ok(orders);
    }
}
