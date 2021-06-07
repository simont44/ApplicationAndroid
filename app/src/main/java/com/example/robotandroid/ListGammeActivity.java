package com.example.robotandroid;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.robotandroid.GammeRepository.EditGammeActivity;
import com.example.robotandroid.GammeRepository.Gamme;
import com.example.robotandroid.GammeRepository.GammeAdapter;
import com.example.robotandroid.OperationRepository.Operation;
import com.example.robotandroid.TacheRepository.Tache;

import java.util.ArrayList;
import java.util.List;

public class ListGammeActivity extends AbstractActivity {

    public static ArrayList<Gamme> ListeGamme = new ArrayList<Gamme>();

    private RecyclerView GammeRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu_gamme);

        Button buttonMenu = findViewById(R.id.buttonMenu);
        buttonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetourMenu();
            }
        });

        Button buttonAjouterGamme = findViewById(R.id.buttonAdd);
        buttonAjouterGamme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateGamme();
            }
        });

//Ne fonctionne pas et fait planter l'appli après clique sur Gamme
/*
        Button buttonExecuterGamme = findViewById(R.id.buttonExec);
        buttonExecuterGamme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controleur.executerGamme(v.getId());
            }
        });
*/

        GammeRecyclerView = findViewById(R.id.ViewListGamme);
        ApplyGammeAdapter();
        AfficherSauvegarde(findViewById(R.id.root_menugamme));
    }
    public void RetourMenu()
    {
        Intent menu = new Intent(this, MenuDemarrage.class);
        AfficherMessagePop();
        startActivity(menu);
        finish();
    }
    //a copier pour les taches
    public void CreateGamme()
    {
        controleur.gammeEnCreation = new Gamme("nouveau","nouveau");
        this.ListeGamme.add(controleur.gammeEnCreation);

        Intent menuCreate = new Intent(this, EditGammeActivity.class);
        startActivity(menuCreate);
        finish();

    }


    private void ApplyGammeAdapter(){
        //Appel à la sauvegarde des gammes
        GammeAdapter adapter = new GammeAdapter();
        GammeRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        GammeRecyclerView.setAdapter(adapter);
    }

}

