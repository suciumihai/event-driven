package com.serby.emailservice.service;

import com.serby.basedomains.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "http://localhost:8081", value="STOCK-SERVICE")
//@FeignClient(name="DEPARTMENT-SERVICE") //serviceID din eureka srv registry/ load balancer si gata
//asa merge doar prin api gateway. daca vrei serviciile intre ele, mai bine cel de sus
public interface ApiClient {

    //literalmente copiata din ctorler stock service;
    @GetMapping("/api/v1/orders/{uuid}")
    ResponseEntity<OrderDto> findOrderByUUID(@PathVariable String uuid);

    @GetMapping("/api/v1/orders/name/{name}")
    ResponseEntity<List<OrderDto>> findOrdersByName(@PathVariable String name);
}
