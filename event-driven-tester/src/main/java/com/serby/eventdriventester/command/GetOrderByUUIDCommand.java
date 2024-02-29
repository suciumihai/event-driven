package com.serby.eventdriventester.command;

import com.serby.basedomains.dto.OrderDto;
import com.serby.eventdriventester.service.ApiClient;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GetOrderByUUIDCommand {

    private final ApiClient feignClient;

    public ResponseEntity<String> execute(String uuid) {
        OrderDto orderDto = feignClient.findOrderByUUID(uuid).getBody();
        if (orderDto.getOrderId().equals(uuid)) {
            return new ResponseEntity<>("findOrderByUUID passed ok", HttpStatus.OK); }
        else {
            return new ResponseEntity<>("findOrderByUUID failed", HttpStatus.OK);
        }
    }
}
