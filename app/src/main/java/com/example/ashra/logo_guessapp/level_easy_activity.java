package com.example.ashra.logo_guessapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ashra.logo_guessapp.model.Choice;
import com.example.ashra.logo_guessapp.model.Question;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class level_easy_activity extends AppCompatActivity {

    private Button answer_btn1;
    private Button answer_btn2;
    private Button answer_btn3;
    private Button answer_btn4;

    private String right_answer;
    private int rightAnswerCount=0;
    private int quizCount =1;
    private FirebaseDatabase database;

    static final private  int QUIZ_COUNT = 5;

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

    ArrayList<Question>questions = new ArrayList<>();

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
        database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("questions");

        //findviewbt id doing here
        answer_btn1=(Button)findViewById(R.id.answer_btn1);
        answer_btn2=(Button)findViewById(R.id.answer_btn2);
        answer_btn3=(Button)findViewById(R.id.answer_btn3);
        answer_btn4=(Button)findViewById(R.id.answer_btn4);


        //create quizArray from quizData
//        for(int i = 0 ; i<quizData.length ; i++){
//
//            //prepare array
//            ArrayList<String> tmpArray = new ArrayList<>();
//            tmpArray.add(quizData[i][0]);  //country
//            tmpArray.add(quizData[i][1]);   //cright answer
//            tmpArray.add(quizData[i][2]);   //choice1
//            tmpArray.add(quizData[i][3]);   //choice2
//            tmpArray.add(quizData[i][4]);   //choice3
//
//            //add tempArray to quizArray
//            quizArray.add(tmpArray);
//        }


        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://game-d94b2.firebaseio.com/questions.json";


//       Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
//                        mTextView.setText("Response is: "+ response.substring(0,500));
                        JSONObject jsonResponse = null;
                        JSONObject typeResponse = null;
                        JSONObject questionResponse = null;
                        JSONObject choicesResponse = null;
                        try {
                            jsonResponse = new JSONObject(response);
                            String type = jsonResponse.getString("easy"); // {easy:}
                            typeResponse = new JSONObject(type);
                            String question = typeResponse.getString("q1"); //{q1:}
                            questionResponse = new JSONObject(question);
                            String rightAnswer = questionResponse.getString("right answer");
                            String image = questionResponse.getString("image");
//                          Toast.makeText(getApplicationContext(), image, Toast.LENGTH_LONG).show();
                            JSONArray choices = questionResponse.getJSONArray("choices");
                            Question q1 = new Question(image, type, rightAnswer, choices.getString(1), choices.getString(2), choices.getString(3), choices.getString(4));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                mTextView.setText("That didn't work!");
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);

//        showNextQuiz();
    }

//    public void showNextQuiz() {
//
//       //generate random number between 0 and 14 (quizArray's size - 1)
//        Random random=new Random();
//        int randomNum = random.nextInt(quizArray.size());
//
//        //pick one quiz set
//        ArrayList<String> quiz = quizArray.get(randomNum);
//
//        //set question and right answer
//        //Array format:{"country","right answer" , "choice1" , "choice2" , "choice3"}
//        question_label.setText(quiz.get(0));    //"quiz" name of array list for random number
//        right_answer=quiz.get(1);
//
//        //remove "country" from quiz and shuffle  choice
//        quiz.remove(0);
//        Collections.shuffle(quiz);
//
//        //set choice
//        answer_btn1.setText(quiz.get(0));
//        answer_btn2.setText(quiz.get(1));
//        answer_btn3.setText(quiz.get(2));
//        answer_btn4.setText(quiz.get(3));
//
//        //remove this quiz from quizArray
//        quizArray.remove(randomNum);
//    }
//    public void CheckAnswer(View view){
//
//    //get push button
//        Button answerBtn = (Button) findViewById(view.getId());
//        String btnText =answerBtn.getText().toString();
//
//        String alertTitle;
//
//        if (btnText.equals(right_answer)){  //chck from array format
//
//            //correct
//            alertTitle = "CORRECT";
//            rightAnswerCount++;
//        }
//        else {
//            //wrong
//            alertTitle="WRONG";
//            }
//
//            //create Dialoge
//        AlertDialog.Builder builder= new AlertDialog.Builder(this);
//        builder.setTitle(alertTitle);
//        builder.setMessage("Answer:  "+ right_answer);
//        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//
//                if(quizCount == QUIZ_COUNT){
//                    //show Result
//                    Intent intent = new Intent(getApplicationContext(),Result.class);   //score activity intent
//                    intent.putExtra("RIGHT_ANSWER_COUNT",rightAnswerCount);
//                    startActivity(intent);
//                    finish();
//                }
//                else {
//                    quizCount++;
//                    showNextQuiz();
//                }
//            }
//        });
//
//        builder.setCancelable(false);
//        builder.show();
//    }
}
