package com.bookExchange.UserService.Models;

import jakarta.persistence.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, unique = true, length = 50)
    private String username;


    @Column(nullable = false, unique = true, length = 100)
    private String email;


    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean isActive = true;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    @PreUpdate
    public void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }
}

