package com.example.demo.service;

import com.example.demo.model.Question;
import com.example.demo.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public Question saveQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    public List<Question> getAll() {
        return this.questionRepository.findAll();
    }
}
