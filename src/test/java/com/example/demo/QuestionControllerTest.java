package com.example.demo;

import com.example.demo.controller.QuestionController;
import com.example.demo.model.Question;
import com.example.demo.service.QuestionService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

@RunWith(MockitoJUnitRunner.class)
public class QuestionControllerTest {

    @Mock
    QuestionService questionService;

    @Before
    public void init() {
        QuestionController questionController = new QuestionController(questionService);
        Question question = Question.builder()
                .question("How are you?")
                .answer("good")
                .build();
    }

    @Test
    public void shouldCreateQuestion() {
        QuestionController questionController = new QuestionController(questionService);
        Question question = Question.builder()
                .question("How are you?")
                .answer("good")
                .build();
        when(questionService.saveQuestion(any(Question.class))).thenReturn(question);

        ResponseEntity<?> response = questionController.createQuestion(question);

        assertThat(response.getStatusCode(), is(equalTo(HttpStatus.OK)));
        assertThat(response.getBody().toString(), containsString("How are you"));
        assertThat(response.getBody().toString(), containsString("good"));
    }

    @Test
    public void shouldGetAllQuestions() {
        QuestionController questionController = new QuestionController(questionService);
        Question question = Question.builder()
                .question("How are you?")
                .answer("good")
                .build();
        Question question2 = Question.builder()
                .question("How are you?")
                .answer("good")
                .build();
        Question question3 = Question.builder()
                .question("How are you?")
                .answer("good")
                .build();
        List<Question> questions = new ArrayList<>();
        questions.add(question);
        questions.add(question2);
        questions.add(question3);
        when(questionService.getAll()).thenReturn(questions);

        ResponseEntity<?> response = questionController.getAllQuestions();
        List<?> body = (List<?>) response.getBody();

        assertThat(response.getStatusCode(), is(equalTo(HttpStatus.OK)));
        assertThat(body,hasSize(3));
        assertThat(response.getBody().toString(), containsString("How are you"));
        assertThat(response.getBody().toString(), containsString("good"));
    }
}
