package com.example.robotandroid;

import java.util.ArrayList;

public class Operation {
    ArrayList<Tache> ListeTaches;
    String titre;
    String description;

    public Operation(String titre, String description)
    {
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

