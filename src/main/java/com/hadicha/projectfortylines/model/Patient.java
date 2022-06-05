package com.hadicha.projectfortylines.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "patients")
@Getter
@Setter
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pat_id")
    @SequenceGenerator(name = "pat_id", sequenceName = "pat_id", allocationSize = 1)
    private Long id;
    private String fullName;
    private LocalDate dateOfBirth;
    private int weight;
    private String height;
    private int bloodType;
    @OneToMany(mappedBy = "patient")
    private List<Disease> disease;
    @ManyToOne
    private Doctor doctors;
    private String diagnosis;
    private String procedure;
}
