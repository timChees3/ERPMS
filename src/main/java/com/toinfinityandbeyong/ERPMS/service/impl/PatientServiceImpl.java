package com.toinfinityandbeyong.ERPMS.service.impl;

import com.toinfinityandbeyong.ERPMS.dto.request.SignupRequest;
import com.toinfinityandbeyong.ERPMS.dto.response.PatientResponse;
import com.toinfinityandbeyong.ERPMS.repository.DoctorRepository;
import com.toinfinityandbeyong.ERPMS.repository.PatientRepository;
import com.toinfinityandbeyong.ERPMS.service.interfaces.AppointmentService;
import com.toinfinityandbeyong.ERPMS.service.interfaces.MedicationService;
import com.toinfinityandbeyong.ERPMS.service.interfaces.PatientService;
import com.toinfinityandbeyong.ERPMS.service.interfaces.VitalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService
{
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private VitalsService vitalsService;

    @Autowired
    private MedicationService medicationService;

    @Autowired
    private AppointmentService appointmentService;

    @Override
    public PatientResponse createPatient(SignupRequest signupRequest) {
        if (patientRepository.existsByUsername(signupRequest.getUsername())) {
            throw new BadRequestException("Username is already taken");
        }

        if (patientRepository.existsByEmail(signupRequest.getEmail())) {
            throw new BadRequestException("Email is already in use");
        }

        // Create new patient
        Patient patient = new Patient();
        patient.setFirstName(signupRequest.getFirstName());
        patient.setLastName(signupRequest.getLastName());
        patient.setUsername(signupRequest.getUsername());
        patient.setEmail(signupRequest.getEmail());
        patient.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        patient.setPhoneNumber(signupRequest.getPhoneNumber());
        patient.setRole("PATIENT");
        patient.setEmergencyContact(signupRequest.getEmergencyContact());
        patient.setMedicalHistory(signupRequest.getMedicalHistory());

        Patient savedPatient = patientRepository.save(patient);
        return convertToPatientResponse(savedPatient);
    }

    @Override
    public PatientResponse getPatientById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + id));
        return convertToPatientResponse(patient);
    }

    @Override
    public List<PatientResponse> getAllPatients() {
        return patientRepository.findAll().stream()
                .map(this::convertToPatientResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<PatientResponse> getPatientsByDoctorId(Long doctorId) {
        return patientRepository.findByDoctorId(doctorId).stream()
                .map(this::convertToPatientResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PatientResponse updatePatient(Long id, SignupRequest signupRequest) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + id));

        // Check if email is already in use by another user
        if (!patient.getEmail().equals(signupRequest.getEmail()) &&
                patientRepository.existsByEmail(signupRequest.getEmail())) {
            throw new BadRequestException("Email is already in use");
        }

        patient.setFirstName(signupRequest.getFirstName());
        patient.setLastName(signupRequest.getLastName());
        patient.setEmail(signupRequest.getEmail());
        patient.setPhoneNumber(signupRequest.getPhoneNumber());
        patient.setEmergencyContact(signupRequest.getEmergencyContact());
        patient.setMedicalHistory(signupRequest.getMedicalHistory());

        // Only update password if provided
        if (signupRequest.getPassword() != null && !signupRequest.getPassword().isEmpty()) {
            patient.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        }

        Patient updatedPatient = patientRepository.save(patient);
        return convertToPatientResponse(updatedPatient);
    }
}
