package com.hadicha.projectfortylines.service;

import com.hadicha.projectfortylines.model.Doctor;
import com.hadicha.projectfortylines.model.MedicalSister;
import com.hadicha.projectfortylines.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface DoctorService {
    Doctor save(Doctor doctor);

    Doctor findById(Long id);

    List<Doctor> findAll();

    void delete(Long id);

    List<Patient> Number1();

    Patient number2();

    Doctor number3(String assignments);

    Patient findByName(String name);

    void saveAssignmentsToMedicalSister();

    MedicalSister getAllAssignments(String assignments);

    Patient setDiagnosis(Patient patient);
}
