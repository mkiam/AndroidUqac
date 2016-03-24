package com.example.user.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class Compte extends Activity {
    String EXTRA_NAME = "user_name";
    String EXTRA_PASSWORD = "user_password";
    String EXTRA_PSEUDO = "user_pseudo";
    String EXTRA_EMAIL= "user_email";




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        Intent intent = getIntent();
        TextView nameDisplay = (TextView) findViewById(R.id.name_display);
        TextView passwordDisplay = (TextView) findViewById(R.id.password_display);
        TextView emailDisplay = (TextView) findViewById(R.id.email_display);
        TextView nicknameDisplay = (TextView) findViewById(R.id.nickname_display);
        if (intent != null) {
            nameDisplay.setText(intent.getStringExtra(EXTRA_NAME));
            passwordDisplay.setText(intent.getStringExtra(EXTRA_PASSWORD));
            emailDisplay.setText(intent.getStringExtra(EXTRA_EMAIL));
            nicknameDisplay.setText(intent.getStringExtra(EXTRA_PSEUDO));
        }
    }

    //creation compte
    public void creationCompte(View view){

        TextView nameDisplay = (TextView) findViewById(R.id.name_display);
        TextView passwordDisplay = (TextView) findViewById(R.id.password_display);
        TextView emailDisplay = (TextView) findViewById(R.id.email_display);
        TextView nicknameDisplay = (TextView) findViewById(R.id.nickname_display);
        EXTRA_NAME =nameDisplay.getText().toString();
        EXTRA_EMAIL =  emailDisplay.getText().toString();
        EXTRA_PSEUDO = nicknameDisplay.getText().toString();
        EXTRA_PASSWORD = passwordDisplay.getText().toString();

        if(EXTRA_PASSWORD.isEmpty()||EXTRA_PSEUDO.isEmpty()||EXTRA_EMAIL.isEmpty()||EXTRA_NAME.isEmpty()) {
            Toast.makeText(this, "Veuiller Remplir tous les Champs",
                    Toast.LENGTH_LONG).show();
        }else {

            User u  = new User(EXTRA_NAME,EXTRA_PSEUDO,EXTRA_EMAIL,EXTRA_PASSWORD);
            UserDAO us = new UserDAO();
            us.add(u);


        }

    }
}


