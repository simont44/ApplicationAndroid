package com.example.robotandroid.OperationRepository;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.robotandroid.GammeRepository.EditGammeActivity;
import com.example.robotandroid.GammeRepository.Gamme;
import com.example.robotandroid.R;

public class OperationViewHolder extends RecyclerView.ViewHolder {

    private Operation uneoperation;
    private TextView TextViewOperation;
    private Button ButtonUpdate;
    private Button buttonDelete;
    private Gamme gamme;


    public OperationViewHolder(View itemView) {
        super(itemView);
        TextViewOperation = itemView.findViewById(R.id.textView_titreope);
        ButtonUpdate = itemView.findViewById(R.id.button_EditOpe);
        buttonDelete = itemView.findViewById(R.id.button_DeleteOpe);
    }

    public Operation getUneoperation() {
        return uneoperation;
    }

    public void setUneoperation(Operation uneoperation) {
        this.uneoperation = uneoperation;
    }

    public void UpdateVisual(Operation uneope, Gamme gamme)
    {
        ButtonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoToEditerOperation();
            }
        });
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SupprimerOperation();
            }
        });
        this.uneoperation = uneope;
        this.gamme = gamme;
        TextViewOperation.setText(uneoperation.titre);
    }
    //On envoie sur l'activité de création en donnant les fichiers en paramètres
    public  void GoToEditerOperation()
    {
        Intent intent = new Intent(TextViewOperation.getContext(), EditOperationActivity.class);
        intent.putExtra("extragamme",gamme);
        intent.putExtra("numOpe",gamme.getListeOperations().indexOf(uneoperation));
        itemView.getContext().startActivity(intent);
    }
    public void SupprimerOperation() {
        try {
            gamme.SupprimerOperation(this.uneoperation);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Intent intent = new Intent(TextViewOperation.getContext(), EditGammeActivity.class);
        intent.putExtra("extragamme",gamme);
        itemView.getContext().startActivity(intent);
        ((Activity) itemView.getContext()).finish();
    }
}
