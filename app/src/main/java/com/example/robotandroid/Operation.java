package com.example.robotandroid;

import java.util.ArrayList;

public class Operation {
    ArrayList<Tache> ListeTaches;


    public Operation()
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

