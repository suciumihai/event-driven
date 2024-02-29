package com.serby.emailservice.controller;

import com.serby.basedomains.dto.OrderDto;
import com.serby.emailservice.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/orders")
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;

    @GetMapping("{uuid}")
    public ResponseEntity<OrderDto> getOrderByUUID(@PathVariable String uuid) {
        OrderDto orderDto = orderService.getOrderByUUID(uuid);
        return new ResponseEntity<>(orderDto, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<OrderDto>> getOrdersByName(@PathVariable String name) {
        List<OrderDto> orders = orderService.getOrdersByName(name);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

}
