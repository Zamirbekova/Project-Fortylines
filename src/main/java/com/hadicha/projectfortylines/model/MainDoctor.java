package com.hadicha.projectfortylines.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "main_doctors")
@Getter
@Setter
public class MainDoctor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "main_doctors_seq")
    @SequenceGenerator(name = "main_doctors_seq", sequenceName = "main_doctors_seq", allocationSize = 1)
    private Long id;
    private String fullName;
    private int age;
    private String procedureWithPatient;
    @OneToMany
    private List<MedicalSister> sister;
    @OneToMany
    private List<Doctor> doctors;
    @OneToMany
    private List<Patient> patients;
    private String position;
    private int salary;
}
