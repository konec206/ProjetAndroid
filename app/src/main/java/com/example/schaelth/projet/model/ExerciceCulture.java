package com.example.schaelth.projet.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by schaelth on 15/03/17.
 */

public class ExerciceCulture {
    private ArrayList<Question> questions;

    public ExerciceCulture(ArrayList<Question> questions) {
        this.questions = questions;
    }
    public ExerciceCulture(){/*Constructeur vide*/ questions = new ArrayList<>(); }
    public ArrayList<Question> getQuestions() {
        return questions;
    }
    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }
    public Question getQuestionAtIndice(int i) {return this.questions.get(i);}

    public int generateQuestionReponses() {
        Random random = new Random();
        return random.nextInt(this.questions.size());
    }

    public void createListQuestions(int taille, String typeQuestion) {
        ArrayList<Question> listeQuestionsAlea = new ArrayList<>();
        List<Question> listeComplete = QuestionDAO.selectAllWhereType(typeQuestion);
        for (int i = 0; i < taille; i++) {
            Util util = new Util();
            int indice = util.getIndiceAleatoire(listeComplete.size());
            listeQuestionsAlea.add(listeComplete.get(indice));
            listeComplete.remove(indice);
        }
        questions = listeQuestionsAlea;
    }
}
