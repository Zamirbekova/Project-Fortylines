package com.hadicha.projectfortylines.service;

import com.hadicha.projectfortylines.model.Doctor;
import com.hadicha.projectfortylines.model.MainDoctor;
import com.hadicha.projectfortylines.model.MedicalSister;
import com.hadicha.projectfortylines.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MainDoctorService {
    MainDoctor save(MainDoctor mainDoctor);

    MainDoctor findById(Long id);

    List<MainDoctor> findAll();

    void delete(Long id);

    List<MedicalSister> findAllMedicalSister();

    List<Doctor> findAllDoctor();

    Patient findAllPatient();

    void salary();

    void minSalary();
}
