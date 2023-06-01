package com.example.Studijos.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "darboUzimtumas")
public class DarboUzimtumas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dienosData;

    private Long uzimtosValandos;

    @ManyToOne
    @JoinColumn(name = "studentoDarbas_id")
    private StudentoDarbas studentoDarbas;
}
