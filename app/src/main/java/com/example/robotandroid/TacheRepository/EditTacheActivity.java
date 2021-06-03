package com.example.robotandroid.TacheRepository;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.robotandroid.AbstractActivity;
import com.example.robotandroid.GammeRepository.Gamme;
import com.example.robotandroid.OperationRepository.EditOperationActivity;
import com.example.robotandroid.OperationRepository.Operation;
import com.example.robotandroid.R;

public class EditTacheActivity extends AbstractActivity {
    //Affichage et edition d'une seule tache.
    private Gamme gamme;
    private Operation uneoperation;
    private Tache tache;
    private RadioButton buttonTurn;
    private RadioButton buttonWait;
    private TextView textValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_tache);

        gamme = (Gamme) getIntent().getSerializableExtra("extragamme");
        //uneoperation = (Operation) getIntent().getSerializableExtra("extraope");
        //tache = (Tache) getIntent().getSerializableExtra("extratache");
        int numOpe = getIntent().getIntExtra("numOpe",-2);
        int numTache = getIntent().getIntExtra("numTache",-2);
        uneoperation = gamme.getListeOperations().get(numOpe);
        tache = uneoperation.getListeTaches().get(numTache);

        buttonTurn = findViewById(R.id.radioButton_turn);
        buttonWait = findViewById(R.id.radioButton_wait);
        textValue = findViewById(R.id.editTextNumber_valeurTache);

        buttonTurn.setChecked(tache.typeAction.equals(Tache.TypeAction.Tourner));
        buttonWait.setChecked(tache.typeAction.equals(Tache.TypeAction.Attendre));
        textValue.setText(""+tache.valeur);
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
    }
    public void RetourMenuOpe()
    {
        Intent menuOpe = new Intent(this, EditOperationActivity.class);
        startActivity(menuOpe);
        finish();
    }

    public void ValiderEdition()
    {
        //Sauvegarde de la tache à faire
        Intent menuOpe = new Intent(this, EditOperationActivity.class);
        tache.valeur = Integer.parseInt(textValue.getText().toString());
        if(buttonTurn.isChecked()){
            tache.typeAction = Tache.TypeAction.Tourner;
        }else{
            tache.typeAction = Tache.TypeAction.Attendre;
        }
        menuOpe.putExtra("extragamme",gamme);
        menuOpe.putExtra("numOpe",getIntent().getIntExtra("numOpe",-2));
        startActivity(menuOpe);
        finish();
    }
}