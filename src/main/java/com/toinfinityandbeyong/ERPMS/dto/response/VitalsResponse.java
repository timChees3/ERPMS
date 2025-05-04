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
public class VitalsResponse
{
    private Long id;
    private Long patientId;
    private String patientName;
    private LocalDateTime recordTime;
    private Integer heartRate;
    private Integer systolicBP;
    private Integer diastolicBP;
    private Double temperature;
    private Integer oxygenSaturation;
    private String notes;
    private boolean isAbnormal;
}
