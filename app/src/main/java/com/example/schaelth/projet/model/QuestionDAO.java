package com.example.schaelth.projet.model;

import java.util.Collections;
import java.util.List;

/**
 * Created by schaelth on 18/10/16.
 */

public class QuestionDAO {

    public static List<Question> selectAll() {
        return Question.listAll(Question.class);
    }
    public static List<Question> selectAllWhereType(String type) {
        List<Question> questions = Question.find(Question.class, "type = ?", type);
        Collections.shuffle(questions);
        return questions;
    }
}
