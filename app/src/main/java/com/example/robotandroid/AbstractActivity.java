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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onStop() {
       super.onStop();
    }

    //Quand on a des données non sauvegardées, on lance l'application
    protected void AfficherSauvegarde(View parent){

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_sauvegarde, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = false; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken

        parent.post(new Runnable() {
            @Override
            public void run() {
                if (JSONManager.listMessage.size() != 0) {
                    popupWindow.showAtLocation(parent, Gravity.TOP, 0, 0);
                    TextView text_popup = popupView.findViewById(R.id.popup_sav_interaction);

                    text_popup.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            AfficherMessagePop();
                        }
                    });

                }
            }
        });
    }

    public void AfficherMessagePop(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(AbstractActivity.this);
        alertDialogBuilder.setMessage("Les données n'ont pas encore été envoyé à la base de donnée. Souhaitez vous les envoyer ? ");
        alertDialogBuilder.setPositiveButton("Sauvegarder", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    JSONManager.SendAllList();
                    Log.e("SaveBDD","Les données sont sauvegardées et envoyées à la BDD");
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
