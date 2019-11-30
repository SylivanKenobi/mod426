package com.example.demo.service;

import com.example.demo.model.Discipline;
import com.example.demo.model.Question;
import com.example.demo.repository.DisciplineRepository;
import com.example.demo.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sylvain Gilgen
 * Discipline service class
 */
@Service
public class DisciplineService {

    @Autowired
    DisciplineRepository disciplineRepository;

    @Autowired
    QuestionRepository questionRepository;

    /**
     *
     * @return List of all Disciplines
     */
    public List<Discipline> getAll() {
        return this.disciplineRepository.findAll();
    }

    /**
     *
     * @param discipline to create
     * @return created Discipline
     */
    public Discipline saveDiscipline(Discipline discipline) {
        return this.disciplineRepository.saveAndFlush(discipline);
    }

    /**
     *
     * @return created Discipline
     */
    public Discipline createTestDiscipline() {
        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            questions.add(new Question("Frage" + "" + i, "Antwort" + " " + i));
        }
        return this.disciplineRepository.save(new Discipline("Test", this.questionRepository.saveAll(questions)));
    }

    /**
     *
     * @param discipline
     * @return Discipline
     */
    public Discipline findByDiscipline(String discipline) {
       return this.disciplineRepository.findDisciplineByTitle(discipline);
    }
}
