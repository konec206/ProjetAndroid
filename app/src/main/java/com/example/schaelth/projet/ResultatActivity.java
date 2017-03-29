package com.example.schaelth.projet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultatActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);

        int bonneRep = getIntent().getIntExtra(ExerciceMathActivity.ACTIVITY_RESULTAT_BONNE_REPONSE, 0);
        int mauvaiseRep = getIntent().getIntExtra(ExerciceMathActivity.ACTIVITY_RESULTAT_MAUVAISE_REPONSE, 0);

        Button retour = (Button) findViewById(R.id.buttonRetourMenuPrincipal);
        Button recommencer = (Button) findViewById(R.id.buttonRecommencer);

        TextView textViewBonneRep = (TextView) findViewById(R.id.textViewBonneRepMath);
        TextView textViewMauvaisesRep = (TextView) findViewById(R.id.textViewMauvaisesRepMath);
        TextView textViewScore = (TextView) findViewById(R.id.textViewScore);

        textViewBonneRep.setText("Bonnes réponses : " + bonneRep);
        textViewMauvaisesRep.setText("Mauvaises réponses : " + mauvaiseRep);

        textViewScore.setText("Score : en cours de développement...");

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
