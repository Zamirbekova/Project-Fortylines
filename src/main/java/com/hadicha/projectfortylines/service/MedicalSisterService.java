package com.hadicha.projectfortylines.service;

import com.hadicha.projectfortylines.model.MedicalSister;
import com.hadicha.projectfortylines.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MedicalSisterService {
    MedicalSister save(MedicalSister medicalSister);

    MedicalSister findById(Long id);

    List<MedicalSister> findAll();

    //     void getAllProcedure(String procedure);
    void delete(Long id);

    List<Patient> findByName(String name);

    List<Patient> findAllProcedure();

    MedicalSister findAllByAssignments(String assignments);

    MedicalSister doProcedure(MedicalSister medicalSister);
}
