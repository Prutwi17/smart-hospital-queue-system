package com.hospital.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "queue_tokens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QueueToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tokenNumber;

    private Integer queuePosition;

    private Integer estimatedWaitTime;

    private String status;

    @OneToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;
}
