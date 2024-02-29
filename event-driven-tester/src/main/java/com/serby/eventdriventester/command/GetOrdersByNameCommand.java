package com.serby.eventdriventester.command;

import com.serby.basedomains.dto.OrderDto;
import com.serby.eventdriventester.service.ApiClient;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class GetOrdersByNameCommand {

    private final ApiClient feignClient;

    public ResponseEntity<String> execute(String name) {
        List<OrderDto> orderDto = feignClient.findOrdersByName(name).getBody();
        if (orderDto.stream().map(OrderDto::getName).toList().contains(name)) {
            return new ResponseEntity<>("findOrdersByName passed ok", HttpStatus.OK); }
        else {
            return new ResponseEntity<>("findOrdersByName failed", HttpStatus.OK);
        }
    }
}
