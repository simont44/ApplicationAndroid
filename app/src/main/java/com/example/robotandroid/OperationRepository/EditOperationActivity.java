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
import android.widget.TextView;

import com.example.robotandroid.AbstractActivity;
import com.example.robotandroid.GammeRepository.EditGammeActivity;
import com.example.robotandroid.ListGammeActivity;
import com.example.robotandroid.TacheRepository.EditTacheActivity;
import com.example.robotandroid.R;
import com.example.robotandroid.TacheRepository.Tache;
import com.example.robotandroid.TacheRepository.TacheAdapter;

public class EditOperationActivity extends AbstractActivity {
//Activity permettant au meme titre que EditGammeActivity d'éditer une opération.
    private TextView TitreOperation;
    private TextView DescriptionOperation;
    private RecyclerView tacheRecyclerView;
    private Operation operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //On affiche la vue permettant la création d'opération
        setContentView(R.layout.activity_create_operation);
        tacheRecyclerView = findViewById(R.id.recyclerView_listetâche);

        int numOpe = getIntent().getIntExtra("numOpe",-2);
        System.out.println(numOpe);
        //on récupère l'opération envoyé par la fonction CreateOperation() dans EditGammeActivity
        operation = controleur.gammeEnCreation.getListeOperations().get(numOpe);

        //Declaration des boutons avec actions associées
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

                //Comme pour la sauvegarde des gammes, on applique la contrainte, chaque opération doit avoir une tâche
                //On génère un pop up permettant la création de la tâche ou la suppression de l'opération.
                if(operation.listeTaches.size()==0) {
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
                            controleur.gammeEnCreation.getListeOperations().remove(operation);
                            menuGamme.putExtra("extragamme",controleur.gammeEnCreation);
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

        //On récupère les informations enregistrées.
        TitreOperation = findViewById(R.id.editText_Titreoperation);
        DescriptionOperation = findViewById(R.id.editText_descriptionOperation);
        this.TitreOperation.setText(operation.id);
        this.DescriptionOperation.setText(operation.description);
        Log.e("nbTaches",""+operation.listeTaches.size());
        ApplyTacheAdapter();
    }

    private void ApplyTacheAdapter() {
        TacheAdapter adapter = new TacheAdapter(controleur.gammeEnCreation, operation);
        tacheRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        tacheRecyclerView.setAdapter(adapter);
    }
    public void SauvegarderOperation(){
        Intent menuOpe = new Intent(this, EditGammeActivity.class);
        operation.id = ((TextView) findViewById(R.id.editText_Titreoperation)).getText().toString();
        operation.description = ((TextView) findViewById(R.id.editText_descriptionOperation)).getText().toString();

        startActivity(menuOpe);
        finish();
    }

    public void CreateTache()
    {
        Tache tache = new Tache("id", "description", 0, 'A');

        operation.AjouterTache(tache);

        Intent menutache = new Intent(this, EditTacheActivity.class);
        operation.id = ((TextView) findViewById(R.id.editText_Titreoperation)).getText().toString();
        operation.description = ((TextView) findViewById(R.id.editText_descriptionOperation)).getText().toString();

        //on transmet les informations de l'opération et la tâches créée à l'écran EditTacheActivity
        menutache.putExtra("numOpe", controleur.gammeEnCreation.getListeOperations().indexOf(operation));
        menutache.putExtra("numTache",operation.getListeTaches().indexOf(tache));

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
        super.onStop();
    }
}