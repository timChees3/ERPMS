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
@Table(name = "emergency_alerts")
public class EmergencyAlert
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor assignedDoctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vitals_id")
    private Vitals relatedVitals;

    @Column(nullable = false)
    private boolean isManuallyTriggered;

    @Column(length = 1000)
    private String comments;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private boolean isResolved;

    @Column
    private LocalDateTime resolvedAt;

    @PrePersist
    protected void onCreate()
    {
        createdAt = LocalDateTime.now();
        isResolved = false;
    }

    public void resolve()
    {
        this.isResolved = true;
        this.resolvedAt = LocalDateTime.now();
    }
}