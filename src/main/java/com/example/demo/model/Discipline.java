package com.example.demo.model;

import lombok.AllArgsConstructor;
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
public class Discipline {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_discipline")
    @SequenceGenerator(name = "seq_discipline")
    private long id;

    @NotNull
    private String title;

    @OneToMany
    private List<Question> question;
}
