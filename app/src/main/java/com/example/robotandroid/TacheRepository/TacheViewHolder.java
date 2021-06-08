package com.example.robotandroid.TacheRepository;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.robotandroid.GammeRepository.EditGammeActivity;
import com.example.robotandroid.GammeRepository.Gamme;
import com.example.robotandroid.OperationRepository.EditOperationActivity;
import com.example.robotandroid.OperationRepository.Operation;
import com.example.robotandroid.R;

public class TacheViewHolder extends RecyclerView.ViewHolder {

    private Tache tache;
    private TextView textViewTypeAction;
    private TextView textViewValue;
    private Button buttonSuppr;
    private Gamme gamme;
    private Operation operation;

    public TacheViewHolder(View itemView) {
        super(itemView);
        textViewTypeAction = itemView.findViewById(R.id.widget_text_typeAction);
        textViewValue = itemView.findViewById(R.id.widget_text_value);
        buttonSuppr = itemView.findViewById(R.id.widget_tache_suppr_button);
    }

    public Tache getUneoperation() {
        return tache;
    }

    public void setUneoperation(Tache tache) {
        this.tache = tache;
    }

    public void UpdateVisual(Tache tache, Operation operation, Gamme gamme)
    {

        this.operation = operation;
        this.gamme = gamme;
        this.tache = tache;
        buttonSuppr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SupprimerTache();
            }
        });
        textViewValue.setText(tache.getValeur() + "");
        textViewTypeAction.setText(tache.getTypeAction().toString());
    }
    public void SupprimerTache(){

        operation.SupprimerTache(this.tache);

        Intent intent = new Intent(textViewTypeAction.getContext(), EditOperationActivity.class);
        intent.putExtra("extragamme",gamme);
        intent.putExtra("numOpe", gamme.getListeOperations().indexOf(operation));
        itemView.getContext().startActivity(intent);
        ((Activity) itemView.getContext()).finish();
    }
}
