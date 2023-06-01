package com.example.Studijos.service;

import com.example.Studijos.dto.DarboUzimtumasDto;
import com.example.Studijos.dto.GrafikasDto;
import com.example.Studijos.dto.StudentoDarbasDto;
import com.example.Studijos.entities.DarboUzimtumas;
import com.example.Studijos.entities.StudentoDarbas;
import com.example.Studijos.repository.StudentoDarbasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentoDarbasService {

    private final StudentoDarbasRepository studentoDarbasRepository;

    private final long moksloDarboLaikas = 8L;

    @Autowired
    public StudentoDarbasService(StudentoDarbasRepository studentoDarbasRepository) {
        this.studentoDarbasRepository = studentoDarbasRepository;
    }

    public List<GrafikasDto> gautiGrafika(StudentoDarbasDto studentoDarbasDto) {
        issaugotiIDuomenuBaze(studentoDarbasDto);
        long apimtisDarbo = studentoDarbasDto.getDarboApimtis();
        List<DarboUzimtumasDto> uzimtumasDarbo = studentoDarbasDto.getDarboUzimtumas();
        return sudarytiGrafika(apimtisDarbo, uzimtumasDarbo);


    }

    private List<GrafikasDto> sudarytiGrafika(Long apimtisDarbo, List<DarboUzimtumasDto> uzimtumasDarbo) {
        List<GrafikasDto> grafikaiDto = new ArrayList<>();
        long sudarytoGrafikoValandos = 0L;
        for(DarboUzimtumasDto darboUzimtumasDto: uzimtumasDarbo) {
            GrafikasDto grafikasDto = new GrafikasDto();
            grafikasDto.setDienosData(darboUzimtumasDto.getDienosData());
            long valandos = moksloDarboLaikas - darboUzimtumasDto.getUzimtosValandos();
            sudarytoGrafikoValandos += valandos;
            grafikasDto.setValandosDarbui(valandos);
            grafikaiDto.add(grafikasDto);
        }
        if (apimtisDarbo < sudarytoGrafikoValandos )
            return null;

        return grafikaiDto;
    }

    private void issaugotiIDuomenuBaze(StudentoDarbasDto studentoDarbasDto) {
        StudentoDarbas studentoDarbas = new StudentoDarbas();
        studentoDarbas.setDarboPradzia(studentoDarbasDto.getDarboPradzia());
        studentoDarbas.setDarboPabaiga(studentoDarbasDto.getDarboPabaiga());
        studentoDarbas.setDarboApimtis(studentoDarbasDto.getDarboApimtis());
        List<DarboUzimtumasDto> darboUzimtumasDtos = studentoDarbasDto.getDarboUzimtumas();
        if (darboUzimtumasDtos != null && !darboUzimtumasDtos.isEmpty()) {
            List<DarboUzimtumas> darboUzimtumasList = darboUzimtumasDtos.stream()
                    .map(darboUzimtumasDto -> convertToDarboUzimtumas(darboUzimtumasDto, studentoDarbas))
                    .collect(Collectors.toList());
            studentoDarbas.setDarboUzimtumas(darboUzimtumasList);
        }

        studentoDarbasRepository.save(studentoDarbas);
    }

    private DarboUzimtumas convertToDarboUzimtumas(DarboUzimtumasDto darboUzimtumasDto, StudentoDarbas studentoDarbas) {
        DarboUzimtumas darboUzimtumas = new DarboUzimtumas();
        darboUzimtumas.setDienosData(darboUzimtumasDto.getDienosData());
        darboUzimtumas.setUzimtosValandos(darboUzimtumasDto.getUzimtosValandos());
        darboUzimtumas.setStudentoDarbas(studentoDarbas);
        return darboUzimtumas;
    }
}
