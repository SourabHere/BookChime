package com.bookExchange.MessagingService.Repository;


import com.bookExchange.MessagingService.Model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}

