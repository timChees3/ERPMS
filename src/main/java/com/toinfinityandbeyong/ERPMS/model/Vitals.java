package com.toinfinityandbeyong.ERPMS.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vitals")
public class Vitals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @Column(nullable = false)
    private LocalDateTime recordTime;

    private Integer heartRate;
    private Integer systolicBP;
    private Integer diastolicBP;
    private Double temperature;
    private Integer oxygenSaturation;
    private String notes;

    @Column(nullable = false)
    private boolean isAbnormal;

    @PrePersist
    public void prePersist()
    {
        if (recordTime == null)
        {
            recordTime = LocalDateTime.now();
        }
    }
}