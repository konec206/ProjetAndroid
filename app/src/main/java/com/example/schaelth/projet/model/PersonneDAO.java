package com.example.schaelth.projet.model;

import java.util.List;

/**
 * Created by schaelth on 18/10/16.
 */

public class PersonneDAO {

    public static List<Personne> selectAll() {
        return Personne.listAll(Personne.class);
    }
    public static List<Personne> selectFromNomPrenom(String nom, String prenom) {return Personne.find(Personne.class, "nom = ? adn prenom = ?", nom, prenom);}
}