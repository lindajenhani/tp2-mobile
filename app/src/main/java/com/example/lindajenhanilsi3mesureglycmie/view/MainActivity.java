package com.example.lindajenhanilsi3mesureglycmie.view;

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

import com.example.lindajenhanilsi3mesureglycmie.R;
import com.example.lindajenhanilsi3mesureglycmie.controller.Controller;

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


    private Controller controller = Controller.getInstance();
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
            int age;
            float valeurMesuree;
           boolean verifAge = false;
           boolean verifValeur = false;

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
                    // useraction view vers controller 2/2
                    controller.createPatient(age, valeurMesuree, rbIsFasting.isChecked());
                    tvResult.setText(controller.getResult());
                    //notify controller vers view 2/2

            }

        }
    });
 }
}
