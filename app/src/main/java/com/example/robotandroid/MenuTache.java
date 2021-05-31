package com.example.robotandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.robotandroid.OperationRepository.EditOperation;

public class MenuTache extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_tache);

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
                ValiderTache();
            }
        });
    }
    public void RetourMenuOpe()
    {
        Intent menuOpe = new Intent(this, EditOperation.class);
        startActivity(menuOpe);
        finish();
    }

    public void ValiderTache()
    {
        //Sauvegarde de la tache à faire
        Intent menuOpe = new Intent(this, EditOperation.class);
        startActivity(menuOpe);
        finish();
    }
}