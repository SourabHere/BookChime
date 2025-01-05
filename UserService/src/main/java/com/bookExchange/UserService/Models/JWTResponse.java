package com.bookExchange.UserService.Models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JWTResponse {
    private String token;
    private String username;
}
