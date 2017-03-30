package com.example.schaelth.projet;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.schaelth.projet.model.Personne;

public class ResultatActivity extends AppCompatActivity implements View.OnClickListener{

    private MyApp app;
    private Personne personne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);

        app = (MyApp) getApplicationContext();
        personne = app.getUser();

        int bonneRep = getIntent().getIntExtra(ExerciceMathActivity.ACTIVITY_RESULTAT_BONNE_REPONSE, 0);
        int mauvaiseRep = getIntent().getIntExtra(ExerciceMathActivity.ACTIVITY_RESULTAT_MAUVAISE_REPONSE, 0);

        Button retour = (Button) findViewById(R.id.buttonRetourMenuPrincipal);
        Button recommencer = (Button) findViewById(R.id.buttonRecommencer);

        TextView textViewBonneRep = (TextView) findViewById(R.id.textViewBonneRepMath);
        TextView textViewMauvaisesRep = (TextView) findViewById(R.id.textViewMauvaisesRepMath);
        TextView textViewScore = (TextView) findViewById(R.id.textViewScore);

        TextView message = (TextView) findViewById(R.id.textViewResultat1);
        if (bonneRep > 5) {
            message.setText("Bravo!\nTu as terminé cette activité en trouvant plus de 5 bonnes réponses!");
            message.setTextColor(Color.GREEN);
            message.setTextSize(18);

            if (personne.getNom() != null) {
                personne = Personne.find(Personne.class, "nom = ? and prenom = ?", personne.getNom(), personne.getPrenom()).get(0);
                personne.setScore(personne.getScore() + bonneRep);
                personne.save();
            }
        } else {
            message.setText("Tu as terminé cette activité, mais tu as fais plus de 5 erreurs\nPour améliorer ton score, recommence cet exercice!");
            message.setTextSize(18);
            message.setTextColor(Color.WHITE);
        }

        textViewBonneRep.setText("Bonnes réponses : " + bonneRep);
        textViewMauvaisesRep.setText("Mauvaises réponses : " + mauvaiseRep);

        textViewScore.setText("Ton score : " + personne.getScore());

        retour.setOnClickListener(this);
        recommencer.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.buttonRetourMenuPrincipal :
                intent = new Intent(this, MenuPrincipalActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            break;
            case R.id.buttonRecommencer :
                intent = new Intent(this, getCallingActivity().getClass());
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            break;
        }
    }
}
