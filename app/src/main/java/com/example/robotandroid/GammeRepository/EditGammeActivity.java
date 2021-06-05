package com.example.robotandroid.GammeRepository;

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
import com.example.robotandroid.JSONManager;
import com.example.robotandroid.ListGammeActivity;
import com.example.robotandroid.MenuDemarrage;
import com.example.robotandroid.MessageJSON;
import com.example.robotandroid.OperationRepository.EditOperationActivity;
import com.example.robotandroid.OperationRepository.Operation;
import com.example.robotandroid.OperationRepository.OperationAdapter;
import com.example.robotandroid.R;

import java.io.IOException;
import java.util.List;

public class EditGammeActivity extends AbstractActivity {

    private TextView TitreGamme;
    private TextView DescriptionGamme;
    private RecyclerView OperationRecyclerView;
    private Gamme gamme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_gamme);

        Intent itentUpdate = getIntent();
        gamme = (Gamme) itentUpdate.getSerializableExtra("extragamme");
        OperationRecyclerView = findViewById(R.id.RecyclerView_ListOpe);

        Button buttonMenu = findViewById(R.id.button_menu1);
        buttonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetourMenu();
            }
        });
        Button buttonEnd = findViewById(R.id.button_End);
        buttonEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               SauvegarderGamme();
            }
        });

        Button AjoutOPeration = findViewById(R.id.button_creategamme_ajoutoperation);
        AjoutOPeration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateOperation();
            }
        });

        TitreGamme = findViewById(R.id.editText_titregamme);
        DescriptionGamme = findViewById(R.id.muliTextView_descriptionGamme);
        this.TitreGamme.setText(gamme.id);
        this.DescriptionGamme.setText(gamme.description);
        ApplyOperationAdapter();
    }
    public void RetourMenu()
    {
        Intent menu = new Intent(this, MenuDemarrage.class);
        startActivity(menu);
        finish();
    }
    public void SauvegarderGamme()
    {
        Intent menuGamme = new Intent(getApplicationContext(), ListGammeActivity.class);

        if(gamme.listeOperations.size()==0) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(EditGammeActivity.this);
            alertDialogBuilder.setMessage("La gamme n'a pas d'opération. Vous devez en créer au moins une avant de la sauvegarder");
            alertDialogBuilder.setPositiveButton("Creer Opération", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    CreateOperation();
                }
            });
            alertDialogBuilder.setNegativeButton("Supprimer la gamme", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ListGammeActivity.ListeGamme.remove(gamme);
                    startActivity(menuGamme);
                    finish();
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }else{

            gamme.id = ((TextView) findViewById(R.id.editText_titregamme)).getText().toString();
            gamme.description = ((TextView) findViewById(R.id.muliTextView_descriptionGamme)).getText().toString();
            MessageJSON msg = new MessageJSON(MessageJSON.TypeMessage.editer, gamme);
            JSONManager.listMessage.add(msg);
            startActivity(menuGamme);
            finish();
        }
    }
    public void CreateOperation()
    {
        Operation operation = new Operation("nouveau","nouveau");
        Intent menuOpe = new Intent(this, EditOperationActivity.class);

        try{
            gamme.AjouterOperation(operation);
        }catch(Exception e) {
        }

        menuOpe.putExtra("numOpe",gamme.getListeOperations().indexOf(operation));
        menuOpe.putExtra("extragamme",gamme);
        startActivity(menuOpe);
        finish();
    }
    private void ApplyOperationAdapter(){
        //Appel à la sauvegarde des operations
        OperationAdapter adapter = new OperationAdapter(gamme);
        OperationRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        OperationRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStop() {
        //this.SauvegarderGamme();
        super.onStop();
    }
}