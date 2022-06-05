package com.hadicha.projectfortylines.serviceimpl;

import com.hadicha.projectfortylines.exception.NotFoundException;
import com.hadicha.projectfortylines.model.Doctor;
import com.hadicha.projectfortylines.model.MedicalSister;
import com.hadicha.projectfortylines.model.Patient;
import com.hadicha.projectfortylines.repository.DoctorRepository;
import com.hadicha.projectfortylines.repository.PatientRepository;
import com.hadicha.projectfortylines.service.DoctorService;
import com.hadicha.projectfortylines.service.MedicalSisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {
    private  DoctorRepository repository;
    private  PatientRepository patientRepository;
    private  MedicalSisterService medicalSisterService;
@Autowired
    public void setRepository(DoctorRepository repository) {
        this.repository = repository;
    }
@Autowired
    public void setPatientRepository(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
@Autowired
    public void setMedicalSisterService(MedicalSisterService medicalSisterService) {
        this.medicalSisterService = medicalSisterService;
    }

    @Override
    public Doctor save(Doctor doctor) {
        return repository.save(doctor);
    }

    @Override
    public Doctor findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("not found "));
    }

    @Override
    public List<Doctor> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Patient> Number1() {
        return patientRepository.findAll();
    }

    @Override
    public Patient number2() {
        return patientRepository.findAllPatient();
    }

    @Override
    public Doctor number3(String assignments) {
        return repository.findAllByAssignments(assignments);
    }

    //number4
    @Override
    public void saveAssignmentsToMedicalSister() {
        Doctor doctor = new Doctor();
        MedicalSister medicalSister = new MedicalSister();
        medicalSister.setAssignments(doctor.getAssignments());
        System.out.println(medicalSister.getAssignments());
        System.out.println("successfully");
    }

    //number5
    @Override
    public MedicalSister getAllAssignments(String assignments) {
        return medicalSisterService.findAllByAssignments(assignments);
    }

    //number6
    @Override
    public Patient findByName(String name) {
        patientRepository.findByFullName(name);
        boolean exist = patientRepository.existsPatientByFullName(name);
        if (exist) {
            Patient patient = new Patient();
            System.out.println(patient.getDiagnosis());
            System.out.println(patient.getFullName() + patient.getHeight() + patient.getDisease() + patient.getWeight() + patient.getDiagnosis() + patient.getBloodType() + patient.getDateOfBirth());
            System.out.println(patient.getDisease());
        }
        throw new NotFoundException("not found");
    }

    //  number7
    @Override
    public Patient setDiagnosis(Patient patient) {
        Doctor doctor = new Doctor();
        patient.setDiagnosis(doctor.getDiagnosis());
        return patientRepository.save(patient);
    }
}
//number8




