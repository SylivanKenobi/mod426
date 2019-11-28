package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Data
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_artikel")
    @SequenceGenerator(name = "seq_artikel")
    private long id;

    @NotNull
    private String question;

    @NotNull
    private String answer;

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
}
