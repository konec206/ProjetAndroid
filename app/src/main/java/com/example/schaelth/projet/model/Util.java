package com.example.schaelth.projet.model;

import java.util.Random;

/**
 * Created by schaelth on 28/03/17.
 */

public class Util {
    public Util() {}

    public int getIndiceAleatoire(int nbElem) {
        Random random = new Random();
        return random.nextInt(nbElem);
    }

    public void initDb() {
        new Question("De quelle couleurs est le cheval blanc d'Henry 4?", "blanc", "noir", "bleu", "histoire").save();
        new Question("Quel Louis a perdu la tête pendant la révolution française?", "Louis 16", "Louis 14", "Louis 18", "histoire").save();
        new Question("Qui était Lucy?", "Une femme préhistorique", "Un film", "Une copine de l'école", "histoire").save();
        new Question("Qui a été le président intérimaire français pendant la seconde guerre mondiale?", "Pétain", "Hollande", "De Gaule", "histoire").save();
        new Question("En quelle année la révolution française s'est-elle déroulée", "1789", "2001", "1515", "histoire").save();
        new Question("Qui était l'ennemi de la France pendant la première guerre mondiale?", "  L'Allemagne", "Le Japon", "L'Australie", "histoire").save();
        new Question("Comment s'appelait le vilain méchant pendant la seconde guerre mondiale?", "Adolf Hitler", "Hans Krüger", "Georges Bush", "histoire").save();
        new Question("Lequel n'a pas été un président Americain?", "François Hollande", "Georges Bush", "Bill Clinton", "histoire").save();
        new Question("Avec quelle arme se battait les chevaliers?", "Une épée", "Un pistolet", "Des bombes", "histoire").save();
        new Question("De quelle nationalités étaient les samouraïs?", "Japonais", "Italiens", "Autrichiens", "histoire").save();
        new Question("Où se trouve la grande muraille?", "En Chine", "En Allemagne", "En Russie", "histoire").save();
        new Question("Comment s'appelle l'hymne français?", "La Marsaillaise", "Tchikita", "La chansons des partisans", "histoire").save();

        new Question("De quelle couleurs est le cheval blanc d'Henry 4?", "blanc", "noir", "bleu", "francais").save();
        new Question("Quel Louis a perdu la tête pendant la révolution française?", "16", "14", "18", "francais").save();
        new Question("Quel est la réponse de l'univers?", "42", "25", "Moi", "francais").save();
        new Question("Qui a été le président intérimaire français pendant la seconde guerre mondiale?", "Pétain", "Hollande", "De Gaule", "francais").save();
        new Question("Répond 1.", "1", "2", "3", "francais").save();
        new Question("Répond 2.", "2", "4", "3", "francais").save();
        new Question("Répond 3.", "3", "6", "3", "francais").save();
        new Question("Répond 4.", "4", "2", "3", "francais").save();
        new Question("Répond 5.", "5", "2", "3", "francais").save();
        new Question("Répond 6.", "6", "2", "3", "francais").save();
        new Question("Répond 7.", "7", "2", "3", "francais").save();
        new Question("Répond 8.", "8", "2", "3", "francais").save();
    }
}
