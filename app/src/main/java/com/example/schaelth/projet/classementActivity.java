package com.example.schaelth.projet;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.schaelth.projet.model.Personne;

import java.util.List;

public class classementActivity extends AppCompatActivity implements View.OnClickListener{

    private MyApp app;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classement);

        app = (MyApp) getApplicationContext();
        app.getClassement().actualiser();

        LinearLayout layoutPrincipal = (LinearLayout) findViewById(R.id.linearLayoutPrincipal);
        Button quitter = (Button) findViewById(R.id.buttonQuitterClassement);

        List<Personne> classement = app.getClassement().getPersonnes();

        if (classement.size() != 0) {
            for (int i = 0; i < classement.size(); i++) {
                if (!classement.get(i).toString().equals(app.getAdmin().toString())) {
                    TextView text = new TextView(getApplicationContext());
                    LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    llp.setMargins(0, 10, 0, 0);
                    text.setLayoutParams(llp);
                    text.setText(classement.get(i).toString() + "                               score : " + classement.get(i).getScore());
                    text.setTextSize(18);
                    text.setTextColor(Color.argb(255, 255, 255, 255));
                    layoutPrincipal.addView(text);
                }
            }
        } else {
            TextView text = new TextView(getApplicationContext());
            text.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            text.setText("Personne n'est encore inscrit!");
            text.setTextColor(Color.argb(255, 255, 255, 255));
            layoutPrincipal.addView(text);
        }

        quitter.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, MenuPrincipalActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
