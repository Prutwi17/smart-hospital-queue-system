package com.hospital.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DashboardResponseDTO {

    private long totalPatients;

    private long totalDoctors;

    private long totalDepartments;

    private long totalAppointments;

    private long todayAppointments;

    private long pendingAppointments;

    private long completedAppointments;

    private long cancelledAppointments;

    private long totalEmergencyRequests;

    private long criticalEmergencyRequests;
}