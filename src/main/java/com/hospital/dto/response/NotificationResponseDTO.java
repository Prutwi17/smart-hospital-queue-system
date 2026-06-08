package com.hospital.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationResponseDTO {

    private Long id;

    private String message;

    private Boolean readStatus;

    private LocalDateTime createdAt;
}