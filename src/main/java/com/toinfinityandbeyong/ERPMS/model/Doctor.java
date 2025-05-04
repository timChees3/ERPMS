package com.toinfinityandbeyong.ERPMS.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("DOCTOR")
@Table(name = "doctors")
public class Doctor extends User
{
    @Column(nullable = false)
    private String specialization;

    @Column(nullable = false)
    private String licenseNumber;

    @Column
    private String degrees;

    @Column
    private Integer yearsOfExperience;

    @Column
    private String workingHours;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments = new ArrayList<>();

    @OneToMany(mappedBy = "assignedDoctor", cascade = CascadeType.ALL)
    private List<Patient> patients = new ArrayList<>();

    public void addPatient(Patient patient)
    {
        patients.add(patient);
    }

    public void addAppointment(Appointment appointment)
    {
        appointments.add(appointment);
    }
}
