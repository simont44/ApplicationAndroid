package com.example.robotandroid.OperationRepository;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.robotandroid.AbstractActivity;
import com.example.robotandroid.GammeRepository.EditGammeActivity;
import com.example.robotandroid.GammeRepository.Gamme;
import com.example.robotandroid.MenuDemarrage;
import com.example.robotandroid.ListGammeActivity;
import com.example.robotandroid.TacheRepository.EditTacheActivity;
import com.example.robotandroid.MessageJSON;
import com.example.robotandroid.R;
import com.example.robotandroid.TacheRepository.Tache;
import com.example.robotandroid.TacheRepository.TacheAdapter;

import java.util.List;

public class EditOperationActivity extends AbstractActivity {

    private TextView TitreOperation;
    private TextView DescriptionOperation;
    private RecyclerView tacheRecyclerView;
    private Gamme gamme;
    private Operation uneoperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_operation);
        tacheRecyclerView = findViewById(R.id.recyclerView_listetâche);
        gamme = (Gamme) getIntent().getSerializableExtra("extragamme");
        int numOpe = getIntent().getIntExtra("numOpe",-2);
        uneoperation = gamme.getListeOperations().get(numOpe);

        ImageButton buttonMenu = findViewById(R.id.imageButton_menu);
        buttonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetourMenu();
            }
        });
        ImageButton buttonRetourGamme = findViewById(R.id.imageButton_retourGamme);
        buttonRetourGamme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoToMenuGamme();
            }
        });
        Button buttonCreateTache = findViewById(R.id.button_createTache);
        buttonCreateTache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoToMenuTache();
            }
        });
        Button buttonValider = findViewById(R.id.button_valider);
        buttonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SauvegarderOperation();
            }
        });
        TitreOperation = findViewById(R.id.editText_Titreoperation);
        DescriptionOperation = findViewById(R.id.editText_descriptionOperation);
        this.TitreOperation.setText(uneoperation.titre);
        this.DescriptionOperation.setText(uneoperation.description);
        Log.e("nbTaches",""+uneoperation.ListeTaches.size());
        ApplyTacheAdapter();
    }

    private void ApplyTacheAdapter() {
        TacheAdapter adapter = new TacheAdapter(gamme, uneoperation);
        tacheRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        tacheRecyclerView.setAdapter(adapter);
    }
    public void SauvegarderOperation(){
        Intent menuOpe = new Intent(this, EditGammeActivity.class);
        uneoperation.titre = ((TextView) findViewById(R.id.editText_Titreoperation)).getText().toString();
        uneoperation.description = ((TextView) findViewById(R.id.editText_descriptionOperation)).getText().toString();
        menuOpe.putExtra("extragamme",gamme);
        startActivity(menuOpe);
        finish();
    }

    public void RetourMenu()
    {
        Intent menu = new Intent(this, MenuDemarrage.class);
        startActivity(menu);
        finish();
    }
    public void GoToMenuTache()
    {
        Tache tache = new Tache(Tache.TypeAction.Attendre, 0);
        uneoperation.AjouterTache(tache);
        Intent menutache = new Intent(this, EditTacheActivity.class);
        uneoperation.titre = ((TextView) findViewById(R.id.editText_Titreoperation)).getText().toString();
        uneoperation.description = ((TextView) findViewById(R.id.editText_descriptionOperation)).getText().toString();
        menutache.putExtra("extragamme",gamme);
        menutache.putExtra("numOpe",gamme.getListeOperations().indexOf(uneoperation));
        menutache.putExtra("numTache",uneoperation.ListeTaches.indexOf(tache));
        startActivity(menutache);
        finish();
    }
    public void GoToMenuGamme(){

        Intent menuGamme = new Intent(this, ListGammeActivity.class);
        startActivity(menuGamme);
        finish();
    }
}