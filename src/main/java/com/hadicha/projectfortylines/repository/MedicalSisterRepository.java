package com.hadicha.projectfortylines.repository;

import com.hadicha.projectfortylines.model.MedicalSister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalSisterRepository extends JpaRepository<MedicalSister, Long> {
    MedicalSister findAllByAssignments(String assignments);
}
