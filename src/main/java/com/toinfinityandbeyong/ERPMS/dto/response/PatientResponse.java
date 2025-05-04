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
public class PatientResponse extends UserResponse
{
    private String bloodGroup;
    private Double height;
    private Double weight;
    private String emergencyContactName;
    private String emergencyContactNumber;
    private String allergies;
    private List<VitalsResponse> recentVitals;
    private List<AppointmentResponse> upcomingAppointments;
}
