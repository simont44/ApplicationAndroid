package com.example.robotandroid;

import
        androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.robotandroid.GammeRepository.CreateGamme;
import com.example.robotandroid.GammeRepository.Gamme;
import com.example.robotandroid.GammeRepository.GammeAdapter;
import com.example.robotandroid.OperationRepository.Operation;
import com.example.robotandroid.TacheRepository.Tache;

import java.util.ArrayList;
import java.util.List;

public class MenuGamme extends AbstractActivity {

    private RecyclerView GammeRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_gamme);



        Button buttonMenu = findViewById(R.id.buttonMenu);
        buttonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetourMenu();
            }
        });

        Button buttonAjouterGamme = findViewById(R.id.buttonAdd);
        buttonAjouterGamme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateGamme();
            }
        });


        GammeRecyclerView = findViewById(R.id.ViewListGamme);

        //Jeu de données temporaire
       List<Gamme> listeGamme = new ArrayList<>();
       Gamme gamme2 = new Gamme("2", "C est encore un test");
       Operation op1 = new Operation("Tourner","ça tourne");
        try {
            gamme2.AjouterOperation(op1);
            op1.AjouterTache(new Tache(Tache.TypeAction.Attendre,5));
        } catch (Exception e) {
            e.printStackTrace();
        }
        listeGamme.add(gamme2);
      //   String s = JSONManager.SendDataJson(listeGamme);  //On met ce qu'on reçoit de la base de données
      // String s = "{\"description\":\"Test rotation\",\"id\":\"1\",\"listeOperations\":[{\"ListeTaches\":[{\"typeAction\":\"Tourner\",\"valeur\":12},{\"typeAction\":\"Attendre\",\"valeur\":5}]},{\"ListeTaches\":[{\"typeAction\":\"Tourner\",\"valeur\":24}]}]}\n";
      //  listeGamme= JSONManager.ConvertStringToListGamme(s);
        ApplyGammeAdapter(listeGamme);
        AfficherSauvegarde(findViewById(R.id.root_menugamme));
    }
    public void RetourMenu()
    {
        Intent menu = new Intent(this, MenuDemarrage.class);
        startActivity(menu);
        finish();
    }
    //a copier pour les taches
    public void CreateGamme()
    {
        Gamme gamme = new Gamme("nouveau","nouveau");
        Intent menuCreate = new Intent(this, CreateGamme.class);
        menuCreate.putExtra("extragamme",gamme);
        MessageJSON msg = new MessageJSON(MessageJSON.TypeMessage.editer,gamme);
        JSONManager.listMessage.add(msg);
        startActivity(menuCreate);

    }


    private void ApplyGammeAdapter(List<Gamme> list){
        //Appel à la sauvegarde des gammes
        GammeAdapter adapter = new GammeAdapter(list);
        GammeRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        GammeRecyclerView.setAdapter(adapter);
    }

}

