package com.example.ashra.logo_guessapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView correctAnswer = (TextView)findViewById(R.id.corrct_ans);
        TextView totalscoreLabel =(TextView)findViewById(R.id.total_score_text);

        int score = getIntent().getIntExtra("RIGHT_ANSWER_COUNT",0);

        SharedPreferences setting = getSharedPreferences("quizApp", Context.MODE_PRIVATE);
        int totalScore = setting.getInt("totalScore",0);
        totalScore += score;

        correctAnswer.setText(score + " /5");   //count how many corrct answer
        totalscoreLabel.setText(" " + totalScore);

        //update total score
        SharedPreferences.Editor editor=setting.edit();
        editor.commit();
    }
}
