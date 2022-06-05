package com.hadicha.projectfortylines.serviceimpl;

import com.hadicha.projectfortylines.exception.NotFoundException;
import com.hadicha.projectfortylines.model.MedicalSister;
import com.hadicha.projectfortylines.model.Patient;
import com.hadicha.projectfortylines.repository.MedicalSisterRepository;
import com.hadicha.projectfortylines.repository.PatientRepository;
import com.hadicha.projectfortylines.service.DoctorService;
import com.hadicha.projectfortylines.service.MedicalSisterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class MedicalSisterServiceImpl implements MedicalSisterService {
    private  MedicalSisterRepository repository;
    private  PatientRepository patientRepository;
    private  DoctorService doctorService;
@Autowired
    public void setRepository(MedicalSisterRepository repository) {
        this.repository = repository;
    }
@Autowired
    public void setPatientRepository(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
@Autowired
    public void setDoctorService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @Override
    public MedicalSister save(MedicalSister medicalSister) {
        return repository.save(medicalSister);
    }

    @Override
    public MedicalSister findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("not found"));
    }

    @Override
    public List<MedicalSister> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public MedicalSister findAllByAssignments(String assignments) {
        return repository.findAllByAssignments(assignments);
    }


    //number1
    @Override
    public List<Patient> findAllProcedure() {
        Patient patient = new Patient();
        return patientRepository.findAllByFullNameAndProcedure(patient.getFullName(), patient.getProcedure());
    }

    //number2
    @Override
   public List<Patient> findByName(String name) {
        return patientRepository.findByFullName(name);
    }

    //number3
//@Override
//    public void getAllProcedure(String procedure) {
//        doctorService.saveAssignmentsToMedicalSister();
//    }

    //number4
    @Override
    public MedicalSister doProcedure(MedicalSister medicalSister) {
       MedicalSister m= repository.save(medicalSister);
        System.out.println(m.getAssignments());
return m;
    }

}
