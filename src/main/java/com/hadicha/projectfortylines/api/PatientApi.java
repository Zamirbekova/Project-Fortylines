package com.hadicha.projectfortylines.api;

import com.hadicha.projectfortylines.model.Disease;
import com.hadicha.projectfortylines.model.Doctor;
import com.hadicha.projectfortylines.model.Patient;
import com.hadicha.projectfortylines.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/patient")
@AllArgsConstructor
public class PatientApi {
    private final PatientService patientService;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('PATIENT')")
    public Patient save(@RequestBody Patient patient) {
        return patientService.save(patient);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('PATIENT')")

    public Patient findById(@PathVariable Long id) {
        return patientService.findById(id);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('PATIENT')")

    public List<Patient> findAll() {
        return patientService.findAll();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('PATIENT')")

    public void delete(@PathVariable Long id) {
        patientService.delete(id);
    }

    @GetMapping("/historyDisease")
    @PreAuthorize("hasAnyAuthority('PATIENT')")

    public void historyDisease() {
        patientService.historyDisease();
    }

    @GetMapping("/lastDateDisease")
    @PreAuthorize("hasAnyAuthority('PATIENT')")

    public Disease findLastDate(@RequestParam LocalDateTime time) {
        return patientService.findLastTime(time);
    }

    @GetMapping("/daysDiases")
    @PreAuthorize("hasAnyAuthority('PATIENT')")

    public void dayTreatment() {
        patientService.daysOfTreatment();
    }

    @GetMapping("/getAllDoctor")
    @PreAuthorize("hasAnyAuthority('PATIENT')")

    public List<Doctor> getAll() {
        return patientService.getAllDoctor();
    }

    @GetMapping("/info")
    @PreAuthorize("hasAnyAuthority('PATIENT')")

    public void info() {
        patientService.info();
    }

}
