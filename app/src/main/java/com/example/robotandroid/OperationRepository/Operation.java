package com.example.robotandroid.OperationRepository;

import com.example.robotandroid.TacheRepository.Tache;

import java.io.Serializable;
import java.util.ArrayList;

public class Operation implements Serializable {
    ArrayList<Tache> listeTaches;
    String id;
    String description;

    public Operation(String id, String description)
    {
        this.id = id;
        this.description = description;
        listeTaches = new ArrayList<Tache>();
    }


    public void AjouterTache(Tache t)
    {
        listeTaches.add(t);
    }


    public void SupprimerTache(Tache t)
    {
        listeTaches.remove(t);
    }

    public ArrayList<Tache> getListeTaches() {
        return listeTaches;
    }

    public void setListeTaches(ArrayList<Tache> listeTaches) {
        this.listeTaches = listeTaches;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

