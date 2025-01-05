package com.bookExchange.UserService.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "exchanges")
@Getter
@Setter
public class Exchange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long requesterId;
    private Long ownerId;
    private Long bookId;

    @Enumerated(EnumType.STRING)
    private ExchangeStatus status;

    public enum ExchangeStatus {
        REQUESTED, APPROVED, REJECTED, COMPLETED
    }


}
