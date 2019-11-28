package com.example.demo.controller;

import com.example.demo.model.Question;
import com.example.demo.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/question")
public class QuestionController {


    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestions() {
        return ResponseEntity.ok().body(this.questionService.getAll());
    }

    @PostMapping
    public ResponseEntity<Question> createQuestion(@RequestBody Question question) {
        return ResponseEntity.ok().body(this.questionService.saveQuestion(question));
    }

    @GetMapping("/random")
    public ResponseEntity<List<Question>> createRandomQuestion(@RequestParam("amount") int amount) {
        return ResponseEntity.ok().body(this.questionService.createRandomQuestion(amount));
    }
}
