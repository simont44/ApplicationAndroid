package com.example.robotandroid;

import java.io.Serializable;

public class Utilisateur implements Serializable {
    String nom;
    boolean admin;
    String login;
    String mdp;


    public Utilisateur(String n, boolean a)
    {
        this.nom = n;
        this.admin = a;
        this.login="";
        this.mdp="";
    }

    public void setMdp(String pwd)
    {
        this.mdp=pwd;
    }


    public void setLogin(String login)
    {
        this.login=login;
    }

    public String getLogin() {
        return this.login;
    }

    public String getMdp() {
        return this.login;
    }
}
