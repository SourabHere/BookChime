package com.bookExchange.UserService.Services;

import com.bookExchange.UserService.ClientServices.BookServiceClient;
import com.bookExchange.UserService.ClientServices.NotificationClient;
import com.bookExchange.UserService.DTOs.BookDTO;
import com.bookExchange.UserService.DTOs.NotificationDTO;
import com.bookExchange.UserService.Models.Exchange;
import com.bookExchange.UserService.Repositories.ExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ExchangeService {

    @Autowired
    private ExchangeRepository exchangeRepository;

    @Autowired
    private BookServiceClient bookServiceClient;

    @Autowired
    private NotificationClient notificationClient;

    public Exchange requestBook(Long requesterId, Long ownerId, Long bookId) {

        BookDTO book = bookServiceClient.getBookById(bookId);
        if (!book.isAvailable()) {
            throw new IllegalStateException("Book not available");
        }


        Exchange exchange = new Exchange();
        exchange.setRequesterId(requesterId);
        exchange.setOwnerId(ownerId);
        exchange.setBookId(bookId);
        exchange.setStatus(Exchange.ExchangeStatus.REQUESTED);

        NotificationDTO notificationDTO = new NotificationDTO();

        notificationDTO.setContent("request of exchange");
        notificationDTO.setType("inApp");
        notificationDTO.setUserId(exchange.getOwnerId());

        String res = notificationClient.sendNotification(notificationDTO);

        System.out.println(res);

        return exchangeRepository.save(exchange);
    }

    public Exchange approveRequest(Long exchangeId, boolean isApproved) {
        Exchange exchange = exchangeRepository.findById(exchangeId)
                .orElseThrow(() -> new RuntimeException("Exchange not found"));

        exchange.setStatus(isApproved ? Exchange.ExchangeStatus.APPROVED : Exchange.ExchangeStatus.REJECTED);

        BookDTO exchangedBook = bookServiceClient.getBookById(exchange.getBookId());


        if (isApproved) {
            exchangedBook.setStatus("LENT");
            bookServiceClient.updateBookStatus(exchange.getBookId(), exchangedBook);

            NotificationDTO notificationDTO = new NotificationDTO();

            notificationDTO.setContent("approval for exchange");
            notificationDTO.setType("inApp");
            notificationDTO.setUserId(exchange.getRequesterId());

            notificationClient.sendNotification(notificationDTO);

        }

        return exchangeRepository.save(exchange);
    }

    public Exchange completeExchange(Long exchangeId) {
        Exchange exchange = exchangeRepository.findById(exchangeId)
                .orElseThrow(() -> new RuntimeException("Exchange not found"));

        exchange.setStatus(Exchange.ExchangeStatus.COMPLETED);

        BookDTO exchangedBook = bookServiceClient.getBookById(exchange.getBookId());

        exchangedBook.setStatus("AVAILABLE");
        bookServiceClient.updateBookStatus(exchange.getBookId(),exchangedBook);

        return exchangeRepository.save(exchange);
    }
}
