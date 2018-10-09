package com.example.ashra.logo_guessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class enterhome extends AppCompatActivity {

    Button play_btn,score_btn,exit_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterhome);

        play_btn=(Button)findViewById(R.id.play_btn);
        score_btn=(Button)findViewById(R.id.score_btn);
        exit_btn=(Button)findViewById(R.id.exit_btn);


        play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent play_intent= new Intent(enterhome.this,entry.class);
                startActivity(play_intent);
            }
        });

        exit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
