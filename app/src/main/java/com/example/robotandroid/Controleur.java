package com.example.robotandroid;

import com.example.robotandroid.GammeRepository.Gamme;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONException;
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

    public Gamme gammeEnCreation;


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


    public void executerGamme(int id)
    {
        try
        {
            JSONObject json = new JSONObject();
            json.put("action", "execG");
            json.put("idGamme", String.valueOf(id));

            robot.envoyerMessage(new Gson().toJson(json));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void mode(String m)
    {
        try
        {
            JsonObject json = new JsonObject();
            json.addProperty("action", m == null ? "auto" : m);

            robot.envoyerMessage(new Gson().toJson(json));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
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
        try
        {
            JsonObject json = new JsonObject();
            json.addProperty("action", "co");
            json.addProperty("login", login);
            json.addProperty("pwd", pwd);

            robot.envoyerMessage(new Gson().toJson(json));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
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

