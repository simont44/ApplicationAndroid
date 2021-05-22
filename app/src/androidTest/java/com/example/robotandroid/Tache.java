package com.example.robotandroid;

public class Tache {
    enum TypeAction {Attendre, Tourner}
    TypeAction typeAction;
    int valeur;


    public Tache(TypeAction ta, int v)
    {
        this.typeAction = ta;
        this.valeur = v;
    }
}
