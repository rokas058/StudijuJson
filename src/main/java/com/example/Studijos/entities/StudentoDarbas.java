package com.example.Studijos.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "studentoDarbas")
public class StudentoDarbas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate darboPradzia;

    private LocalDate darboPabaiga;

    private Long darboApimtis;

    @OneToMany(mappedBy = "studentoDarbas",cascade = CascadeType.ALL)
    private List<DarboUzimtumas> darboUzimtumas;
}
