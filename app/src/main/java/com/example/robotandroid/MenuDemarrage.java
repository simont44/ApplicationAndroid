package com.example.robotandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuDemarrage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_demarrage);

        Button buttonGamme = findViewById(R.id.buttonGamme);
        buttonGamme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenMenuGamme();
            }
        });
    }
    public void OpenMenuGamme()
    {
       Intent menu = new Intent(this, MenuGamme.class);
       startActivity(menu);
    }
}