package com.toinfinityandbeyong.ERPMS.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MedicationRequest
{
    @NotNull
    private Long patientId;

    @NotNull
    private Long doctorId;

    @NotBlank
    private String medicationName;

    @NotBlank
    private String dosage;

    @NotBlank
    private String frequency;

    @NotNull
    private LocalDate startDate;

    @NotNull @Future
    private LocalDate endDate;

    private String instructions;

    private String purpose;
}
