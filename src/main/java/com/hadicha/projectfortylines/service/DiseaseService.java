package com.hadicha.projectfortylines.service;

import com.hadicha.projectfortylines.model.Disease;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DiseaseService {
    Disease save(Disease disease);

    Disease findById(Long id);

    List<Disease> findAll();

    void delete(Long id);
}
