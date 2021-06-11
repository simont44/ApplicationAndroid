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

//Activity par défaut implémentant l'ensemble des premieres actions : Mode manuel, Mode Panne, Mode Automatique, Connexion et Liste Gamme
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
    //On génère la liste par défaut du programme, il reste à prendre en charge le chargement d'une liste de gamme sauvegardée.
    public void OpenMenuGamme()
    {
        //TODO : ListeGammeActivity.listeGammes = controleur.recupererGammes();
       Intent menu = new Intent(this, ListGammeActivity.class);
       startActivity(menu);
    }
// On renvoie vers la liste des appareils Wifi .
    public void OpenListeAppareilWifi(){
        Intent listeAppareilWifi = new Intent(this, listeAppareilWifi.class);
        startActivity(listeAppareilWifi);
    }
}