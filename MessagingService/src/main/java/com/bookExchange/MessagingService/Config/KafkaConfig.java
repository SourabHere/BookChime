package com.bookExchange.MessagingService.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;


@Configuration
@EnableKafka
public class KafkaConfig {

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(String messageContent) {
        System.out.println("Received message: " + messageContent);
    }
}
