package com.bookExchange.UserService.ClientServices;

import com.bookExchange.UserService.DTOs.BookDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "BookService")
public interface BookServiceClient {
    @GetMapping("/api/v1/books/{bookId}")
    BookDTO getBookById(@PathVariable Long bookId);

    @PutMapping("/api/v1/books/{bookId}")
    void updateBookStatus(@PathVariable Long bookId, @RequestBody BookDTO updatedBook);
}

