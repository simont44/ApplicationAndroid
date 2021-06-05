package com.example.robotandroid.GammeRepository;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.robotandroid.JSONManager;
import com.example.robotandroid.ListGammeActivity;
import com.example.robotandroid.MessageJSON;
import com.example.robotandroid.R;

import java.util.List;

public class GammeViewHolder extends RecyclerView.ViewHolder {

    private Gamme unegamme;
    private TextView TextViewGamme;
    private Button ButtonUpdate;
    private Button buttonExec;
    private ImageButton buttonDelete;

    public GammeViewHolder(View itemView) {
        super(itemView);
       TextViewGamme = itemView.findViewById(R.id.TextViewLabelGamme);
       ButtonUpdate = itemView.findViewById(R.id.ButtonUpdate);
       buttonExec = itemView.findViewById(R.id.buttonExec);
       buttonDelete = itemView.findViewById(R.id.widget_listgamme_buttondelete);
    }

    public Gamme getUnegamme() {
        return unegamme;
    }

    public void setUnegamme(Gamme unegamme) {
        this.unegamme = unegamme;
    }

    public void UpdateVisual(Gamme unegamme)
    {
        ButtonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoToEditerGamme();
            }
        });
        this.unegamme = unegamme;
        TextViewGamme.setText(unegamme.description);

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SupprimerGamme();
            }
        });

        buttonExec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExecuterGamme();
            }
        });
    }
    //On envoie sur l'activité de création en donnant les fichiers en paramètres
    public  void GoToEditerGamme()
    {
        Intent menuEdit = new Intent(TextViewGamme.getContext(), EditGammeActivity.class);
        menuEdit.putExtra("extragamme",this.unegamme);
        itemView.getContext().startActivity(menuEdit);
    }
    public void SupprimerGamme()
    {
        ListGammeActivity.ListeGamme.remove(this.unegamme);
        MessageJSON msg = new MessageJSON(MessageJSON.TypeMessage.supprimer,unegamme);
        Intent menuList = new Intent(TextViewGamme.getContext(), ListGammeActivity.class);
        itemView.getContext().startActivity(menuList);
        ((Activity)itemView.getContext()).finish();
    }
    public void ExecuterGamme()
    {
        MessageJSON msg = new MessageJSON(MessageJSON.TypeMessage.executer, unegamme);
        try{
            JSONManager.SendDataJson(msg);
        }catch (Exception e){
            Log.e("FailedExec","L'envoie de la gamme a executer a échouer.");};
    }

}
