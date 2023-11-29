package com.example.lindajenhanilsi3mesureglycmie.modele;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.lindajenhanilsi3mesureglycmie.view.MainActivity;

public class Patient {

    private int age;
    private float valeurMesuree;
    private boolean isFasting;
    private String result;

    // update controller vers view 1/2
    public Patient(int age, float valeurMesuree, boolean isFasting) {
        this.age = age;
        this.valeurMesuree = valeurMesuree;
        this.isFasting = isFasting;

    }

    // Getters and setters


    public int getAge() {
        return age;
    }

    public boolean isFasting() {
        return isFasting;
    }

    public float getValeur() {
        return valeurMesuree;
    }



    public void setAge(int age) {
        this.age = age;
    }

    public void setValeur(float valeurMesuree) {
        this.valeurMesuree = valeurMesuree;
    }

    public void setFasting(boolean fasting) {
        isFasting = fasting;
    }


    private void calculer() {
        if (isFasting) {
            if (age >= 13) {
                // Conditions pour le niveau de glycémie en fonction de l'âge et de la valeur mesurée
                if (valeurMesuree < 5.0)
                    result = "Niveau de glycémie est trop bas";
                else if (valeurMesuree >= 5.0 && valeurMesuree <= 7.2)
                    result = "Niveau de glycémie est normal";
                else
                    result = "Niveau de glycémie est trop élevé";
            } else if (age >= 6 && age <= 12) {
                if (valeurMesuree < 5.0)
                    result = "Niveau de glycémie est trop bas";
                else if (valeurMesuree >= 5.0 && valeurMesuree <= 10.0)
                    result = "Niveau de glycémie est normal";
                else
                    result = "Niveau de glycémie est trop élevé";
            } else if (age < 6) {
                if (valeurMesuree < 5.5)
                    result = "Niveau de glycémie est trop bas";
                else if (valeurMesuree >= 5.5 && valeurMesuree <= 10.0)
                    result = "Niveau de glycémie est normal";
                else
                    result = "Niveau de glycémie est trop élevé";
            }
        }

    }
//notify modéle vers controller
    public String getResult(){
        return result;
    }

}

