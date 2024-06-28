package org.example.skillboxorderservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.skillboxorderservice.dto.Order;
import org.example.skillboxorderservice.event.OrderEvent;
import org.example.skillboxorderservice.service.KafkaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class ApiController {
    private final KafkaService kafkaService;

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createOrder(@RequestBody Order order) {
        kafkaService.sendMessage(new OrderEvent(order));
    }
}
