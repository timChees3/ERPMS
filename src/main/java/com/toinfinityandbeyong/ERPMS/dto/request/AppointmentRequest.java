package com.toinfinityandbeyong.ERPMS.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppointmentRequest
{
    @NotNull
    private Long patientId;

    @NotNull
    private Long doctorId;

    @NotNull @Future
    private LocalDate appointmentDate;

    @NotNull @Future
    private LocalTime appointmentTime;

    @Size(max = 500)
    private String notes;
}
