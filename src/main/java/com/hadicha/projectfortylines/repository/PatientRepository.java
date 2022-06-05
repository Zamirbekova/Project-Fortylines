package com.hadicha.projectfortylines.repository;

import com.hadicha.projectfortylines.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
    List<Patient> findByFullName(String fullName);

    boolean existsPatientByFullName(String full);

    @Query("select count (Patient) from Patient")
    Patient findAllPatient();

    List<Patient> findAllByFullNameAndProcedure(String fullName, String procedure);
}
