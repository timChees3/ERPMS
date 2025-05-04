package com.toinfinityandbeyong.ERPMS.service.interfaces;

import com.toinfinityandbeyong.ERPMS.dto.request.SignupRequest;
import com.toinfinityandbeyong.ERPMS.dto.response.PatientResponse;
import java.util.List;

public interface PatientService
{
    PatientResponse createPatient(SignupRequest signupRequest);
    PatientResponse getPatientById(Long id);
    List<PatientResponse> getAllPatients();
    List<PatientResponse> getPatientsByDoctorId(Long doctorId);
    PatientResponse updatePatient(Long id, SignupRequest signupRequest);
    boolean assignDoctor(Long patientId, Long doctorId);
    void deletePatient(Long id);
}
