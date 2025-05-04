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
@DiscriminatorValue("PATIENT")
@Table(name = "patients")
public class Patient extends User
{
    @Column
    private String bloodGroup;

    @Column
    private Double height;

    @Column
    private Double weight;

    @Column
    private String emergencyContactName;

    @Column
    private String emergencyContactNumber;

    @Column
    private String allergies;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor assignedDoctor;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vitals> vitalsHistory = new ArrayList<>();

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments = new ArrayList<>();


    public void addVitals(Vitals vitals)
    {
        vitalsHistory.add(vitals);
    }

    public void addAppointment(Appointment appointment)
    {
        appointments.add(appointment);
    }
}
