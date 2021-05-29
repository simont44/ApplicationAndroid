package com.example.robotandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText loginEditText;
    private EditText passwordEditText;
    private Button connexionButton;
    private Button retourButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginEditText=(EditText) findViewById(R.id.connexion_login_input);
        passwordEditText=(EditText) findViewById(R.id.connexion_password_input);
        connexionButton=(Button) findViewById(R.id.connexion_submit_btn);
        retourButton=(Button) findViewById(R.id.connexion_retour_btn);
        connexionButton.setEnabled(false);

        loginEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        connexionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        retourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenListeAppareilWifi();
            }
        });

    }
    public void OpenListeAppareilWifi(){
        Intent listeAppareilWifi = new Intent(this, com.example.robotandroid.listeAppareilWifi.class);
        startActivity(listeAppareilWifi);
    }
}