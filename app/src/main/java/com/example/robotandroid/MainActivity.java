package com.example.robotandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText login;
    private EditText password;
    private Button connexion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=(EditText) findViewById(R.id.connexion_login_input);
        password=(EditText) findViewById(R.id.connexion_password_input);
        connexion=(Button) findViewById(R.id.connexion_submit_btn);


    }
}