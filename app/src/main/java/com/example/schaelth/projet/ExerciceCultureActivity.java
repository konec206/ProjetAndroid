package com.example.schaelth.projet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

import com.example.schaelth.projet.model.ExerciceCulture;
import com.example.schaelth.projet.model.Question;
import com.example.schaelth.projet.model.Util;

public class ExerciceCultureActivity extends AppCompatActivity implements View.OnClickListener{
    private ArrayList<Question> questions;
    private int indiceQuestion;
    private ExerciceCulture exerciceHistoire;
    private Question question;
    private TextView textViewQuestion;
    private RadioButton reponse1, reponse2, reponse3;
    private RadioGroup radioGroup;
    private String typeExercice;

    private int bonneReponse = 0;
    private int mauvaiseReponse = 0;

    public static String ACTIVITY_RESULTAT_BONNE_REPONSE = "resultat_bonne_rep";
    public static String ACTIVITY_RESULTAT_MAUVAISE_REPONSE = "resultat_mauvaise_rep";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice_culture);

        typeExercice = getIntent().getStringExtra(MenuPrincipalActivity.EXERCICE_TYPE);

        textViewQuestion = (TextView) findViewById(R.id.textViewQuestionHistoire);
        reponse1 = (RadioButton) findViewById(R.id.radioButtonReponseHistoire1);
        reponse2 = (RadioButton) findViewById(R.id.radioButtonReponseHistoire2);
        reponse3 = (RadioButton) findViewById(R.id.radioButtonReponseHistoire3);
        Button valider = (Button) findViewById(R.id.buttonValiderHistoire);

        questions = new ArrayList<>();

        exerciceHistoire = new ExerciceCulture();

        exerciceHistoire.createListQuestions(10, typeExercice);
        questions = exerciceHistoire.getQuestions();
        generateQuestionRadioButton();

        valider.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int indiceReponse = radioGroup.getCheckedRadioButtonId();
        String reponseUtil = "";
        switch (indiceReponse) {
            case R.id.radioButtonReponseHistoire1 :
                reponseUtil = reponse1.getText().toString();
            break;
            case R.id.radioButtonReponseHistoire2 :
                reponseUtil = reponse2.getText().toString();
            break;
            case R.id.radioButtonReponseHistoire3 :
                reponseUtil = reponse3.getText().toString();
            break;
        }
        if (reponseUtil.equals(question.getBonneReponse())) {
            bonneReponse++;
        } else {
            mauvaiseReponse++;
        }

        questions.remove(indiceQuestion);
        if (questions.size() > 0) {
            generateQuestionRadioButton();
        } else {
            Intent intent = new Intent(this, ResultatActivity.class);
            intent.putExtra(ACTIVITY_RESULTAT_BONNE_REPONSE, bonneReponse);
            intent.putExtra(ACTIVITY_RESULTAT_MAUVAISE_REPONSE, mauvaiseReponse);
            startActivity(intent);
        }
    }

    public void generateQuestionRadioButton() {
        radioGroup = (RadioGroup) findViewById(R.id.radioButtonGroupHistoire);
        radioGroup.clearCheck();
        indiceQuestion = exerciceHistoire.generateQuestionReponses();
        question = exerciceHistoire.getQuestionAtIndice(indiceQuestion);
        textViewQuestion.setText(question.getQuestion());


        ArrayList<String> reponses = new ArrayList<>();
        reponses.add(question.getBonneReponse());
        reponses.add(question.getMauvaiseReponse1());
        reponses.add(question.getMauvaiseReponse2());

        Util util = new Util();
        int indice = util.getIndiceAleatoire(reponses.size());
        reponse1.setText(reponses.get(indice));
        reponses.remove(indice);
        indice = util.getIndiceAleatoire(reponses.size());
        reponse2.setText(reponses.get(indice));
        reponses.remove(indice);
        indice = util.getIndiceAleatoire(reponses.size());
        reponse3.setText(reponses.get(indice));
        reponses.remove(indice);
    }
}
