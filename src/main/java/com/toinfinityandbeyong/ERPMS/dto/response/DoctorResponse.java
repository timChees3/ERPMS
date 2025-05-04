package com.toinfinityandbeyong.ERPMS.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoctorResponse extends UserResponse
{
    private String specialization;
    private String licenseNumber;
    private String degrees;
    private Integer yearsOfExperience;
    private String workingHours;
    private List<AppointmentResponse> upcomingAppointments;
    private List<PatientResponse> recentPatients;
}
