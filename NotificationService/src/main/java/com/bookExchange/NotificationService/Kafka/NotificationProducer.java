package com.bookExchange.NotificationService.Kafka;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    public NotificationProducer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendNotification(Object notification) {
        try {
            String message = objectMapper.writeValueAsString(notification);
            kafkaTemplate.send(topicName, message);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to serialize notification", e);
        }
    }
}

