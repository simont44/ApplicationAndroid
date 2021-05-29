package com.example.robotandroid.GammeRepository;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.robotandroid.GammeRepository.Gamme;
import com.example.robotandroid.R;

import org.w3c.dom.Text;

public class GammeViewHolder extends RecyclerView.ViewHolder {

    private Gamme unegamme;
    private TextView TextViewGamme;
    private Button ButtonUpdate;
    private Button buttonExec;

    public GammeViewHolder(View itemView) {
        super(itemView);
       TextViewGamme = itemView.findViewById(R.id.TextViewLabelGamme);
       ButtonUpdate = itemView.findViewById(R.id.ButtonUpdate);
       buttonExec = itemView.findViewById(R.id.buttonExec);
    }

    public Gamme getUnegamme() {
        return unegamme;
    }

    public void setUnegamme(Gamme unegamme) {
        this.unegamme = unegamme;
    }

    public void UpdateVisual(Gamme unegamme)
    {
        this.unegamme = unegamme;
        TextViewGamme.setText(unegamme.description);
    }

}
