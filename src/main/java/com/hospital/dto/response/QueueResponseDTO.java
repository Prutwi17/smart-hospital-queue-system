package com.hospital.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QueueResponseDTO {

    private String tokenNumber;

    private Integer queuePosition;

    private Integer estimatedWaitTime;
}