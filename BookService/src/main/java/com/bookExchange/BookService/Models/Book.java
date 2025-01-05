package com.bookExchange.BookService.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private String genre;

    @Column(length = 1000)
    private String description;

    private String status;


    private LocalDateTime createdAt = LocalDateTime.now();

    private Long ownerId;
}