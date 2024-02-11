package com.practice.quizapp.model.response;

import jakarta.persistence.*;
import jakarta.persistence.metamodel.IdentifiableType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String difficultlevel;
    private String rightAnswer;
    private String category;

}
