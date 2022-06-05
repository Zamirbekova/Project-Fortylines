package com.hadicha.projectfortylines.api;

import com.hadicha.projectfortylines.model.Doctor;
import com.hadicha.projectfortylines.model.MainDoctor;
import com.hadicha.projectfortylines.model.MedicalSister;
import com.hadicha.projectfortylines.model.Patient;
import com.hadicha.projectfortylines.service.MainDoctorService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mainDoctor")
@AllArgsConstructor
public class MainDoctorApi {
    private final MainDoctorService mainDoctorService;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('MAINDOCTOR')")
    public MainDoctor save(@RequestBody MainDoctor mainDoctor) {
        return mainDoctorService.save(mainDoctor);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('MAINDOCTOR')")
    public MainDoctor findById(@PathVariable Long id) {
        return mainDoctorService.findById(id);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('MAINDOCTOR')")
    public List<MainDoctor> findAll() {
        return mainDoctorService.findAll();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('MAINDOCTOR')")
    public void delete(@PathVariable Long id) {
        mainDoctorService.delete(id);
    }

    @GetMapping("/getAllMedicalSister")
    @PreAuthorize("hasAnyAuthority('MAINDOCTOR')")
    public List<MedicalSister> findAllMedicalSister() {
        return mainDoctorService.findAllMedicalSister();
    }

    @GetMapping("/getAllDoctor")
    @PreAuthorize("hasAnyAuthority('MAINDOCTOR')")
    public List<Doctor> findAllDoctors() {
        return mainDoctorService.findAllDoctor();
    }

    @GetMapping("/getCountPatient")
    @PreAuthorize("hasAnyAuthority('MAINDOCTOR')")
    public Patient findAllPatientCount() {
        return mainDoctorService.findAllPatient();
    }

    @GetMapping("/maxSalary")
    @PreAuthorize("hasAnyAuthority('MAINDOCTOR')")
    public void maxSalary() {
        mainDoctorService.salary();
    }

    @GetMapping("/minSalary")
    @PreAuthorize("hasAnyAuthority('MAINDOCTOR')")
    public void minSalary() {
        mainDoctorService.minSalary();
    }


}
