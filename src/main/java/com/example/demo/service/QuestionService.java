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
     * @return save created Question in database
     * To create a new question and save it in the database
     */
    public Question saveQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    /**
     *
     * @return get list of all Questions
     * To get all questions saved in database.
     */
    public List<Question> getAll() {
        return this.questionRepository.findAll();
}

    /**
     *
     * @param questionAmount of questions to create
     * @return create new question and add to list / database
     * To create a random question for testing purposes.
     */
    public List<Question> createRandomQuestion(int questionAmount) {
        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < questionAmount; i++) {
            questions.add(new Question(i,"Frage" + "" + i, "Antwort" + " " + i));
        }
        return this.questionRepository.saveAll(questions);
    }
}