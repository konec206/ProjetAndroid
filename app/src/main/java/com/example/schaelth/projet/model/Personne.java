package com.example.schaelth.projet.model;

import com.orm.SugarRecord;

/**
 * Created by schaelth on 21/03/17.
 */

public class Personne extends SugarRecord {

    private String nom;
    private String prenom;

    private int score;

    /* SUGARORM : OBLIGATOIRE */
    public Personne(){
    }

    public Personne(String nom, String prenom, int score){
        setNom(nom);
        setPrenom(prenom);
        setScore(score);
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return getPrenom() + " " + getNom();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
