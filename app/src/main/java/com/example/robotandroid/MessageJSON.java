package com.example.robotandroid;

import com.example.robotandroid.GammeRepository.Gamme;

public class MessageJSON {
    public MessageJSON(TypeMessage type, Gamme gamme) {
        this.type = type;
        this.idGamme = gamme.getId();
        this.gamme = gamme;
    }

    public enum TypeMessage{executer, editer, supprimer};
    private TypeMessage type;
    private String idGamme;
    private Gamme gamme;

    public TypeMessage getType() {
        return type;
    }

    public void setType(TypeMessage type) {
        this.type = type;
    }

    public String getIdGamme() {
        return idGamme;
    }

    public void setIdGamme(String idGamme) {
        this.idGamme = idGamme;
    }

    public Gamme getGamme() {
        return gamme;
    }

    public void setGamme(Gamme gamme) {
        this.gamme = gamme;
    }
}
