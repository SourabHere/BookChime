package com.bookExchange.NotificationService.Services;

import com.bookExchange.NotificationService.DTO.NotificationRequest;
import com.bookExchange.NotificationService.Models.Notification;
import com.bookExchange.NotificationService.Kafka.NotificationProducer;
import com.bookExchange.NotificationService.Repositories.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final NotificationProducer notificationProducer;

    public NotificationService(NotificationRepository notificationRepository, NotificationProducer notificationProducer) {
        this.notificationRepository = notificationRepository;
        this.notificationProducer = notificationProducer;
    }

    public void createAndSendNotification(NotificationRequest request) {

        Notification notification = new Notification();
        System.out.println("************request********");
        System.out.println(request);
        System.out.println("************request********");
        notification.setUserId(request.getUserId());
        notification.setContent(request.getContent());
        notification.setType(request.getType());
        notification.setCreatedAt(LocalDateTime.now());


        notificationProducer.sendNotification(request);
    }
}
