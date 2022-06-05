package com.hadicha.projectfortylines.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "medical_sisters")
@Getter
@Setter
public class MedicalSister {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "med_sisters")
    @SequenceGenerator(name = "med_sisters", sequenceName = "med_sisters", allocationSize = 1)
    private Long id;
    @ManyToMany
    @JoinTable(name = "med_patients",
            joinColumns = @JoinColumn(name = "med_id"),
            inverseJoinColumns = @JoinColumn(name = "pat_id"))
    private List<Patient> patients;
    private String assignments;
    private int salary;
    private String position;
    private String fullName;
}
