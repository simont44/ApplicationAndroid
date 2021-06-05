package com.example.robotandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.robotandroid.GammeRepository.Gamme;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MenuDemarrage extends AbstractActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        IRobot robot = new RobotConnexion();
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
    }
    public void OpenMenuGamme()
    {
        try {
          ListGammeActivity.ListeGamme = JSONManager.GetDataFromBDD();

        } catch (IOException e) {
            e.printStackTrace();
        }
       Intent menu = new Intent(this, ListGammeActivity.class);
       startActivity(menu);
    }
}