package com.example.demo.service;

import com.example.demo.model.Question;
import com.example.demo.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sylvain Gilgen
 * Question service class
 * To get all questions saved in database to display in frontend
 */
@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    /**
     *
     * @param question
     * @return created Question
     * To create a new question
     */
    public Question saveQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    /**
     *
     * @return list of all Questions
     * To get all questions saved in database.
     */
    public List<Question> getAll() {
        return this.questionRepository.findAll();
    }

    /**
     *
     * @param amount of questions to create
     * @return list of created Questions
     * To display set amount of questions in frontend
     */
    public List<Question> createRandomQuestion(int amount) {
        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            questions.add(new Question(i,"Frage" + "" + i, "Antwort" + " " + i));
        }
        return this.questionRepository.saveAll(questions);
    }
}