package com.bookExchange.MessagingService.Service;


import com.bookExchange.MessagingService.Model.Message;
import com.bookExchange.MessagingService.Repository.MessageRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }
}

