package com.example.robotandroid;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public interface IRobot {
    public void creerGamme(Gamme g);

    public void modifierGamme(Gamme g);

    public void supprimerGamme(Gamme g);

    public HashMap<String, Gamme> recupererGammes();

    public void connecter(String login, String pwd);

    public void deconnecter();

    public void creerCompte(String login, String pwd);

    public void supprimerCompte(String login);

    public HashMap<String, String> recupererLogs();

    public JSONObject recupererStatut();

    void envoyerMessage(String message);
}
