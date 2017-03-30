package com.example.schaelth.projet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.schaelth.projet.model.Personne;

public class InscriptionActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText nomView;
    private EditText prenomView;
    private TextView consigne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        Button valider = (Button) findViewById(R.id.buttonValiderInscription);

        consigne = (TextView) findViewById(R.id.textViewAttention);
        consigne.setVisibility(View.INVISIBLE);

        prenomView = (EditText) findViewById(R.id.editTextPrenomInscription);
        nomView = (EditText) findViewById(R.id.editTextNomInscription);

        valider.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String nom = nomView.getText().toString();
        String prenom = prenomView.getText().toString();
        Personne personne;
        if (nom != "" && nom.length() > 3 && !nom.contains(" ") && prenom != "" && prenom.length() >3 && !prenom.contains(" ")) {
            personne = new Personne(nom, prenom, 0);
            personne.save();
            MyApp app = (MyApp)getApplicationContext();
            app.setUser(personne);


            Intent intent = new Intent(this, MenuPrincipalActivity.class);

            setResult(RESULT_OK);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            startActivity(intent);
        } else {
            consigne.setVisibility(View.VISIBLE);

            String notification = "Si tu as laissé un des deux champ vide, rempli-le!";
            Toast.makeText(this, notification, Toast.LENGTH_LONG).show();
        }
    }
}
