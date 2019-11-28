package com.example.demo;

import com.example.demo.controller.DisciplineController;
import com.example.demo.controller.QuestionController;
import com.example.demo.model.Discipline;
import com.example.demo.model.Question;
import com.example.demo.service.DisciplineService;
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
public class DisciplineControllerTest {

    @Mock
    DisciplineService disciplineService;

    @Mock
    QuestionService questionService;

    @Mock
    QuestionController questionController;

    private DisciplineController disciplineController;
    private Question question;
    private Question question2;
    private Question question3;
    private Discipline discipline;
    List<Question> questions = new ArrayList<>();

    @Before
    public void init() {
        disciplineController = new DisciplineController(disciplineService);
        question = Question.builder()
                .question("How are you?")
                .answer("good")
                .build();
        question2 = Question.builder()
                .question("How are you?")
                .answer("good")
                .build();
        question3 = Question.builder()
                .question("How are you?")
                .answer("good")
                .build();
        questions.add(question);
        questions.add(question2);
        questions.add(question3);
        discipline = Discipline.builder()
                .title("English")
                .questions(questions)
                .build();

    }


    @Test
    public void shouldCreateDiscipline() {
        when(disciplineService.saveDiscipline(any(Discipline.class))).thenReturn(discipline);

        ResponseEntity<?> response = disciplineController.createDiscipline(discipline);

        assertThat(response.getStatusCode(), is(equalTo(HttpStatus.OK)));
        assertThat(response.getBody().toString(), containsString("How are you"));
        assertThat(response.getBody().toString(), containsString("good"));
    }
}
