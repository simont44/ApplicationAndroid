package com.example.robotandroid.TacheRepository;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.robotandroid.AbstractActivity;
import com.example.robotandroid.Controleur;
import com.example.robotandroid.GammeRepository.Gamme;
import com.example.robotandroid.OperationRepository.EditOperationActivity;
import com.example.robotandroid.OperationRepository.Operation;
import com.example.robotandroid.R;

public class EditTacheActivity extends AbstractActivity {
    //Affichage et edition d'une seule tache.
    private RadioButton buttonTurn;
    private RadioButton buttonWait;
    private Spinner dropdownMoteur;
    private TextView textValue;

    private Operation operation;
    private Tache tache;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu_tache);

        //Déclaration et instanciation des boutons, opération et tache

        //uneoperation = (Operation) getIntent().getSerializableExtra("extraope");
        //tache = (Tache) getIntent().getSerializableExtra("extratache");
        int numOpe = getIntent().getIntExtra("numOpe",-2);
        int numTache = getIntent().getIntExtra("numTache",-2);
        operation = controleur.gammeEnCreation.getListeOperations().get(numOpe);
        tache = operation.getListeTaches().get(numTache);

        buttonTurn = findViewById(R.id.radioButton_turn);
        buttonWait = findViewById(R.id.radioButton_wait);
        textValue = findViewById(R.id.editTextNumber_valeurTache);
        dropdownMoteur = findViewById(R.id.dropdownMoteur);

        buttonTurn.setChecked(tache.getTypeAction().equals(Tache.TypeAction.Tourner));
        buttonWait.setChecked(tache.getTypeAction().equals(Tache.TypeAction.Attendre));
        textValue.setText(String.valueOf(tache.getValeur()));
        ImageButton buttonRetourOpe = findViewById(R.id.imagebutton_retourOpération);
        buttonRetourOpe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetourMenuOpe();
            }
        });
        Button buttonValiderTache = findViewById(R.id.button_validerTache);
        buttonValiderTache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValiderEdition();
            }
        });

        RadioButton radioTourner = findViewById(R.id.radioButton_turn);
        radioTourner.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                findViewById(R.id.dropdownMoteur).setEnabled(true);
            }
        });

        RadioButton radioAttendre = findViewById(R.id.radioButton_wait);
        radioAttendre.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                findViewById(R.id.dropdownMoteur).setEnabled(false);
            }
        });
    }
    public void RetourMenuOpe()
    {
        Intent menuOpe = new Intent(this, EditOperationActivity.class);

        menuOpe.putExtra("numOpe", controleur.gammeEnCreation.getListeOperations().indexOf(operation));
        startActivity(menuOpe);
        finish();
    }

    //Sauvegarde de la tache
    public void ValiderEdition()
    {
        tache.setValeur(Integer.parseInt(textValue.getText().toString()));
        if(buttonTurn.isChecked()){
            tache.setTypeAction(Tache.TypeAction.Tourner);
            tache.setMoteur(dropdownMoteur.getSelectedItem().toString().charAt(0));
        }else{
            tache.setTypeAction(Tache.TypeAction.Attendre);
        }

        RetourMenuOpe();
    }

    @Override
    protected void onStop() {
        //this.ValiderEdition();
        super.onStop();
    }
}