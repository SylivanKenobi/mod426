package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

//{
//        "title": "Test",
//        "question": [
//        {
//        "question": "Hallo?",
//        "answer": "Fuck you"
//        },
//        {
//        "question": "Hallo?",
//        "answer": "Fuck you"
//        }
//        ]
//        }

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Discipline {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_discipline")
    @SequenceGenerator(name = "seq_discipline")
    private long id;

    @NotNull
    private String title;

    @OneToMany
    @JoinColumn(name="disciplineFk")
    private List<Question> questions;

    public Discipline(String title, List<Question> questions) {
        this.title = title;
        this.questions = questions;
    }
}
