package com.bookExchange.MessagingService.Consumer;


import com.bookExchange.MessagingService.Model.Message;
import com.bookExchange.MessagingService.Service.MessageService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MessageConsumer {

    private final MessageService messageService;

    public MessageConsumer(MessageService messageService) {
        this.messageService = messageService;
    }

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String messageContent) {

        Message message = new Message();
        message.setContent(messageContent);
        message.setCreatedAt(LocalDateTime.now());

        messageService.saveMessage(message);
    }
}
