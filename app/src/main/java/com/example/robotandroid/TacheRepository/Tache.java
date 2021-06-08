package com.example.robotandroid.TacheRepository;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Tache implements Serializable {
    private String id;
    private String description;
    private TypeAction typeAction;
    private int valeur;
    private char moteur;

    public enum TypeAction {@SerializedName("Attendre") Attendre, @SerializedName("Tourner") Tourner; }

    public Tache(TypeAction ta, int v) {
        setTypeAction(ta);
        this.valeur = v;
    }

    public Tache(String id, String description, int valeur)
    {
        this.id = id;
        this.description = description;
        this.typeAction = TypeAction.Attendre;
        this.valeur = valeur;
    }


    public Tache(String id, String description, int valeur, char moteur)
    {
        this.id = id;
        this.description = description;
        this.typeAction = TypeAction.Tourner;
        this.valeur = valeur;
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypeAction getTypeAction() {
        return this.typeAction;
    }

    public void setTypeAction(TypeAction typeAction) {
        this.typeAction = typeAction;
    }

    public char getMoteur(){ return moteur; }

    public void setMoteur(char m) { moteur = m; }

    public int getValeur() { return valeur; }

    public void setValeur(int v) { valeur = v; }
}
