package com.toinfinityandbeyong.ERPMS.repository;

import com.toinfinityandbeyong.ERPMS.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
