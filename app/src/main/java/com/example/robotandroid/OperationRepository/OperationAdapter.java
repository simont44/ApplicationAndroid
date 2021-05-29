package com.example.robotandroid.OperationRepository;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.robotandroid.GammeRepository.Gamme;
import com.example.robotandroid.GammeRepository.GammeViewHolder;
import com.example.robotandroid.R;

import java.util.List;

public class OperationAdapter  extends RecyclerView.Adapter<OperationViewHolder>  {

 List<Operation> ListOperation;

    public OperationAdapter(List<Operation> listOperations) {
        ListOperation = listOperations;
    }

    //Liste entière des items Operation

    public OperationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.widget_liste_operation,parent,false);
        return new OperationViewHolder(view);
    }

    public void onBindViewHolder(OperationViewHolder holder, int position) {
        // on charge l'item graphic, on dit ce qu'il faut afficher dans l'item.
        holder.UpdateVisual(ListOperation.get(position));
    }

    public int getItemCount() {
        return ListOperation.size();
    }

}
