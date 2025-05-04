package com.toinfinityandbeyong.ERPMS.dto.response;

import java.time.*;
import com.toinfinityandbeyong.ERPMS.model.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentResponse
{
    private Long id;
    private LocalDate date;
    private LocalTime time;
    private Long patientId;
    private String patientName;
    private Long doctorId;
    private String doctorName;
    private String notes;
    private AppointmentStatus status;
}
