package com.bookExchange.UserService.ClientServices;

import com.bookExchange.UserService.DTOs.BookDTO;
import com.bookExchange.UserService.DTOs.NotificationDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "NotificationService")
public interface NotificationClient {
    @GetMapping("/api/v1/notifications/")
    String sendNotification(@RequestBody NotificationDTO request);

}
