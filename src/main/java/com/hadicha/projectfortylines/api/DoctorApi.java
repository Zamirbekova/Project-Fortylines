package com.hadicha.projectfortylines.api;

import com.hadicha.projectfortylines.model.Doctor;
import com.hadicha.projectfortylines.model.MedicalSister;
import com.hadicha.projectfortylines.model.Patient;
import com.hadicha.projectfortylines.service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
@AllArgsConstructor
public class DoctorApi {
    private final DoctorService doctorService;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('DOCTOR')")
    public Doctor save(@RequestBody Doctor doctor) {
        return doctorService.save(doctor);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('DOCTOR')")
    public List<Doctor> findAll() {
        return doctorService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('DOCTOR')")
    public Doctor findById(@PathVariable Long id) {
        return doctorService.findById(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('DOCTOR')")
    public void deleteById(@PathVariable Long id) {
        doctorService.delete(id);
    }

    @GetMapping("/getAllPatients")
    @PreAuthorize("hasAnyAuthority('DOCTOR')")
    public List<Patient> findAllPatients() {
        return doctorService.Number1();
    }

    @GetMapping("/countPatient")
    @PreAuthorize("hasAnyAuthority('DOCTOR')")
    public Patient countPatient() {
        return doctorService.number2();
    }

    @PostMapping("/toMedical")
    @PreAuthorize("hasAnyAuthority('DOCTOR')")
    public void saveAssignments() {
        doctorService.saveAssignmentsToMedicalSister();
    }

    @GetMapping("/findAllAssignments")
    @PreAuthorize("hasAnyAuthority('DOCTOR')")
    public MedicalSister findBy(@RequestParam String assignments) {
        return doctorService.getAllAssignments(assignments);

    }

    @GetMapping("/findPatient")
    @PreAuthorize("hasAnyAuthority('DOCTOR')")
    public Patient findByPatient(@RequestParam String name) {
        return doctorService.findByName(name);

    }

    @PostMapping("/toDiagnosis")
    @PreAuthorize("hasAnyAuthority('DOCTOR')")
    public Patient toDiagnosis(@RequestBody Patient patient) {
        return doctorService.setDiagnosis(patient);
    }

    @GetMapping("/assignments")
    @PreAuthorize("hasAnyAuthority('DOCTOR')")
    public Doctor assignments(@RequestParam String assignments) {
        return doctorService.number3(assignments);
    }


}
