package com.bookExchange.UserService.Models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class GenericResponse {
    public String message;
    public String status;
}
