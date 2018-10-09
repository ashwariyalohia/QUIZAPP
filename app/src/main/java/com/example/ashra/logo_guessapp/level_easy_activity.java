package com.example.ashra.logo_guessapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class level_easy_activity extends AppCompatActivity {

    private TextView question_label;
    private Button answer_btn1;
    private Button answer_btn2;
    private Button answer_btn3;
    private Button answer_btn4;

    private String right_answer;
    private int rightAnswerCount=0;
    private int quizCount =1;

    static final private  int QUIZ_COUNT = 5;

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

    String quizData[][] = {
            //{"country ","Right_answer", "choice1" , "choice2" , "choice3" }
            {"india","china","america","lahore","canada"},
            {"lahore","lahaa","india","islamabad","karachi"},
            {"karachi","amdabad","germany","rome","paris"},
            {"itlay","city","saddar","ottaw","lodon" },
            {"US","cuba","insta","fb","kashmir"},
            {"india","havana","france","sir syed","nazimabad"},
            {"itlay","america","lahore","canada","mukka"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_easy_activity);

        //findviewbt id doing here
        question_label=(TextView)findViewById(R.id.questionlabel);
        answer_btn1=(Button)findViewById(R.id.answer_btn1);
        answer_btn2=(Button)findViewById(R.id.answer_btn2);
        answer_btn3=(Button)findViewById(R.id.answer_btn3);
        answer_btn4=(Button)findViewById(R.id.answer_btn4);


        //create quizArray from quizData
        for(int i = 0 ; i<quizData.length ; i++){

            //prepare array
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData[i][0]);  //country
            tmpArray.add(quizData[i][1]);   //cright answer
            tmpArray.add(quizData[i][2]);   //choice1
            tmpArray.add(quizData[i][3]);   //choice2
            tmpArray.add(quizData[i][4]);   //choice3

            //add tempArray to quizArray
            quizArray.add(tmpArray);
        }

        showNextQuiz();
    }

    public void showNextQuiz() {

       //generate random number between 0 and 14 (quizArray's size - 1)
        Random random=new Random();
        int randomNum = random.nextInt(quizArray.size());

        //pick one quiz set
        ArrayList<String> quiz = quizArray.get(randomNum);

        //set question and right answer
        //Array format:{"country","right answer" , "choice1" , "choice2" , "choice3"}
        question_label.setText(quiz.get(0));    //"quiz" name of array list for random number
        right_answer=quiz.get(1);

        //remove "country" from quiz and shuffle  choice
        quiz.remove(0);
        Collections.shuffle(quiz);

        //set choice
        answer_btn1.setText(quiz.get(0));
        answer_btn2.setText(quiz.get(1));
        answer_btn3.setText(quiz.get(2));
        answer_btn4.setText(quiz.get(3));

        //remove this quiz from quizArray
        quizArray.remove(randomNum);
    }
    public void CheckAnswer(View view){

    //get push button
        Button answerBtn = (Button) findViewById(view.getId());
        String btnText =answerBtn.getText().toString();

        String alertTitle;

        if (btnText.equals(right_answer)){  //chck from array format

            //correct
            alertTitle = "CORRECT";
            rightAnswerCount++;
        }
        else {
            //wrong
            alertTitle="WRONG";
            }

            //create Dialoge
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("Answer:  "+ right_answer);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if(quizCount == QUIZ_COUNT){
                    //show Result
                    Intent intent = new Intent(getApplicationContext(),Result.class);   //score activity intent
                    intent.putExtra("RIGHT_ANSWER_COUNT",rightAnswerCount);
                    startActivity(intent);
                }
                else {
                    quizCount++;
                    showNextQuiz();
                }
            }
        });

        builder.setCancelable(false);
        builder.show();
    }
}
