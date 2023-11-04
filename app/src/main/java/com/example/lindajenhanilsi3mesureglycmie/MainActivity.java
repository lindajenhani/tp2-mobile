package com.example.lindajenhanilsi3mesureglycmie;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Déclaration des éléments d'interface utilisateur
    private TextView tvage, tvResult;
    private SeekBar sbage;
    private RadioButton rbIsFasting, rbIsNotFasting;
    private EditText etValeur;
    private Button btnConsulter;


    private void init() {
        tvage = (TextView) findViewById(R.id.tvAge);
        sbage = (SeekBar) findViewById(R.id.sbAge);
        btnConsulter = (Button) findViewById(R.id.btnConsulter);
        etValeur = (EditText) findViewById(R.id.vm);
        rbIsNotFasting = (RadioButton) findViewById(R.id.rbtNon);
        rbIsFasting = (RadioButton) findViewById(R.id.rbtOui);
        tvResult = (TextView) findViewById(R.id.tvResult);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init(); // Appel de la méthode d'initialisation


        // Action en cas de changement sur la SeekBar
        sbage.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("information", "onProgressChange" + progress);
                tvage.setText("votre age:" + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Affiche un message Toast lorsque l'utilisateur commence à utiliser la SeekBar
                Toast.makeText(MainActivity.this, "Début du suivi de la SeekBar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Action à effectuer lorsque l'utilisateur arrête d'utiliser la SeekBar
            }
        });



    // Écouteur de clic pour le bouton "Consulter"
    btnConsulter.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View v){
        calculer(v); // Appel de la méthode "calculer" lorsque le bouton "Consulter" est cliqué
    }
    });
}





    // Méthode pour effectuer le calcul du niveau de glycémie
    public void calculer(View v) {
        Log.i("Information", "Bouton cliqué");
        int age;
        float valeurMesuree;
        boolean verifAge = false, verifValeur = false;

        // Vérification de l'âge
        if (sbage.getProgress() != 0)
            verifAge = true;
        else
            Toast.makeText(MainActivity.this, "Veuillez saisir votre âge !", Toast.LENGTH_SHORT).show();

        // Vérification de la valeur mesurée
        if (!etValeur.getText().toString().isEmpty())
            verifValeur = true;
        else
            Toast.makeText(MainActivity.this, "Veuillez saisir votre valeur mesurée !", Toast.LENGTH_LONG).show();

        // Si l'âge et la valeur sont valides, effectuer le calcul du niveau de glycémie
        if (verifAge && verifValeur) {
            age = sbage.getProgress();
            valeurMesuree = Float.valueOf(etValeur.getText().toString());
            boolean isFasting = rbIsFasting.isChecked();

            if (isFasting) {
                if (age >= 13) {
                    // Conditions pour le niveau de glycémie en fonction de l'âge et de la valeur mesurée
                    if (valeurMesuree < 5.0)
                        tvResult.setText("Niveau de glycémie est trop bas");
                    else if (valeurMesuree >= 5.0 && valeurMesuree <= 7.2)
                        tvResult.setText("Niveau de glycémie est normal");
                    else
                        tvResult.setText("Niveau de glycémie est trop élevé");
                } else if (age >= 6 && age <= 12) {
                    if (valeurMesuree < 5.0)
                        tvResult.setText("Niveau de glycémie est trop bas");
                    else if (valeurMesuree >= 5.0 && valeurMesuree <= 10.0)
                        tvResult.setText("Niveau de glycémie est normal");
                    else
                        tvResult.setText("Niveau de glycémie est trop élevé");
                } else if (age < 6) {
                    if (valeurMesuree < 5.5)
                        tvResult.setText("Niveau de glycémie est trop bas");
                    else if (valeurMesuree >= 5.5 && valeurMesuree <= 10.0)
                        tvResult.setText("Niveau de glycémie est normal");
                    else
                        tvResult.setText("Niveau de glycémie est trop élevé");
                }
            } else {
                // Conditions pour le niveau de glycémie en fonction du statut à jeun
                if (valeurMesuree > 10.5)
                    tvResult.setText("Niveau de glycémie est trop élevé");
                else
                    tvResult.setText("Niveau de glycémie est normal");
            }
        }
    }
}
