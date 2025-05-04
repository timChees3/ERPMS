package com.toinfinityandbeyong.ERPMS.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VitalsRequest
{
    @NotNull
    private Long patientId;

    @PastOrPresent
    private LocalDateTime recordTime;

    @Min(value = 30)
    @Max(value = 250)
    private Integer heartRate;

    @Min(value = 50)
    @Max(value = 250)
    private Integer systolicBP;

    @Min(value = 30)
    @Max(value = 150)
    private Integer diastolicBP;

    @Min(value = 50)
    @Max(value = 100)
    private Double oxygenSaturation;

    @Min(value = 30)
    @Max(value = 45)
    private Double temperature;

    private String notes;
}
