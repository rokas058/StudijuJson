package com.example.Studijos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DarboUzimtumasDto {

    private LocalDate dienosData;

    private Long uzimtosValandos;
}
