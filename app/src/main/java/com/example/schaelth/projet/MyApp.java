package com.example.schaelth.projet;

import com.example.schaelth.projet.model.Personne;
import com.example.schaelth.projet.model.Question;
import com.example.schaelth.projet.model.Util;
import com.example.schaelth.projet.model.Classement;
import com.orm.SugarApp;

/**
 * Created by schaelth on 28/03/17.
 */

public class MyApp extends SugarApp {
    private Personne user;
    private Personne admin;
    private Util util;
    private Classement classement;

    @Override
    public void onCreate() {
        super.onCreate();

        // my stuff
        admin = new Personne("admin", "root", 0);
        util = new Util();
        classement = new Classement();

        user = new Personne();
        if (Personne.count(Personne.class, "nom = ? and prenom = ?", new String[] {"admin", "root"}) == 0) {
            new Personne("admin", "root", 0).save();
        }

        if (Question.count(Question.class) == 0) {
            util.initDb();
        }
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public Personne getUser() {
        return user;
    }

    public void setUser(Personne user) {
        this.user = user;
    }

    public Personne getAdmin() {
        return admin;
    }

    public void setAdmin(Personne admin) {
        this.admin = admin;
    }

    public Util getUtil() {
        return util;
    }

    public void setUtil(Util util) {
        this.util = util;
    }

    public Classement getClassement() {
        return classement;
    }

    public void setClassement(Classement classement) {
        this.classement = classement;
    }
}