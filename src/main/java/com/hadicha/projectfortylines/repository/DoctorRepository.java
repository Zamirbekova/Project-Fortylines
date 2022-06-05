package com.hadicha.projectfortylines.repository;

import com.hadicha.projectfortylines.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    Doctor findAllByAssignments(String assignments);


}
