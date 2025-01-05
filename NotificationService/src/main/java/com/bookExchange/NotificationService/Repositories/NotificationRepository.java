package com.bookExchange.NotificationService.Repositories;


import com.bookExchange.NotificationService.Models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
