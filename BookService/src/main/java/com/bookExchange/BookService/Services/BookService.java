package com.bookExchange.BookService.Services;

import com.bookExchange.BookService.Models.Book;
import com.bookExchange.BookService.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public void updateBook(Long bookId, Book updatedBook) {
        Book existingBook = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setGenre(updatedBook.getGenre());
        existingBook.setDescription(updatedBook.getDescription());
        bookRepository.save(existingBook);
    }

    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
