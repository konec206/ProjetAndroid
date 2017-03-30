package com.example.schaelth.projet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.schaelth.projet.model.Personne;
import com.example.schaelth.projet.model.Question;

public class MenuPrincipalActivity extends AppCompatActivity implements View.OnClickListener{

    public static String EXERCICE_TYPE = "TYPE_EXERCICE";
    private MyApp app;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        LinearLayout layoutItems = (LinearLayout) findViewById(R.id.layoutItemMenuPrincipal);
        layoutItems.setVerticalScrollBarEnabled(true);

        TextView titre = (TextView) findViewById(R.id.textViewMenuPrincipal1);

        app = (MyApp) getApplicationContext();
        Personne user = app.getUser();

        String name = user.getNom();
        String prenom = user.getPrenom();

        Button addition = (Button) findViewById(R.id.buttonAddition);
        Button multiplication = (Button) findViewById(R.id.buttonMultiplication);
        Button division = (Button) findViewById(R.id.buttonDivision);

        Button histoire = (Button) findViewById(R.id.buttonHistoire);
        Button francais = (Button) findViewById(R.id.buttonFrancais);
        Button cultureG = (Button) findViewById(R.id.buttonCultureG);

        Button deconnecter = (Button) findViewById(R.id.buttonDeconnexion);
        Button classement = (Button) findViewById(R.id.buttonClassement);

        if (prenom != null && name != null) {
            titre.setText("Bonjour " + prenom + " " + name + "!");

            //Si les infos de connexions correspondent à celles de l'admin
            if (user.toString().equals(app.getAdmin().toString())) {

                String notification = "Connexion en admin!";
                Toast.makeText(this, notification, Toast.LENGTH_SHORT).show();

                Button clearAdmin = new Button(getApplicationContext());
                clearAdmin.setText("Clear DataBase");
                clearAdmin.setVisibility(View.VISIBLE);

                layoutItems.addView(clearAdmin);

                clearAdmin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Question.deleteAll(Question.class);
                        Personne.deleteAll(Personne.class);

                        new Personne("admin", "root", 0).save();

                        app.getUtil().initDb();
                    }
                });
            }
        } else {
            titre.setText("Bonjour !");
        }

        addition.setOnClickListener(this);
        multiplication.setOnClickListener(this);
        histoire.setOnClickListener(this);
        francais.setOnClickListener(this);
        division.setOnClickListener(this);
        cultureG.setOnClickListener(this);
        classement.setOnClickListener(this);
        deconnecter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId())
        {
            case R.id.buttonAddition:
                intent = new Intent(this, ExerciceMathActivity.class);
                intent.putExtra(EXERCICE_TYPE, "addition");
                startActivity(intent);
            break;
            case R.id.buttonMultiplication :
                intent = new Intent(this, ExerciceMathActivity.class);
                intent.putExtra(EXERCICE_TYPE, "multiplication");
                startActivity(intent);
            break;
            case R.id.buttonDivision :
                intent = new Intent(this, ExerciceMathActivity.class);
                intent.putExtra(EXERCICE_TYPE, "division");
                startActivity(intent);
            break;
            case R.id.buttonFrancais :
                intent = new Intent(this, ExerciceCultureActivity.class);
                intent.putExtra(EXERCICE_TYPE, "francais");
                startActivity(intent);
            break;
            case R.id.buttonHistoire :
                intent = new Intent(this, ExerciceCultureActivity.class);
                intent.putExtra(EXERCICE_TYPE, "histoire");
                startActivity(intent);
            break;
            case R.id.buttonCultureG :
                intent = new Intent(this, ExerciceCultureActivity.class);
                intent.putExtra(EXERCICE_TYPE, "cultureG");
                startActivity(intent);
            break;
            case R.id.buttonDeconnexion :
                intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            break;
            case R.id.buttonClassement :
                intent = new Intent(this, classementActivity.class);
                startActivity(intent);
            break;

        }
    }
}
