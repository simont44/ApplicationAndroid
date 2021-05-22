package com.example.robotandroid;

import org.json.JSONObject;

import java.util.ArrayList;

public interface IRobot {
    public void creerGamme(Gamme g);

    public void modifierGamme(Gamme g);

    public void supprimerGamme(Gamme g);

    public ArrayList<Gamme> recupererGammes();

    public void connecter(String login, String pwd);

    public void deconnecter();

    public void creerCompte(String login, String pwd);

    public void supprimerCompte(String login);

    public ArrayList<String> recupererLogs();

    public JSONObject recuprerStatut();

    void envoyerMessage(String message);
}
