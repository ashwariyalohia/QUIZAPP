package com.example.ashra.logo_guessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ashra.logo_guessapp.model.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class entry extends AppCompatActivity {

    EditText enter_name;
    Button start_btn;
    DatabaseReference databaseUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);
        databaseUsers = FirebaseDatabase.getInstance().getReference("users");

        enter_name=(EditText)findViewById(R.id.name_enter);
        start_btn=(Button)findViewById(R.id.start_btn);

        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!enter_name.getText().toString().isEmpty())
                {

                    String id = databaseUsers.push().getKey();
                        Toast.makeText(getApplicationContext(), id, Toast.LENGTH_LONG).show();
                    User user = new User(id, enter_name.getText().toString(), 0);
                    databaseUsers.child(id).setValue(user);
                    Intent startintent = new Intent(entry.this,levels_activity.class);//use intent to switch a page using class page name

                    startintent.putExtra("name", enter_name.getText().toString()); //to show a data on other page
                    startActivity(startintent);
                }else{
                    Toast.makeText(getApplicationContext(), "name cannot be blank", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
