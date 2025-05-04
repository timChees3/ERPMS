package com.toinfinityandbeyong.ERPMS.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmergencyAlertRequest
{
    @NotNull
    private Long patientId;

    private Long doctorId;
    private Long vitalsId;
    private boolean isManuallyTriggered;
    private String comments;
}
