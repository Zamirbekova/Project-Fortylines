package com.hadicha.projectfortylines.serviceimpl;

import com.hadicha.projectfortylines.exception.NotFoundException;
import com.hadicha.projectfortylines.model.Doctor;
import com.hadicha.projectfortylines.model.MainDoctor;
import com.hadicha.projectfortylines.model.MedicalSister;
import com.hadicha.projectfortylines.model.Patient;
import com.hadicha.projectfortylines.repository.DoctorRepository;
import com.hadicha.projectfortylines.repository.MainDoctorRepository;
import com.hadicha.projectfortylines.repository.MedicalSisterRepository;
import com.hadicha.projectfortylines.repository.PatientRepository;
import com.hadicha.projectfortylines.service.MainDoctorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class MainDoctorServiceImpl implements MainDoctorService {
    private final MainDoctorRepository repository;
    private final MedicalSisterRepository medicalSisterRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Override
    public MainDoctor save(MainDoctor mainDoctor) {
        return repository.save(mainDoctor);
    }

    @Override
    public MainDoctor findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("not ofund"));
    }

    @Override
    public List<MainDoctor> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    //number1
    @Override
    public List<MedicalSister> findAllMedicalSister() {
        MedicalSister medicalSister = new MedicalSister();
        if (medicalSister.getSalary() != 0) {
            System.out.println(medicalSister.getSalary());
            return medicalSisterRepository.findAll();
        }
        return null;
    }

    //number2
    @Override
    public List<Doctor> findAllDoctor() {
        Doctor doctor = new Doctor();
        if (doctor.getSalary() != 0) {
            System.out.println(doctor.getSalary());
            return doctorRepository.findAll();
        }
        return null;
    }

    //number3
    @Override
    public Patient findAllPatient() {
        return patientRepository.findAllPatient();
    }

    //number4
    @Override
    public void salary() {
        MedicalSister medicalSister = new MedicalSister();
        Doctor doctor = new Doctor();
        MainDoctor mainDoctor = new MainDoctor();
        if (medicalSister.getSalary() > doctor.getSalary() && medicalSister.getSalary() > mainDoctor.getSalary()) {
            System.out.println(medicalSister.getFullName() + medicalSister.getPosition() + medicalSister.getSalary() + "  samaia vysokaia zarplataa");

        }
        if (doctor.getSalary() > medicalSister.getSalary() && doctor.getSalary() > mainDoctor.getSalary()) {
            System.out.println(doctor.getFullName() + doctor.getPosition() + doctor.getSalary() + "  samaia vysokaia zarplata");
        }
        if (mainDoctor.getSalary() > medicalSister.getSalary() && mainDoctor.getSalary() > doctor.getSalary()) {
            System.out.println(mainDoctor.getFullName() + mainDoctor.getPosition() + mainDoctor.getSalary() + "  samaia vysokaia zarplata");
        }
        throw new NotFoundException("not found");
    }

    //number 5
    @Override
    public void minSalary() {
        MedicalSister medicalSister = new MedicalSister();
        Doctor doctor = new Doctor();
        MainDoctor mainDoctor = new MainDoctor();
        if (medicalSister.getSalary() < doctor.getSalary() && medicalSister.getSalary() < mainDoctor.getSalary()) {
            System.out.println(medicalSister.getFullName() + medicalSister.getPosition() + medicalSister.getSalary() + "  samaia minimalnaia zarplataa");

        }
        if (doctor.getSalary() < medicalSister.getSalary() && doctor.getSalary() < mainDoctor.getSalary()) {
            System.out.println(doctor.getFullName() + doctor.getPosition() + doctor.getSalary() + "  samaia minimalnaia zarplata");
        }
        if (mainDoctor.getSalary() < medicalSister.getSalary() && mainDoctor.getSalary() < doctor.getSalary()) {
            System.out.println(mainDoctor.getFullName() + mainDoctor.getPosition() + mainDoctor.getSalary() + "  samaia minimalnaia zarplata");
        }
        throw new NotFoundException("not found");

    }
    //number6
}