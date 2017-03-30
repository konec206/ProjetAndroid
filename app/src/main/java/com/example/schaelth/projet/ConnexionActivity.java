package com.example.schaelth.projet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.schaelth.projet.model.Personne;

public class ConnexionActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText nom;
    private EditText prenom;

    public static String CONNEXION_ACTIVITY_NOM = "nom";
    public static String CONNEXION_ACTIVITY_PRENOM = "prenom";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        prenom = (EditText) findViewById(R.id.editTextPrenomConnexion);
        nom  = (EditText) findViewById(R.id.editTextNomConnexion);

        Button valider = (Button) findViewById(R.id.buttonValiderConnexion);
        valider.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String nomText = nom.getText().toString();
        String prenomText = prenom.getText().toString();
        Personne personne = Personne.find(Personne.class, "nom = ? and prenom = ?", nomText, prenomText).get(0);
        if (personne == null) {
            Toast.makeText(getApplication(), "Tu es sur de t'être déjà incris?\nTu as dû te tromper dans ton prénom ou dans ton nom!", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(this, MenuPrincipalActivity.class);
            MyApp app = (MyApp) getApplicationContext();
            app.setUser(personne);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            startActivity(intent);
        }
    }
}
