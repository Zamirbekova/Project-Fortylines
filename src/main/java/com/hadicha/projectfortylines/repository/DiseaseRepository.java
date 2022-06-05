package com.hadicha.projectfortylines.repository;

import com.hadicha.projectfortylines.model.Disease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface DiseaseRepository extends JpaRepository<Disease,Long> {
    @Query("select d from Disease d where d.date_disease > ?1")
    Disease findByDate_diseaseAfter(LocalDateTime dateTime);

}
