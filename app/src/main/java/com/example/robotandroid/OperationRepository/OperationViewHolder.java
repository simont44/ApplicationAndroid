package com.example.robotandroid.OperationRepository;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.robotandroid.GammeRepository.CreateGamme;
import com.example.robotandroid.GammeRepository.Gamme;
import com.example.robotandroid.R;

public class OperationViewHolder extends RecyclerView.ViewHolder {

    private Operation uneoperation;
    private TextView TextViewOperation;
    private Button ButtonUpdate;
    private Button buttonDelete;

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

    public void UpdateVisual(Operation uneope)
    {
        ButtonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoToEditerOperation();
            }
        });
        this.uneoperation = uneope;
        TextViewOperation.setText(uneoperation.titre);
    }
    //On envoie sur l'activité de création en donnant les fichiers en paramètres
    public  void GoToEditerOperation()
    {
        Intent menuEdit = new Intent(TextViewOperation.getContext(), CreateGamme.class);
        menuEdit.putExtra("extraope",this.uneoperation);
        itemView.getContext().startActivity(menuEdit);
    }
}
