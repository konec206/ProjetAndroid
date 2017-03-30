package com.example.schaelth.projet.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Thibaultcoeur on 30/03/2017.
 */

public class Classement {
    private List<Personne> personnes;

    public Classement(List<Personne> personnes) {
        this.personnes = personnes;
    }

    public Classement() {
        personnes = Personne.listAll(Personne.class);
        Collections.sort(personnes, new scoreComparator());
    }

    public List<Personne> getPersonnes() {
        return personnes;
    }

    public void setPersonnes(List<Personne> personnes) {
        this.personnes = personnes;
    }

    public void actualiser() {
        personnes = Personne.listAll(Personne.class);
        Collections.sort(personnes, new scoreComparator());
    }
}

class scoreComparator implements Comparator<Personne> {
    @Override
    public int compare(Personne a, Personne b) {
        return a.getScore() > b.getScore() ? 1 : -1;
    }
}
