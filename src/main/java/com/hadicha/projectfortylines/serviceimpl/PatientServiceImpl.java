package com.hadicha.projectfortylines.serviceimpl;

import com.hadicha.projectfortylines.exception.NotFoundException;
import com.hadicha.projectfortylines.model.Disease;
import com.hadicha.projectfortylines.model.Doctor;
import com.hadicha.projectfortylines.model.Patient;
import com.hadicha.projectfortylines.repository.DiseaseRepository;
import com.hadicha.projectfortylines.repository.DoctorRepository;
import com.hadicha.projectfortylines.repository.PatientRepository;
import com.hadicha.projectfortylines.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
private final DiseaseRepository diseaseRepository;
private final DoctorRepository doctorRepository;
    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient findById(Long id) {
        return patientRepository.findById(id).orElseThrow(() -> new NotFoundException("not found"));
    }

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        patientRepository.deleteById(id);
    }
    //number1
    @Override
    public void historyDisease() {
        Disease disease = new Disease();
        System.out.println(disease.getDate_disease() + disease.getDisease() + disease.getDaysOfTreatment());
    }
    //number2
    @Override
    public Disease findLastTime(LocalDateTime time){
        return diseaseRepository.findByDate_diseaseAfter(time);
    }
    //number3
    @Override
    public void daysOfTreatment(){
        Disease disease=new Disease();
        if (disease.getDisease()==null){
            throw new NotFoundException("not found");
        }
        System.out.println(disease.getDaysOfTreatment());
    }
    //number4
    @Override
    public List<Doctor> getAllDoctor(){
        return doctorRepository.findAll();
    }
    //number5
    public void info(){
        Patient patient=new Patient();
        System.out.println(patient.getFullName() + patient.getDateOfBirth() + patient.getWeight() + patient.getHeight()+patient.getBloodType());

    }
}
