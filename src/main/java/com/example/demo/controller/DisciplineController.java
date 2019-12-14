package com.example.demo.controller;

import com.example.demo.model.Discipline;
import com.example.demo.service.DisciplineService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  @author Sylvain Gilgen
 * Discipline controller class
 */
@Controller
@RequestMapping("/api/discipline")
public class DisciplineController {

    private final DisciplineService disciplineService;

    public DisciplineController(DisciplineService disciplineService) {
        this.disciplineService = disciplineService;
    }

    /**
     *
     * @return List of all Disciplines
     */
    @GetMapping
    public ResponseEntity<List<Discipline>> getAllDisciplines() {
        return ResponseEntity.ok().body(this.disciplineService.getAllDisciplines());
    }

    /**
     *
     * @param discipline
     * @return Requested Discipline as JSON
     */
    @GetMapping("/{discipline}")
    public ResponseEntity<Discipline> getDisciplines(@PathVariable String discipline) {
        return ResponseEntity.ok().body(this.disciplineService.findByDiscipline(discipline));
    }

    /**
     *
     * @param discipline
     * @return Created discipline as JSON
     */
    @PostMapping
    public ResponseEntity<Discipline> createDiscipline(@RequestBody Discipline discipline) {
        return ResponseEntity.ok().body(this.disciplineService.saveDiscipline(discipline));
    }

    /**
     *
     * @return Created discipline as JSON
     */
    @GetMapping("/random")
    public ResponseEntity<Discipline> createRandomDiscipline() {
        return ResponseEntity.ok().body(this.disciplineService.createTestDiscipline());
    }
}
