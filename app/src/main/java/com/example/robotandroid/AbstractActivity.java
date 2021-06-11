package com.example.robotandroid;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AppComponentFactory;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class AbstractActivity extends AppCompatActivity {
    protected Controleur controleur;

    //L'Abstract Activity sert de même base pour tous les autres activity et pour la sauvegarde d'une liste de gammes à envoyer au robot à l'aide d'un pop up
    //La sauvegarde par Pop-Up n'a pas été retenu, et a été implémenté par défaut après clic du bouton terminé Gamme

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        controleur = Controleur.getInstance();
    }

    @Override
    protected void onStop() {
       super.onStop();
    }


    public void AfficherMessagePop(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(AbstractActivity.this);
        alertDialogBuilder.setMessage("Les données n'ont pas encore été envoyé à la base de donnée. Souhaitez vous les envoyer ? ");
        alertDialogBuilder.setPositiveButton("Sauvegarder", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                controleur.creerGamme(controleur.gammeEnCreation);
                Intent MenuDemarrage = new Intent(getApplicationContext(), MenuDemarrage.class);
                startActivity(MenuDemarrage);
                finish();
            }
        });
        alertDialogBuilder.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }


}
