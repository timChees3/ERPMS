package com.toinfinityandbeyong.ERPMS.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false, length = 1000)
    private String comments;

    @Column
    @Enumerated(EnumType.STRING)
    private FeedbackType relatedTo;
    @Column(nullable = false)
    private boolean requiresAction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vitals_id")
    private Vitals associatedVitals;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appointment_id")
    private Appointment associatedAppointment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medication_id")
    private Medication associatedMedication;

    @PrePersist
    protected void onCreate()
    {
        createdAt = LocalDateTime.now();
    }

}

