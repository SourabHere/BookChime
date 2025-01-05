package com.bookExchange.BookService.Controllers;

import com.bookExchange.BookService.Models.Book;
import com.bookExchange.BookService.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return ResponseEntity.ok("Book added successfully");
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable Long bookId) {
        Book book = bookService.getBookById(bookId);
        return ResponseEntity.ok(book);
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<String> updateBook(@PathVariable Long bookId, @RequestBody Book updatedBook) {
        bookService.updateBook(bookId, updatedBook);
        return ResponseEntity.ok("Book updated successfully");
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
        return ResponseEntity.ok("Book deleted successfully");
    }
}
