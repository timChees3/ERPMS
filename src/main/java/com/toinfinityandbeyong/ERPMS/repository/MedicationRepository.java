package com.toinfinityandbeyong.ERPMS.repository;

import com.toinfinityandbeyong.ERPMS.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {
}
