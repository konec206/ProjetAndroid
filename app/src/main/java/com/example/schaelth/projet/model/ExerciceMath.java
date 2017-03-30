package com.example.schaelth.projet.model;

import com.example.schaelth.projet.MyApp;

import java.util.Random;

/**
 * Created by schaelth on 14/03/17.
 */

public class ExerciceMath {
    private int i;
    private int j;
    private int bonnesReponses;
    private int mauvaisesReponses;

    private int reponseCorrigee;
    private String type;

    public ExerciceMath(String type) {

        this.i = 0;
        this.j = 0;

        this.bonnesReponses = 0;
        this.mauvaisesReponses = 0;
        this.reponseCorrigee = 0;

        this.type = type;
    }

    public int getJ() {
        return j;
    }
    public void setJ(int j) {
        this.j = j;
    }
    public int getBonnesReponses() {
        return bonnesReponses;
    }
    public void setBonnesReponses(int bonnesReponses) {
        this.bonnesReponses = bonnesReponses;
    }
    public int getMauvaisesReponses() {
        return mauvaisesReponses;
    }
    public void setMauvaisesReponses(int mauvaisesReponses) {
        this.mauvaisesReponses = mauvaisesReponses;
    }
    public int getI() {
        return i;
    }
    public void setI(int i) {
        this.i = i;
    }
    public int getReponseAttendue() {
        return (this.i + this.j);
    }

    public String generateLigneCalcul() {
        String ligneCalcul;
        switch (this.type) {
            case "addition" :
                ligneCalcul = "" + this.i + " + " + this.j + " = ";
            break;
            case "multiplication" :
                ligneCalcul = "" + this.i + " X " + this.j + " = ";
            break;
            case "division" :
                ligneCalcul = "" + this.i + " / " + this.j + " = ";
                break;
            default :
                ligneCalcul = "Erreur dans la production de la ligne de calcul";
        }
        return ligneCalcul;
    }

    public String generateBonneReponse() {
        String ligneBonneReponse;
        switch (this.type) {
            case "addition" :
                ligneBonneReponse = "" + this.i + " + " + this.j + " = " + this.reponseCorrigee;
            break;
            case "multiplication" :
                ligneBonneReponse = "" + this.i + " X " + this.j + " = " + this.reponseCorrigee;
            break;
            case "division" :
                ligneBonneReponse = "" + this.i + " / " + this.j + " = " + this.reponseCorrigee;
                break;
            default :
                ligneBonneReponse = "Erreur dans la production de la ligne de correction";
        }
        return ligneBonneReponse;
    }

    public void generateCalcul() {

        Util util = new Util();

        switch (type) {
            case "addition" :
                this.i = util.getIndiceAleatoire(20);
                this.j = util.getIndiceAleatoire(20);
                this.reponseCorrigee = this.i + this.j;
                break;
            case "multiplication" :
                this.i = util.getIndiceAleatoire(10);
                this.j = util.getIndiceAleatoire(10);
                this.reponseCorrigee = this.i * this.j;
                break;
            case "division" :
                this.i = util.getIndiceAleatoire(30);
                this.j = util.getIndiceAleatoire(30);
                while (this.j == 0 || this.i == 0 || this.i % this.j != 0) {
                    this.i = util.getIndiceAleatoire(20);
                    this.j = util.getIndiceAleatoire(20);
                }
                this.reponseCorrigee = this.i / this.j;
                break;
        }
    }
    public boolean verifierCalcul(int reponse) {
        if (reponse == this.reponseCorrigee) {
            this.bonnesReponses++;
            return true;
        } else {
            this.mauvaisesReponses++;
            return false;
        }
    }
}
