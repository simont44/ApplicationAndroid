package com.example.robotandroid.GammeRepository;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.robotandroid.MenuDemarrage;
import com.example.robotandroid.OperationRepository.EditOperation;
import com.example.robotandroid.OperationRepository.Operation;
import com.example.robotandroid.OperationRepository.OperationAdapter;
import com.example.robotandroid.R;

import java.util.List;

public class CreateGamme extends AppCompatActivity {

    private TextView TitreGamme;
    private TextView DescriptionGamme;
    private RecyclerView OperationRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_gamme);

        Intent itentUpdate = getIntent();
        Gamme gamme = (Gamme) itentUpdate.getSerializableExtra("extragamme");
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
                CreateOperation();
            }
        });

        TitreGamme = findViewById(R.id.editText_titregamme);
        DescriptionGamme = findViewById(R.id.muliTextView_descriptionGamme);
        this.TitreGamme.setText(gamme.id);
        this.DescriptionGamme.setText(gamme.description);
        Log.e("blublu",""+gamme.listeOperations.size());
        ApplyOperationAdapter(gamme.listeOperations);
    }
    public void RetourMenu()
    {
        Intent menu = new Intent(this, MenuDemarrage.class);
        startActivity(menu);
    }
    public void CreateOperation()
    {
        Intent menuOpe = new Intent(this, EditOperation.class);
        startActivity(menuOpe);
    }
    private void ApplyOperationAdapter(List<Operation> list){
        //Appel à la sauvegarde des operations
        OperationAdapter adapter = new OperationAdapter(list);
        OperationRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        OperationRecyclerView.setAdapter(adapter);
    }
}