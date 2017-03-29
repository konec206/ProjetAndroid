package com.example.schaelth.projet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.schaelth.projet.model.Personne;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    // ID REQUETES
    public final static int INSCRIPTION_ACTIVITY_REQUEST = 1;
    public final static int CONNEXION_ACTIVITY_REQUEST = 2;

    //Constantes
    public final static String MAIN_ACTIVITY_NAME = "nom";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button inscription = (Button) findViewById(R.id.buttonSinscrire);
        Button connexion = (Button) findViewById(R.id.buttonConnexion);
        Button invite = (Button) findViewById(R.id.buttonAnonymous);

        inscription.setOnClickListener(this);
        connexion.setOnClickListener(this);
        invite.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonSinscrire :
                Intent intentInscription = new Intent(this, InscriptionActivity.class);
                startActivityForResult(intentInscription, INSCRIPTION_ACTIVITY_REQUEST);
            break;
            case R.id.buttonConnexion :
                Intent intentConnexion = new Intent(this, ConnexionActivity.class);
                startActivityForResult(intentConnexion, CONNEXION_ACTIVITY_REQUEST);
            break;
            case R.id.buttonAnonymous :
                Intent intent = new Intent(this, MenuPrincipalActivity.class);
                MyApp app = (MyApp) getApplicationContext();
                app.setUser(new Personne());
                startActivity(intent);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        String notification;
        switch (requestCode) {
            case CONNEXION_ACTIVITY_REQUEST :
                notification = "Connexion impossible\nVeuillez vous inscrire!";
                Toast.makeText(this, notification, Toast.LENGTH_SHORT).show();
                break;
            case INSCRIPTION_ACTIVITY_REQUEST :
                if (resultCode == RESULT_OK) {
                    notification = "Inscritpion réussie\nVous pouvez vous connecter!";
                } else {
                    notification = "L'inscription a échoué!";
                }
                Toast.makeText(this, notification, Toast.LENGTH_SHORT).show();
                break;
        }
    }


}
