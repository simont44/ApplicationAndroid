package com.example.robotandroid.TacheRepository;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.robotandroid.R;

public class TacheViewHolder extends RecyclerView.ViewHolder {

    private Tache tache;
    private TextView textViewTypeAction;
    private TextView textViewValue;
    private Button buttonSuppr;

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

    public void UpdateVisual(Tache tache)
    {
        buttonSuppr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        this.tache = tache;
        textViewValue.setText(tache.valeur+"");
        textViewTypeAction.setText(tache.typeAction.toString());
    }
}
