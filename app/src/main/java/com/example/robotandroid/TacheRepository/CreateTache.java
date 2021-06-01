package com.example.robotandroid.TacheRepository;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.robotandroid.AbstractActivity;
import com.example.robotandroid.GammeRepository.Gamme;
import com.example.robotandroid.MenuDemarrage;
import com.example.robotandroid.MenuGamme;
import com.example.robotandroid.MenuTache;
import com.example.robotandroid.MessageJSON;
import com.example.robotandroid.R;

import java.util.ArrayList;

public class CreateTache extends AbstractActivity {

    private TextView TitreOperation;
    private TextView DescriptionOperation;
    private RecyclerView TacheRecyclerView;
    private Gamme gamme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_operation);
        Tache tache = (Tache) getIntent().getSerializableExtra("extraope");

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
        TitreOperation = findViewById(R.id.editText_Titreoperation);
        DescriptionOperation = findViewById(R.id.editText_descriptionOperation);
        this.TitreOperation.setText(tache.typeAction.toString());
        this.DescriptionOperation.setText(tache.valeur);
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
        menutache.putExtra("extragamme",gamme);
        MessageJSON msg = new MessageJSON(MessageJSON.TypeMessage.editer,gamme);
        startActivity(menutache);
        finish();
    }
    public void GoToMenuGamme(){
        Intent menuGamme = new Intent(this, MenuGamme.class);
        menuGamme.putExtra("extragamme",gamme);
        MessageJSON msg = new MessageJSON(MessageJSON.TypeMessage.editer,gamme);
        startActivity(menuGamme);
        finish();
    }
}