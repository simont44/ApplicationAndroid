package com.example.robotandroid.OperationRepository;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.robotandroid.MenuDemarrage;
import com.example.robotandroid.MenuGamme;
import com.example.robotandroid.MenuTache;
import com.example.robotandroid.R;

public class CreateOperation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_operation);

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
    }
    public void RetourMenu()
    {
        Intent menu = new Intent(this, MenuDemarrage.class);
        startActivity(menu);
        finish();
    }
    public void GoToMenuTache()
    {
        Intent menutache = new Intent(this, MenuTache.class);
        startActivity(menutache);
        finish();
    }
    public void GoToMenuGamme(){
        Intent menuGamme = new Intent(this, MenuGamme.class);
        startActivity(menuGamme);
        finish();
    }
}