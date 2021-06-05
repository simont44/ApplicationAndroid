package com.example.robotandroid.OperationRepository;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import com.example.robotandroid.R;
import com.example.robotandroid.TacheRepository.Tache;
import com.example.robotandroid.TacheRepository.TacheAdapter;

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

        Button buttonCreateTache = findViewById(R.id.button_createTache);
        buttonCreateTache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateTache();
            }
        });
        Button buttonValider = findViewById(R.id.button_valider);
        buttonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuGamme = new Intent(getApplicationContext(), EditGammeActivity.class);

                if(uneoperation.ListeTaches.size()==0) {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(EditOperationActivity.this);
                    alertDialogBuilder.setMessage("L'Opération n'a pas de tâche. Vous devez en créer au moins une avant de la sauvegarder");
                    alertDialogBuilder.setPositiveButton("Créer Tâche", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            CreateTache();
                        }
                    });
                    alertDialogBuilder.setNegativeButton("Supprimer l'opération", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            gamme.getListeOperations().remove(uneoperation);
                            menuGamme.putExtra("extragamme",gamme);
                            startActivity(menuGamme);
                            finish();
                        }
                    });
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }else {


                    SauvegarderOperation();
                }
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

    public void CreateTache()
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

    @Override
    protected void onStop() {
        //this.SauvegarderOperation();
        super.onStop();
    }
}