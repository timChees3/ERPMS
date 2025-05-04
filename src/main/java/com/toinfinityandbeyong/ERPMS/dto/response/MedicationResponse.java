package com.toinfinityandbeyong.ERPMS.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MedicationResponse
{
    private Long id;
    private Long patientId;
    private String patientName;
    private Long doctorId;
    private String doctorName;
    private String medicationName;
    private String dosage;
    private String frequency;
    private String instructions;
    private String purpose;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDateTime prescribedAt;
    private boolean isActive;
}
