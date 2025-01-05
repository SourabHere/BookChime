package com.bookExchange.BookService.Repositories;

import com.bookExchange.BookService.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByOwnerId(Long ownerId);
}
