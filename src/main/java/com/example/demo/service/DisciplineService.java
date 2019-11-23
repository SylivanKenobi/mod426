package com.example.demo.service;

import com.example.demo.model.Discipline;
import com.example.demo.repository.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplineService {

    @Autowired
    DisciplineRepository disciplineRepository;

    public List<Discipline> getAll() {
        return this.disciplineRepository.findAll();
    }

    public Discipline saveDiscipline(Discipline discipline) {
        return this.disciplineRepository.saveAndFlush(discipline);
    }
}
