package com.serby.eventdriventester.controller;

import com.serby.basedomains.dto.OrderDto;
import com.serby.eventdriventester.service.TesterService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tester")
@AllArgsConstructor
public class TesterController {

    private TesterService testerService;

    @GetMapping("/{uuid}")
    public ResponseEntity<OrderDto> testGetOrderByUUIDFromEmailService(@PathVariable("uuid") String uuid){
        OrderDto orderDto = testerService.getOrderByUUID(uuid);
        return new ResponseEntity<>(orderDto, HttpStatus.FOUND);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<OrderDto>> getOrdersByNameFromEmailService(@PathVariable String name) {
        List<OrderDto> orders = testerService.getOrdersByName(name);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/endpoint/{endpoint}")
    public ResponseEntity<String> testGenericEndpoint(@PathVariable String endpoint,
                                                      @RequestParam String inputValue) {
        return testerService.executeCommand(endpoint, inputValue);
    }

    //deprecated in favor of command pattern
    //@GetMapping("/endpoint/{endpoint}")
    public ResponseEntity<String> testGenericEndpointDeprecated(@PathVariable String endpoint,
                                                      @RequestParam String inputValue) {
        switch (endpoint) {
            case "getOrderByUUID":
                OrderDto orderDto = testerService.getOrderByUUID(inputValue);
                if (orderDto.getOrderId().equals(inputValue)) {
                    return new ResponseEntity<>(endpoint + " passed ok", HttpStatus.OK); }
                else {
                    return new ResponseEntity<>(endpoint + " failed", HttpStatus.OK);
                }
            case "getOrdersByName":
                List<OrderDto> orders = testerService.getOrdersByName(inputValue);
                if (orders.stream().map(OrderDto::getName).toList().contains(inputValue)) {
                    return new ResponseEntity<>(endpoint + " passed ok", HttpStatus.OK); }
                else {
                    return new ResponseEntity<>(endpoint + " failed", HttpStatus.OK);
                }
            default:
                return new ResponseEntity<>("wrong name", HttpStatus.BAD_REQUEST);
        }
    }
}
