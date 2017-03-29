package com.example.schaelth.projet.model;

import com.orm.SugarRecord;

/**
 * Created by schaelth on 15/03/17.
 */

public class Question extends SugarRecord{
    private String question;
    private String bonneReponse;
    private String mauvaiseReponse1;
    private String mauvaiseReponse2;
    private String type;

    public Question() {
    }

    public Question(String question, String bonneReponse, String mauvaiseReponse1, String mauvaiseReponse2, String type) {
        this.question = question;
        this.bonneReponse = bonneReponse;
        this.mauvaiseReponse1 = mauvaiseReponse1;
        this.mauvaiseReponse2 = mauvaiseReponse2;
        this.type = type;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getBonneReponse() {
        return bonneReponse;
    }

    public void setBonneReponse(String bonneReponse) {
        this.bonneReponse = bonneReponse;
    }

    public String getMauvaiseReponse1() {
        return mauvaiseReponse1;
    }

    public void setMauvaiseReponse1(String mauvaiseReponse1) {
        this.mauvaiseReponse1 = mauvaiseReponse1;
    }

    public String getMauvaiseReponse2() {
        return mauvaiseReponse2;
    }

    public void setMauvaiseReponse2(String mauvaiseReponse2) {
        this.mauvaiseReponse2 = mauvaiseReponse2;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
