package com.example.robotandroid.OperationRepository;

import com.example.robotandroid.TacheRepository.Tache;

import java.io.Serializable;
import java.util.ArrayList;

public class Operation implements Serializable {
    ArrayList<Tache> ListeTaches;
    String titre;
    String description;

    public Operation(String titre, String description)
    {
        this.titre = titre;
        this.description = description;
        ListeTaches = new ArrayList<Tache>();
    }


    public void AjouterTache(Tache t)
    {
        ListeTaches.add(t);
    }


    public void SupprimerTache(Tache t)
    {
        ListeTaches.remove(t);
    }
}

