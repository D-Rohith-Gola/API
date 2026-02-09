package com.cardconsumer.controller;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentConsumer {

    @KafkaListener(
        topics = "paymenttopic",
        groupId = "payment-consumer-group"
    )
    public void consume(PaymentEvent event) {

        System.out.println("------ Payment Received ------");
        System.out.println("Payment ID : " + event.getPaymentId());
        System.out.println("Amount     : " + event.getAmount());
        System.out.println("Status     : " + event.getStatus());
    }
}
