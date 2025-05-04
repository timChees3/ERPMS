package com.toinfinityandbeyong.ERPMS.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.toinfinityandbeyong.ERPMS.model.FeedbackType;
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
public class FeedbackRequest
{
    @NotNull
    private Long patientId;

    @NotNull
    private Long doctorId;

    @NotNull @Future
    private LocalDate appointmentDate;

    @NotNull @Future
    private LocalTime appointmentTime;

    @NotBlank
    private String comments;

    private FeedbackType relatedTo;

    private boolean requiresAction;

    // Optional links to related records
    private Long vitalsId;
    private Long appointmentId;
    private Long medicationId;
}
