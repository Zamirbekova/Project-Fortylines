package com.hadicha.projectfortylines.repository;

import com.hadicha.projectfortylines.model.MainDoctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainDoctorRepository extends JpaRepository<MainDoctor, Long> {

}
