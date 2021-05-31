package com.example.robotandroid;

import com.example.robotandroid.GammeRepository.Gamme;

public class MessageJSON {
    public enum TypeMessage{executer, editer, supprimer};
    private TypeMessage type;
    private int idGamme;
    private Gamme gamme;

    public TypeMessage getType() {
        return type;
    }

    public void setType(TypeMessage type) {
        this.type = type;
    }

    public int getIdGamme() {
        return idGamme;
    }

    public void setIdGamme(int idGamme) {
        this.idGamme = idGamme;
    }

    public Gamme getGamme() {
        return gamme;
    }

    public void setGamme(Gamme gamme) {
        this.gamme = gamme;
    }
}
