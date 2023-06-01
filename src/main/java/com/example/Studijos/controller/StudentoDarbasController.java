package com.example.Studijos.controller;

import com.example.Studijos.dto.GrafikasDto;
import com.example.Studijos.dto.StudentoDarbasDto;
import com.example.Studijos.service.StudentoDarbasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("/api/studijos")
public class StudentoDarbasController {

    private final StudentoDarbasService studentoDarbasService;

    @Autowired
    public StudentoDarbasController(StudentoDarbasService studentoDarbasService) {
        this.studentoDarbasService = studentoDarbasService;
    }

    @GetMapping
    public String string(){
        return "hey";
    }

    @PutMapping
    public ResponseEntity<?> gautiDarboGrafika(@RequestBody StudentoDarbasDto studentoDarbasDto){
        List<GrafikasDto> grafikaiDto = studentoDarbasService.gautiGrafika(studentoDarbasDto);
        return ResponseEntity.ok(Objects.requireNonNullElse(grafikaiDto, "Darbo nespėsi padaryti"));
    }

}
