package com.example.robotandroid;

import java.util.HashMap;

public class Controlleur {
    IRobot robot;
    HashMap<String, Gamme> listeGammes;
    Utilisateur utilisateurConnecté;


    public Controleur(robot r)
    {
        this.robot = r;
        this.listeGammes = new HashMap<String, Gamme>();
        this.utilisateurConnecté = new Utilisateur();
        listeGammes = recupererGammes();
    }


    public void creerGamme(Gamme g)
    {
        robot.creerGamme(g);
    }


    public void modifierGamme(Gamme g)
    {
        robot.modifierGamme(g);
    }


    public void supprimerGamme(Gamme g)
    {
        robot.supprimerGamme(g);
    }


    public HashMap<String, Gamme> recupererGammes()
    {
        return robot.recupererGammes();
    }


    public void connecter(String login, String pwd)
    {
        robot.connecter(login, pwd);
    }


    public void deconnecter()
    {
        robot.deconnecter();
    }


    public void creerCompte(String login, String pwd)
    {
        if(utilisateurConnecté.admin)
            robot.creerCompte(login, pwd);
        else
            throw new Exception("L'utilisateur n'est pas administrateur.");
    }


    public void supprimerCompte(String login)
    {
        if(utilisateurConnecté.admin)
            robot.supprimerCompte(login);
        else
            throw new Exception("L'utilisateur n'est pas administrateur.");
    }


    public HashMap<String, String> recupererLogs()
    {
        return robot.recupererLlogs(g);
    }

    public JSONObject recupererStatut()
    {
        return robot.recupererStatut(g);
    }
}

