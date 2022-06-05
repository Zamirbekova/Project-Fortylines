package com.hadicha.projectfortylines.api;

import com.hadicha.projectfortylines.model.Disease;
import com.hadicha.projectfortylines.service.DiseaseService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disease")
@AllArgsConstructor
public class DiseaseApi {
    private final DiseaseService diseaseService;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('MAINDOCTOR','DOCTOR','MEDICALSISTER')")
    public Disease save(@RequestBody Disease disease) {
        return diseaseService.save(disease);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('MAINDOCTOR','DOCTOR','MEDICALSISTER')")
    public Disease findById(@PathVariable Long id) {
        return diseaseService.findById(id);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('MAINDOCTOR','DOCTOR','MEDICALSISTER')")
    public List<Disease> findAll() {
        return diseaseService.findAll();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('MAINDOCTOR','DOCTOR','MEDICALSISTER')")
    public void delete(@PathVariable Long id) {
        diseaseService.delete(id);
    }

}
