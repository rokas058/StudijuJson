package com.example.Studijos.dto;

import com.example.Studijos.entities.DarboUzimtumas;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentoDarbasDto {

    private LocalDate darboPradzia;

    private LocalDate darboPabaiga;

    private Long darboApimtis;

    private List<DarboUzimtumasDto> darboUzimtumas;
}
