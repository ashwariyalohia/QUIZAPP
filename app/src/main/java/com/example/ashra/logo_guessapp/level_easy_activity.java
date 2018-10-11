package com.example.ashra.logo_guessapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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
import com.squareup.picasso.Picasso;

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
    private ImageView easyImage;

    private String right_answer;
    private int rightAnswerCount=0;
    private int quizCount = 0;
    private FirebaseDatabase database;

    static final private int QUIZ_COUNT = 9;

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

    ArrayList<Question>questions = new ArrayList<>();


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

        easyImage = findViewById(R.id.easyImage);


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
                        JSONArray choices;
                        String question;
                        String rightAnswer;
                        String image;
                        try {
                            jsonResponse = new JSONObject(response);
                            String type = jsonResponse.getString("easy"); // {easy:}
                            typeResponse = new JSONObject(type);

                            question = typeResponse.getString("q1"); //{q1:}
                            questionResponse = new JSONObject(question);
                            rightAnswer = questionResponse.getString("right answer");
                            image = questionResponse.getString("image");
//                          Toast.makeText(getApplicationContext(), image, Toast.LENGTH_LONG).show();
                            choices = questionResponse.getJSONArray("choices");
                            Question q1 = new Question(image, type, rightAnswer, choices.getString(1), choices.getString(2), choices.getString(3), choices.getString(4));
                            questions.add(q1);
//                            Toast.makeText(getApplicationContext(),questions.get(0).getImgUrl().toString(), Toast.LENGTH_LONG).show();

                            question = typeResponse.getString("q2"); //{q1:}
                            questionResponse = new JSONObject(question);
                            rightAnswer = questionResponse.getString("right answer");
                            image = questionResponse.getString("image");
//                          Toast.makeText(getApplicationContext(), image, Toast.LENGTH_LONG).show();
                            choices = questionResponse.getJSONArray("choices");
                            Question q2 = new Question(image, type, rightAnswer, choices.getString(1), choices.getString(2), choices.getString(3), choices.getString(4));
                            questions.add(q2);
//                            Toast.makeText(getApplicationContext(),questions.get(1).getImgUrl().toString(), Toast.LENGTH_LONG).show();

                            question = typeResponse.getString("q3"); //{q1:}
                            questionResponse = new JSONObject(question);
                            rightAnswer = questionResponse.getString("right answer");
                            image = questionResponse.getString("image");
//                          Toast.makeText(getApplicationContext(), image, Toast.LENGTH_LONG).show();
                            choices = questionResponse.getJSONArray("choices");
                            Question q3 = new Question(image, type, rightAnswer, choices.getString(1), choices.getString(2), choices.getString(3), choices.getString(4));
                            questions.add(q3);
//                            Toast.makeText(getApplicationContext(),questions.size(), Toast.LENGTH_LONG).show();

                            question = typeResponse.getString("q4"); //{q1:}
                            questionResponse = new JSONObject(question);
                            rightAnswer = questionResponse.getString("right answer");
                            image = questionResponse.getString("image");
//                          Toast.makeText(getApplicationContext(), image, Toast.LENGTH_LONG).show();
                            choices = questionResponse.getJSONArray("choices");
                            Question q4 = new Question(image, type, rightAnswer, choices.getString(1), choices.getString(2), choices.getString(3), choices.getString(4));
                            questions.add(q4);
//                            Toast.makeText(getApplicationContext(),questions.size(), Toast.LENGTH_LONG).show();

                            question = typeResponse.getString("q5"); //{q1:}
                            questionResponse = new JSONObject(question);
                            rightAnswer = questionResponse.getString("right answer");
                            image = questionResponse.getString("image");
//                          Toast.makeText(getApplicationContext(), image, Toast.LENGTH_LONG).show();
                            choices = questionResponse.getJSONArray("choices");
                            Question q5 = new Question(image, type, rightAnswer, choices.getString(1), choices.getString(2), choices.getString(3), choices.getString(4));
                            questions.add(q5);
//                            Toast.makeText(getApplicationContext(),questions.size(), Toast.LENGTH_LONG).show();

                            question = typeResponse.getString("q6"); //{q1:}
                            questionResponse = new JSONObject(question);
                            rightAnswer = questionResponse.getString("right answer");
                            image = questionResponse.getString("image");
//                          Toast.makeText(getApplicationContext(), image, Toast.LENGTH_LONG).show();
                            choices = questionResponse.getJSONArray("choices");
                            Question q6 = new Question(image, type, rightAnswer, choices.getString(1), choices.getString(2), choices.getString(3), choices.getString(4));
                            questions.add(q6);
//                            Toast.makeText(getApplicationContext(),questions.size(), Toast.LENGTH_LONG).show();

                            question = typeResponse.getString("q7"); //{q1:}
                            questionResponse = new JSONObject(question);
                            rightAnswer = questionResponse.getString("right answer");
                            image = questionResponse.getString("image");
//                          Toast.makeText(getApplicationContext(), image, Toast.LENGTH_LONG).show();
                            choices = questionResponse.getJSONArray("choices");
                            Question q7 = new Question(image, type, rightAnswer, choices.getString(1), choices.getString(2), choices.getString(3), choices.getString(4));
                            questions.add(q7);
//                            Toast.makeText(getApplicationContext(),questions.size(), Toast.LENGTH_LONG).show();

                            question = typeResponse.getString("q8"); //{q1:}
                            questionResponse = new JSONObject(question);
                            rightAnswer = questionResponse.getString("right answer");
                            image = questionResponse.getString("image");
//                          Toast.makeText(getApplicationContext(), image, Toast.LENGTH_LONG).show();
                            choices = questionResponse.getJSONArray("choices");
                            Question q8 = new Question(image, type, rightAnswer, choices.getString(1), choices.getString(2), choices.getString(3), choices.getString(4));
                            questions.add(q8);
//                            Toast.makeText(getApplicationContext(),questions.size(), Toast.LENGTH_LONG).show();

                            question = typeResponse.getString("q9"); //{q1:}
                            questionResponse = new JSONObject(question);
                            rightAnswer = questionResponse.getString("right answer");
                            image = questionResponse.getString("image");
//                          Toast.makeText(getApplicationContext(), image, Toast.LENGTH_LONG).show();
                            choices = questionResponse.getJSONArray("choices");
                            Question q9 = new Question(image, type, rightAnswer, choices.getString(1), choices.getString(2), choices.getString(3), choices.getString(4));
                            questions.add(q9);
//                            Toast.makeText(getApplicationContext(),questions.size(), Toast.LENGTH_LONG).show();

                            question = typeResponse.getString("q10"); //{q1:}
                            questionResponse = new JSONObject(question);
                            rightAnswer = questionResponse.getString("right answer");
                            image = questionResponse.getString("image");
//                          Toast.makeText(getApplicationContext(), image, Toast.LENGTH_LONG).show();
                            choices = questionResponse.getJSONArray("choices");
                            Question q10 = new Question(image, type, rightAnswer, choices.getString(1), choices.getString(2), choices.getString(3), choices.getString(4));
                            questions.add(q10);
//                            Toast.makeText(getApplicationContext(),questions.size(), Toast.LENGTH_LONG).show();

                            Collections.shuffle(questions);
                            showNextQuiz();

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

    }

    public void showNextQuiz() {
//        Toast.makeText(this,questions.get(0).getImgUrl().toString(), Toast.LENGTH_LONG).show();
//        Toast.makeText(this,questions.get(quizCount).getImgUrl(), Toast.LENGTH_LONG).show();

        Picasso.with(getApplicationContext()).load(questions.get(quizCount).getImgUrl().toString()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(easyImage);
        //set question and right answer

        right_answer=questions.get(quizCount).getRightAnswer();

        //remove "country" from quiz and shuffle  choice


        //set choice
        answer_btn1.setText(questions.get(quizCount).getChoice1().toString());
        answer_btn2.setText(questions.get(quizCount).getChoice2().toString());
        answer_btn3.setText(questions.get(quizCount).getChoice3().toString());
        answer_btn4.setText(questions.get(quizCount).getChoice4().toString());

        //remove this quiz from quizArray
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
                    finish();
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
