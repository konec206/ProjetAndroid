package com.example.schaelth.projet;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.schaelth.projet.model.ExerciceMath;

public class ExerciceMathActivity extends AppCompatActivity implements View.OnClickListener {

    private ExerciceMath exerciceMath;
    private int nbCoups = 10;
    private int nbCoupsJoues = 0;

    private LinearLayout subLayout;
    private TextView question;
    private EditText reponse;
    private LinearLayout layout;
    private TextView message;

    private String typeExercice;

    public static String ACTIVITY_RESULTAT_BONNE_REPONSE = "resultat_bonne_rep";
    public static String ACTIVITY_RESULTAT_MAUVAISE_REPONSE = "resultat_mauvaise_rep";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice_math);

        this.typeExercice = getIntent().getStringExtra(MenuPrincipalActivity.EXERCICE_TYPE);

        this.exerciceMath = new ExerciceMath(typeExercice);

        message = new TextView(getApplicationContext());
        message.setText("A toi de jouer!");
        message.setTextSize(15);
        message.setTextColor(Color.argb(255, 255, 255, 255));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            message.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        }


        layout = (LinearLayout) findViewById(R.id.linearMath2);
        question = new TextView(getApplicationContext());
        reponse = new EditText(getApplicationContext());
        reponse.setTextColor(Color.argb(255, 255, 255, 255));
        subLayout = new LinearLayout(getApplicationContext());
        subLayout.setOrientation(LinearLayout.HORIZONTAL);

        exerciceMath.generateCalcul();
        question.setText(exerciceMath.generateLigneCalcul());
        question.setTextColor(Color.argb(255, 255, 255, 255));
        question.setTextSize(20);

        subLayout.addView(question);
        subLayout.addView(reponse);

        subLayout.setGravity(Gravity.CENTER);

        layout.addView(message);
        layout.addView(subLayout);
        Button valider = (Button) findViewById(R.id.buttonValiderMath);
        valider.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        nbCoupsJoues++;
        if (nbCoupsJoues <= nbCoups) {
            try {
                if (!reponse.getText().toString().equals("") && exerciceMath.verifierCalcul(Integer.parseInt(reponse.getText().toString()))) {
                    message.setText("Bravo tu as trouvé la bonne réponse !");
                    message.setTextColor(Color.GREEN);

                   /*int var = exerciceMath.getBonnesReponses();
                    exerciceMath.setBonnesReponses(var++);*/
                } else {
                    message.setText("Ce n'est pas la bonne réponse : " + exerciceMath.generateBonneReponse());
                    message.setTextColor(Color.RED);

                    /*int var = exerciceMath.getMauvaisesReponses();
                    exerciceMath.setMauvaisesReponses(var++);*/
                }

                exerciceMath.generateCalcul();
                question.setText(exerciceMath.generateLigneCalcul());
                reponse.setText("");
            } catch (NumberFormatException e) {
                message.setText("Attention tu dois rentrer un chiffre ou un nombre dans le cadre de réponse!");
                message.setTextColor(Color.argb(255, 255, 255, 255));
            }
        } else {
            Intent intent = new Intent(this, ResultatActivity.class);
            if (exerciceMath.getBonnesReponses() == 0) {
                exerciceMath.setMauvaisesReponses(nbCoups);
            }
            intent.putExtra(ACTIVITY_RESULTAT_BONNE_REPONSE, exerciceMath.getBonnesReponses());
            intent.putExtra(ACTIVITY_RESULTAT_MAUVAISE_REPONSE, exerciceMath.getMauvaisesReponses());

            startActivity(intent);
        }
    }
}
