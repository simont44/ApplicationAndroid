package com.example.robotandroid.TacheRepository;

import java.io.Serializable;

public class Tache implements Serializable {
    String id;
    String description;
    TypeAction typeAction;
    int valeur;
    char port;

    public enum TypeAction {Attendre, Tourner}


    public Tache(String id, String description, TypeAction typeAction, int valeur, char moteur)
    {
        this.id = id;
        this.description = description;
        this.typeAction = typeAction;
        this.valeur = valeur;
        this.port = moteur;
    }
}
