package com.serby.stockservice.kafka;

import com.serby.basedomains.dto.OrderDto;
import com.serby.basedomains.dto.OrderEvent;
import com.serby.stockservice.mapper.OrderMapper;
import com.serby.stockservice.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    private StockService stockService;

    public OrderConsumer(StockService stockService) {
        this.stockService = stockService;
    }

    @KafkaListener(topics="${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}")
    public OrderDto consume(OrderEvent orderEvent) {
        LOGGER.info(String.format("Order evet primit este %s", orderEvent.toString()));

        LOGGER.info("scris ok in db");
        return stockService.saveOrder(orderEvent.getOrder());
    }
}
