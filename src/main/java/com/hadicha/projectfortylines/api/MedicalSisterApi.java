package com.hadicha.projectfortylines.api;

import com.hadicha.projectfortylines.model.MedicalSister;
import com.hadicha.projectfortylines.model.Patient;
import com.hadicha.projectfortylines.service.MedicalSisterService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicalSister")
@AllArgsConstructor
public class MedicalSisterApi {
    private final MedicalSisterService medicalSisterService;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('MEDICALSISTER')")
    public MedicalSister save(@RequestBody MedicalSister medicalSister) {
        return medicalSisterService.save(medicalSister);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('MEDICALSISTER')")

    public MedicalSister findById(@PathVariable Long id) {
        return medicalSisterService.findById(id);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('MEDICALSISTER')")

    public List<MedicalSister> findAll() {
        return medicalSisterService.findAll();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('MEDICALSISTER')")

    public void delete(@PathVariable Long id) {
        medicalSisterService.delete(id);
    }

    @GetMapping("/getAllProcedure")
    @PreAuthorize("hasAnyAuthority('MEDICALSISTER')")

    public List<Patient> findAllProcedure() {
        return medicalSisterService.findAllProcedure();
    }

    @GetMapping("/findByNamePatient")
    @PreAuthorize("hasAnyAuthority('MEDICALSISTER')")

    public List<Patient> findByNamePatient(@RequestParam("name") String name) {
        return medicalSisterService.findByName(name);
    }
//@GetMapping("/getAllProcedure")
//@PreAuthorize("hasAnyAuthority('MEDICALSISTER')")
    //    public void getAllProcedure(@RequestParam String procedure){
//        medicalSisterService.getAllProcedure(procedure);
//}
    @PostMapping("/doProcedure")
    @PreAuthorize("hasAnyAuthority('MEDICALSISTER')")

    public MedicalSister doSaveProcedure(@RequestBody MedicalSister medicalSister) {
        return medicalSisterService.doProcedure(medicalSister);
    }

}
