package com.hadicha.projectfortylines.serviceimpl;

import com.hadicha.projectfortylines.exception.NotFoundException;
import com.hadicha.projectfortylines.model.Disease;
import com.hadicha.projectfortylines.repository.DiseaseRepository;
import com.hadicha.projectfortylines.service.DiseaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class DiseaseServiceImpl implements DiseaseService {
private final DiseaseRepository repository;

    @Override
    public Disease save(Disease disease) {
        return repository.save(disease);
    }

    @Override
    public Disease findById(Long id) {
        return repository.findById(id).orElseThrow(()->new NotFoundException("not found"));
    }

    @Override
    public List<Disease> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
repository.deleteById(id);
    }




}


