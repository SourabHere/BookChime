package com.bookExchange.NotificationService.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotificationRequest {
    private Long userId;
    private String content;
    private String type;

}
