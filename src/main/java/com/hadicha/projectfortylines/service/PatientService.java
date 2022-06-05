package com.hadicha.projectfortylines.service;

import com.hadicha.projectfortylines.model.Disease;
import com.hadicha.projectfortylines.model.Doctor;
import com.hadicha.projectfortylines.model.Patient;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public interface PatientService {
    Patient save(Patient patient);

    Patient findById(Long id);

    List<Patient> findAll();

    void delete(Long id);

    void historyDisease();

    Disease findLastTime(LocalDateTime time);

    void daysOfTreatment();

    List<Doctor> getAllDoctor();

    void info();
}
