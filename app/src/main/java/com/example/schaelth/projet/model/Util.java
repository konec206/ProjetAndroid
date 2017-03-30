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
        //Questions d'histoire
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

        //Questions de français
        new Question("Quel est le groupe du verbe voir?", "3e", "2e", "1e", "francais").save();
        new Question("Cochez la proposition qui présente une erreur.", "Il la pris dans sa main", "Il l'a pris dans sa main", "Il la prit dans sa main", "francais").save();
        new Question("Une seule de ces formes verbales est fausse, laquelle ?", "Il mourait", "Il mourrut", "Il mourait", "francais").save();
        new Question("\"Echarpe\" et \"écharde\"; \"croasser et \"coasser\" sont des …", "Homonymes", "Synonymes", "Paronymes", "francais").save();
        new Question("Les déterminants accompagnent des :", "Noms", "Verbes", "Adjectifs", "francais").save();
        new Question("Parmi les déterminants suivants, lesquels sont des déterminants démonstratifs ?", "Ce - cet - cette - ces", "Un - une - des", "Nos, vos, leurs", "francais").save();
        new Question("'Ce n'est pas bientôt fini ___', a crié le professeur.", "?", "!", ".", "francais").save();
        new Question("'Tu manges beaucoup trop de bonbons ___', s'exclama la mère de Coline.", "!", "?", ".", "francais").save();
        new Question("Est-ce que ça mord ___", "?", "!", "...", "francais").save();
        new Question("Ne fais pas de bruit en t'approchant du bord ___", ".", "!", "?", "francais").save();
        new Question("Parmi, les suivantes, laquelle est une phrase déclarative ?", "Vous passerez de longues heures au bord de l'eau.", "Vous verrez, ce lac est magnifique !", "Restez loin du bord.", "francais").save();
        new Question("Parmi, les suivantes, laquelle est une phrase interrogative ?", "Est-ce que 'La Petite Sirène' est un conte d'Andersen ?", "'La Petite Sirène' est un conte d'Andersen.", "Lis ce conte écrit par Andersen : 'La Petite Sirène'.", "francais").save();

        //Question de culture Générale
        new Question("Comment la mère de Bart Simpson se prénomme-t-elle?", "Marge", "Maggie", "Homer", "cultureG").save();
        new Question("Combien de chromosomes chaque individu possède-t-il, normalement?", "46", "23", "56", "cultureG").save();
        new Question("Auquel de ces termes associe-t-on l'IVG?", "Avortement", "Souci", "Manger", "cultureG").save();
        new Question("Qui a écrit 'Le Fils naturel'?", "Diderot", "Voltaire", "Rousseau", "cultureG").save();
        new Question("Laquelle de ces plantes est liée au 1er mai?", " Le muguet", "Les orties", "La rose", "cultureG").save();
        new Question("Comment dit-on 'lundi' en allemand?", "Montag", "Dienstag", "Mittwoch", "cultureG").save();
        new Question("Duquel de ces handicaps le professeur Tournesol est-il victime?", "La surdité", "La cécité", "Le mutisme", "cultureG").save();
        new Question("À laquelle de ces couleurs associe-t-on le magenta?", "Le rose foncé", "Le bleu", "Le vert clair", "cultureG").save();
        new Question("Quel groupe nous chantait 'Let It Be', à l'origine?", "Les Beatles", "Vox Angeli", "Kids United", "cultureG").save();
        new Question("Qui est Iolanda Cristina Gigliotti?", "Dalida", "Jenifer", "Louane", "cultureG").save();
        new Question("Comment s'appelle le chien de Tintin ?", "Milou", "Igor", "Lucky", "cultureG").save();
        new Question("Parmi ces marques de voitures, laquelle est française ?", "Renault", "Porsche", "Audi", "cultureG").save();
    }
}
