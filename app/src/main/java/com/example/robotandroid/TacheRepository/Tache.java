package com.example.robotandroid.TacheRepository;

import java.io.Serializable;

public class Tache implements Serializable {
    public enum TypeAction {Attendre, Tourner}
    TypeAction typeAction;
    int valeur;


    public Tache(TypeAction ta, int v)
    {
        this.typeAction = ta;
        this.valeur = v;
    }
}
