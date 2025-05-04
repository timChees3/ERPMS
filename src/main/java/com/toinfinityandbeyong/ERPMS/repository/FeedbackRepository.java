package com.toinfinityandbeyong.ERPMS.repository;

import com.toinfinityandbeyong.ERPMS.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
