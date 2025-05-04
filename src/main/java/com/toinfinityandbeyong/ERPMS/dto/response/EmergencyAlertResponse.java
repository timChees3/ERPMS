package com.toinfinityandbeyong.ERPMS.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmergencyAlertResponse
{
    private Long id;
    private Long patientId;
    private String patientName;
    private Long doctorId;
    private String doctorName;
    private Long vitalsId;
    private boolean isManuallyTriggered;
    private String comments;
    private LocalDateTime createdAt;
    private boolean isResolved;
    private LocalDateTime resolvedAt;
}
