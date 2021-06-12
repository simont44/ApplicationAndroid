package com.example.robotandroid.GammeRepository;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.robotandroid.Controleur;
import com.example.robotandroid.ListGammeActivity;
import com.example.robotandroid.R;

public class GammeViewHolder extends RecyclerView.ViewHolder {
//Le Gamme view Holder est la vue qui represente un item de la liste Gamme.
    private Gamme gamme;
    private TextView TextViewGamme;
    private Button ButtonUpdate;
    private Button buttonExec;
    private ImageButton buttonDelete;
    Controleur controleur;

    public GammeViewHolder(View itemView) {
        super(itemView);

        controleur = Controleur.getInstance();

        TextViewGamme = itemView.findViewById(R.id.TextViewLabelGamme);
        ButtonUpdate = itemView.findViewById(R.id.ButtonUpdate);
        buttonExec = itemView.findViewById(R.id.buttonExec);
        buttonDelete = itemView.findViewById(R.id.widget_listgamme_buttondelete);
    }

    public Gamme getGamme() {
        return gamme;
    }

    public void setGamme(Gamme gamme) {
        this.gamme = gamme;
    }

    //Pour chaque item Gamme, on propose 3 boutons, Editer, Supprimer, Executer qui après intéractions vont faire appel aux fonctions correspondantes.
    public void UpdateVisual(Gamme unegamme)
    {
        ButtonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoToEditerGamme();
            }
        });
        this.gamme = unegamme;
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
    //Fonctionne localement mais pas après connexion au robot
    //Obsolete fonctionne avec une liste de gamme instanciée côté android
    public  void GoToEditerGamme()
    {
        Intent menuEdit = new Intent(TextViewGamme.getContext(), EditGammeActivity.class);
        menuEdit.putExtra("extragamme",this.gamme);
        itemView.getContext().startActivity(menuEdit);
    }
    //Fonction de suppression fonctionnant localement mais pas après connexion au robot
    //Obsolete : Fonctionne avec une liste de gamme instanciée côté android
    public void SupprimerGamme()
    {
        ListGammeActivity.ListeGamme.remove(this.gamme);
        //TODO : Demander la suppression au robot
        Intent menuList = new Intent(TextViewGamme.getContext(), ListGammeActivity.class);
        itemView.getContext().startActivity(menuList);
        ((Activity)itemView.getContext()).finish();
    }
    public void ExecuterGamme()
    {
        controleur.executerGamme(gamme.getId());
    }

}
