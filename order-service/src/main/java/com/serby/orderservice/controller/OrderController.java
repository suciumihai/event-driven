package com.serby.orderservice.controller;

import com.serby.basedomains.dto.OrderDto;
import com.serby.basedomains.dto.OrderEvent;
import com.serby.orderservice.kafka.OrderProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    private OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/orders")
    public String placeHolder(@RequestBody OrderDto order) {

        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent orderEvent = OrderEvent.builder()
                .status("PENDING")
                .message("order status is in pending")
                .order(order)
                .build();

        orderProducer.sendMessage(orderEvent);

        return "Order palced sucessfuly";
    }
}
