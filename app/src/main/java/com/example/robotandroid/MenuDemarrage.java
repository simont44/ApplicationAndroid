package com.example.robotandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.StringRes;

import com.example.robotandroid.GammeRepository.Gamme;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MenuDemarrage extends AbstractActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        IRobot robot = new WifiListener();
        Controleur.initControleur(robot);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu_demarrage);
        Button buttonGamme = findViewById(R.id.buttonGamme);
        buttonGamme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenMenuGamme();
            }
        });
        Button buttonConnexion = findViewById(R.id.buttonConnect);
        if(controleur.utilisateurConnecté == null)
        {
            buttonConnexion.setText("Connecter");
            buttonConnexion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OpenListeAppareilWifi();
                }
            });
        }
        else
        {
            buttonConnexion.setText("Déconnecter");
            buttonConnexion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    controleur.deconnecter();
                    buttonConnexion.setText("Connecter");
                }
            });
        }


        Button buttonAuto = findViewById(R.id.buttonAuto);
        buttonAuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controleur.mode("auto");
            }
        });

        Button buttonManu = findViewById(R.id.buttonManuel);
        buttonManu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controleur.mode("manu");
            }
        });

        Button buttonPanne = findViewById(R.id.buttonPanne);
        buttonPanne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controleur.mode("panne");
            }
        });
    }
    public void OpenMenuGamme()
    {
        //TODO : ListeGammeActivity.listeGammes = controleur.recupererGammes();
       Intent menu = new Intent(this, ListGammeActivity.class);
       startActivity(menu);
    }

    public void OpenListeAppareilWifi(){
        Intent listeAppareilWifi = new Intent(this, listeAppareilWifi.class);
        startActivity(listeAppareilWifi);
    }
}