package com.bookExchange.UserService.Repositories;

import com.bookExchange.UserService.Models.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExchangeRepository extends JpaRepository<Exchange, Long> {
    List<Exchange> findByOwnerId(Long ownerId);
    List<Exchange> findByRequesterId(Long requesterId);
}

