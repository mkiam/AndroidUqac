package com.example.user.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void save(View view){
        Intent intent = new Intent(MainActivity.this, Compte.class);
        startActivity(intent);
    }
    public void connect(View view){
        TextView nameDisplay = (TextView) findViewById(R.id.pseudo);
        TextView passwordDisplay = (TextView) findViewById(R.id.pwd);

       String EXTRA_NAME =nameDisplay.getText().toString();
       String EXTRA_PASSWORD = passwordDisplay.getText().toString();

        if(EXTRA_PASSWORD.isEmpty()||EXTRA_NAME.isEmpty()) {
            Toast.makeText(this, "Veuiller Remplir tous les Champs",
                    Toast.LENGTH_LONG).show();
        }else {

            UserDAO us = new UserDAO();
            if(!us.getUser(EXTRA_NAME, EXTRA_PASSWORD)){
                Toast.makeText(this, "La connexion a echoue",
                        Toast.LENGTH_LONG).show();
            }else{

            }



        }

    }
}
