package com.bookExchange.UserService.DTOs;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private Long id;
    private String title;
    private String author;
    private String status;
    private String genre;


    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(length = 1000)
    private String description;

    private Long ownerId;


    public boolean isAvailable() {
        return status.equals("AVAILABLE");
    }
}

