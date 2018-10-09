package com.example.ashra.logo_guessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class levels_activity extends AppCompatActivity {

    Button easy,hard,medium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels_activity);


        easy =(Button)findViewById(R.id.easy_btn);
        medium=(Button)findViewById(R.id.medium_btn);
        hard=(Button)findViewById(R.id.hard_btn);

        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent easyintent=new Intent(levels_activity.this,level_easy_activity.class);
                startActivity(easyintent);
            }
        });

        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mediumintent=new Intent(levels_activity.this,medium_level.class);
                startActivity(mediumintent);
            }
        });

        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hardintent=new Intent(levels_activity.this,hard_level.class);
                startActivity(hardintent);
            }
        });
    }
}
