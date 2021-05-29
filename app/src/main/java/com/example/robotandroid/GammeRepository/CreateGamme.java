package com.example.robotandroid.GammeRepository;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.robotandroid.MenuDemarrage;
import com.example.robotandroid.MenuOperation;
import com.example.robotandroid.R;

public class CreateGamme extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_gamme);

        Button buttonMenu = findViewById(R.id.button_menu1);
        buttonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetourMenu();
            }
        });
        Button buttonSuivant = findViewById(R.id.button_suivant);
        buttonSuivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateOperation();
            }
        });

    }
    public void RetourMenu()
    {
        Intent menu = new Intent(this, MenuDemarrage.class);
        startActivity(menu);
    }
    public void CreateOperation()
    {
        Intent menuOpe = new Intent(this, MenuOperation.class);
        startActivity(menuOpe);
    }
}