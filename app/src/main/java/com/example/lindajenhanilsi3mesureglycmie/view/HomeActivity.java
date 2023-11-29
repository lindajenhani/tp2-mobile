package com.example.lindajenhanilsi3mesureglycmie.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lindajenhanilsi3mesureglycmie.R;

public class HomeActivity extends AppCompatActivity {

    private Button btnConsultation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnConsultation = (Button) findViewById(R.id.btnConsultation);
        btnConsultation.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}