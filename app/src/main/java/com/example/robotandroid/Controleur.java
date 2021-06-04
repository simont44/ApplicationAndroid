package com.example.robotandroid;

import org.json.JSONObject;
import java.util.HashMap;

public class Controleur {
    IRobot robot;
    HashMap<String, Gamme> listeGammes;
    Utilisateur utilisateurConnecté;
    String nom; //recuperer le nom rensigner par le robot

    public void Controleur(IRobot r)
    {
        this.robot = r;
        this.listeGammes = new HashMap<String, Gamme>();
        //on renseigne le nom et le type de l'utilisateur
        this.utilisateurConnecté = new Utilisateur(nom , false, "","");
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


    public void creerCompte(String login, String pwd) throws Exception {
        if(utilisateurConnecté.admin)
            robot.creerCompte(login, pwd);
        else
            throw new Exception("L'utilisateur n'est pas administrateur.");
    }


    public void supprimerCompte(String login) throws Exception {
        if(utilisateurConnecté.admin)
            robot.supprimerCompte(login);
        else
            throw new Exception("L'utilisateur n'est pas administrateur.");
    }


    public HashMap<String, String> recupererLogs()
    {
        return robot.recupererLogs();
    }

    public JSONObject recupererStatut()
    {
        return robot.recupererStatut();
    }
}

