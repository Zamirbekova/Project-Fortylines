package com.hadicha.projectfortylines.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "doctors")
@Getter
@Setter
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doctors_id")
    @SequenceGenerator(name = "doctors_id", sequenceName = "doctors_seq", allocationSize = 1)
    private Long id;
    @OneToMany(mappedBy = "doctors")
    private List<Patient> patients;
    private String assignments;
    private String diagnosis;
    private String fullName;
    private int salary;
    private String position;
}
