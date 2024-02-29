package com.serby.eventdriventester.service;

import com.serby.basedomains.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "http://localhost:8082", value="EMAIL-SERVICE")
public interface ApiClient {

    @GetMapping("/api/v1/orders/{uuid}")
    ResponseEntity<OrderDto> findOrderByUUID(@PathVariable String uuid);

    @GetMapping("/api/v1/orders/name/{name}")
    ResponseEntity<List<OrderDto>> findOrdersByName(@PathVariable String name);
}
