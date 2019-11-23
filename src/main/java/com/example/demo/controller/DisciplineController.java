package com.example.demo.controller;

import com.example.demo.model.Discipline;
import com.example.demo.service.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/discipline")
public class DisciplineController {

    @Autowired
    DisciplineService disciplineService;

    @GetMapping
    public ResponseEntity<List<Discipline>> getAllDisciplines() {
        return ResponseEntity.ok().body(this.disciplineService.getAll());
    }

    @PostMapping
    public ResponseEntity<Discipline> createDiscipline(@RequestBody Discipline discipline) {
        return ResponseEntity.ok().body(this.disciplineService.saveDiscipline(discipline));
    }
}
