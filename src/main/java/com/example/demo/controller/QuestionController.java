package com.example.demo.controller;

import com.example.demo.model.Question;
import com.example.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping
    public ResponseEntity<List<Question>> getAllDisciplines() {
        return ResponseEntity.ok().body(this.questionService.getAll());
    }

    @PostMapping
    public ResponseEntity<Question> createDiscipline(@RequestBody Question question) {
        return ResponseEntity.ok().body(this.questionService.saveQuestion(question));
    }
}
