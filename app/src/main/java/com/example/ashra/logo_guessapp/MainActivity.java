package com.example.ashra.logo_guessapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView logoname,logoimag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //animation on logoimage and logoname

        Animation logo_animtn= AnimationUtils.loadAnimation(this,R.anim.amination_on_logo);//r.anim is resource file of anim and .animation_on_logo is xlm file of anim

        logoimag=findViewById(R.id.logoimag);
        logoimag.setAnimation(logo_animtn); //use animation name "logoimg_animtn"

        //applying an anumation on logoname
        logoname=findViewById(R.id.logoname);
        logoname.setAnimation(logo_animtn);

        Handler handler =new Handler();

        //splash screen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeintent= new Intent(MainActivity.this,enterhome.class);
                startActivity(homeintent);
                finish();
            }
        },6000);
    }
}
