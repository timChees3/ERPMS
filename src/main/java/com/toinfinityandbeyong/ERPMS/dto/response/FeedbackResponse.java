package com.toinfinityandbeyong.ERPMS.dto.response;

import java.time.LocalDateTime;
import com.toinfinityandbeyong.ERPMS.model.FeedbackType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackResponse
{
    private Long id;
    private Long patientId;
    private String patientName;
    private Long doctorId;
    private String doctorName;
    private String comments;
    private FeedbackType relatedTo;
    private boolean requiresAction;
    private Long vitalsId;
    private Long appointmentId;
    private Long medicationId;
    private LocalDateTime createdAt;
}
