package com.synechronepuneproducer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.synechronepuneproducer.entity.PaymentEvent;

@Service
public class PaymentProducerService {

    @Autowired
    private KafkaTemplate<String, PaymentEvent> kafkaTemplate;

    public void send(PaymentEvent event) {
        kafkaTemplate.send("paymenttopic", event.getPaymentId(), event);
    }
}