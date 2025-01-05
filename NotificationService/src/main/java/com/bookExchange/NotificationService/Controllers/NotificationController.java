package com.bookExchange.NotificationService.Controllers;

import com.bookExchange.NotificationService.DTO.NotificationRequest;
import com.bookExchange.NotificationService.Kafka.NotificationProducer;
import com.bookExchange.NotificationService.Services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {

    private final NotificationService notificationService;
    private final NotificationProducer notificationProducer;


    public NotificationController(NotificationService notificationService, NotificationProducer notificationProducer) {
        this.notificationService = notificationService;
        this.notificationProducer = notificationProducer;

    }


    @PostMapping("/test")
    public ResponseEntity<String> sendNotification(@RequestBody String message) {
        notificationProducer.sendNotification(message);
        return ResponseEntity.ok("Notification sent successfully!");
    }

    @PostMapping("/")
    public ResponseEntity<String> sendNotification(@RequestBody NotificationRequest request) {
        notificationService.createAndSendNotification(request);
        return ResponseEntity.ok("Notification sent successfully");
    }

}

