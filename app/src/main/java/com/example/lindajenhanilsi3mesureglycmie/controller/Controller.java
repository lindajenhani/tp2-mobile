package com.example.lindajenhanilsi3mesureglycmie.controller;
import com.example.lindajenhanilsi3mesureglycmie.modele.Patient;

public final class Controller {
    private static Patient patient;
    private static Controller instance = null;

//userAction view vers controller 1/2
    public Void createPatient(int age, float valeurMesuree, boolean isFasting)
    {
        //update controller modele 2/2
        patient = new Patient(age, valeurMesuree, isFasting);
        return null;
    }

    //user action
    private Controller(){
        super();
    }

    public static Controller getInstance(){
        if(Controller.instance == null)
            Controller.instance = new Controller();
        return instance;
    }


     public  String getResult() // notify controller vers view 1/2
     {
        return patient.getResult();   //notify modele vers controller 2/2
     }
}
