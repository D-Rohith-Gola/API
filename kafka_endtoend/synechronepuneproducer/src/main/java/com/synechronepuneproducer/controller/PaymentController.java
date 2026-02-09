package com.synechronepuneproducer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.synechronepuneproducer.entity.PaymentEvent;
import com.synechronepuneproducer.service.PaymentProducerService;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentProducerService producer;

    @PostMapping
    public String send(@RequestBody PaymentEvent event) {
        producer.send(event);
        return "Message sent to Kafka successfully";
    }
}