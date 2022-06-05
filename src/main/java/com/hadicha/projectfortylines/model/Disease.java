package com.hadicha.projectfortylines.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "disease")
@Getter
@Setter
public class Disease {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "disease_seq")
    @SequenceGenerator(name = "disease_seq", sequenceName = "disease_sequence", allocationSize = 1)
    private Long id;
    private String disease;
    private LocalDateTime date_disease;
    private int daysOfTreatment;

@ManyToOne
    private Patient patient;
}
