package com.example.robotandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class connexionActivity extends AppCompatActivity {

    private EditText loginEditText;
    private EditText passwordEditText;
    private Button connexionButton;
    private Button retourButton;
    private String ipRobot;
    private String port;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
        loginEditText=(EditText) findViewById(R.id.connexionLoginInput);
        passwordEditText=(EditText) findViewById(R.id.connexionPasswordInput);
        connexionButton=(Button) findViewById(R.id.connexionSubmitBtn);
        retourButton=(Button) findViewById(R.id.connexionRetourBtn);
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
                Socket socket = null;
                try {
                    socket = new Socket(ipRobot, Integer.parseInt(port));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    OutputStream out = socket.getOutputStream();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                InputStream in = null;
                try {
                    in = socket.getInputStream();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //char[] message = new char[512];
                //int read = in.read(message);

                //   FaireUntrucAvecLeMessage(new String(message));

             //   out.write("Une réponse au message reçu");
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