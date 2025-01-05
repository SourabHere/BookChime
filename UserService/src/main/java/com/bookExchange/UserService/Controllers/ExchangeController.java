package com.bookExchange.UserService.Controllers;

import com.bookExchange.UserService.Models.Exchange;
import com.bookExchange.UserService.Services.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/exchanges")
public class ExchangeController {
    @Autowired
    private ExchangeService exchangeService;

    @PostMapping("/")
    public Exchange requestBook(@RequestParam Long requesterId, @RequestParam Long ownerId, @RequestParam Long bookId) {
        return exchangeService.requestBook(requesterId, ownerId, bookId);
    }

    @PutMapping("/{exchangeId}/approve")
    public Exchange approveRequest(@PathVariable Long exchangeId, @RequestParam boolean isApproved) {
        return exchangeService.approveRequest(exchangeId, isApproved);
    }

    @PutMapping("/{exchangeId}/complete")
    public Exchange completeExchange(@PathVariable Long exchangeId) {
        return exchangeService.completeExchange(exchangeId);
    }
}
