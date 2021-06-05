package com.example.robotandroid;

import com.example.robotandroid.GammeRepository.Gamme;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

// Changement en classe Singleton pour que tous les écrans utilisent lemême
public class Controleur {
    static Controleur controleurInstance;
    IRobot robot;
    HashMap<String, Gamme> listeGammes;
    Utilisateur utilisateurConnecté;
    String nom; //recuperer le nom renseigné par le robot


    public static void initControleur(IRobot robot)
    {
        if(controleurInstance != null) return;
        controleurInstance = new Controleur(robot);
    }


    public static Controleur getInstance()
    {
        return controleurInstance;
    }


    private Controleur() {};

    private Controleur(IRobot r)
    {
        this.robot = r;
        this.listeGammes = new HashMap<String, Gamme>();
        //on renseigne le nom et le type de l'utilisateur
        this.utilisateurConnecté = new Utilisateur(nom , false);
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


    public void etablirConnexion(String ip) throws IOException {
        robot.ouvrir(ip);
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

