package com.example.demo.controller;

import com.example.demo.model.Discipline;
import com.example.demo.model.Question;
import com.example.demo.service.DisciplineService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/discipline")
public class DisciplineController {

    private final DisciplineService disciplineService;

    public DisciplineController(DisciplineService disciplineService) {
        this.disciplineService = disciplineService;
    }

    @GetMapping
    public ResponseEntity<List<Discipline>> getAllDisciplines() {
        return ResponseEntity.ok().body(this.disciplineService.getAll());
    }

    @PostMapping
    public ResponseEntity<Discipline> createDiscipline(@RequestBody Discipline discipline) {
        return ResponseEntity.ok().body(this.disciplineService.saveDiscipline(discipline));
    }

    @GetMapping("/random")
    public ResponseEntity<Discipline> createRandomDiscipline() {
        return ResponseEntity.ok().body(this.disciplineService.createTestDiscipline());
    }
}
