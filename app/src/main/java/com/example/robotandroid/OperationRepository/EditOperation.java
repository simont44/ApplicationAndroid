package com.example.robotandroid.OperationRepository;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.robotandroid.MenuDemarrage;
import com.example.robotandroid.MenuGamme;
import com.example.robotandroid.MenuTache;
import com.example.robotandroid.R;
import com.example.robotandroid.TacheRepository.Tache;
import com.example.robotandroid.TacheRepository.TacheAdapter;

import java.util.ArrayList;
import java.util.List;

public class EditOperation extends AppCompatActivity {

    private TextView TitreOperation;
    private TextView DescriptionOperation;
    private RecyclerView tacheRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_operation);
        tacheRecyclerView = findViewById(R.id.recyclerView_listetâche);
        Operation uneoperation = (Operation) getIntent().getSerializableExtra("extraope");

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
        this.TitreOperation.setText(uneoperation.titre);
        this.DescriptionOperation.setText(uneoperation.description);
        Log.e("blublu",""+uneoperation.ListeTaches.size());
        ApplyTacheAdapter(uneoperation.ListeTaches);
    }

    private void ApplyTacheAdapter(List<Tache> listeTaches) {
        TacheAdapter adapter = new TacheAdapter(listeTaches);
        tacheRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        tacheRecyclerView.setAdapter(adapter);
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