package com.example.robotandroid;

import com.example.robotandroid.GammeRepository.Gamme;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class WifiListener implements IRobot
{

    Socket socket;

    private Future listenThread, sendThread;
    private ExecutorService listenExecService = Executors.newSingleThreadExecutor();
    private ExecutorService sendExecService = Executors.newSingleThreadExecutor();

    BufferedReader in;
    BufferedWriter out;

//Methode envoyant la nouvelle gamme créée au robot pour sauvegarde
    @Override
    public void creerGamme(Gamme g)
    {
        Gson gson = new Gson();
        JsonObject json = new JsonObject();
        json.addProperty("action", "newG");
        json.add("gamme", gson.toJsonTree(g));
        envoyerMessage(gson.toJson(json));
    }

    //Methode modifiant une gamme et doit écraser l'ancienne version sauvegardé côté robot.
    //L'ancienne méthode GoToEditerGamme est trouvable dans GammeViewHolder
    @Override
    public void modifierGamme(Gamme g) {

    }

    //Methode supprimant une gamme dans la liste sauvegardée côté robot
    //L'ancienne méthode SupprimerGamme est trouvable dans GammeViewHolder
    @Override
    public void supprimerGamme(Gamme g) {

    }

//On envoi la gamme a executer côté Robot
    @Override
    public void executerGamme(String idGamme)
    {
        JsonObject json = new JsonObject();
        json.addProperty("action", "execG");
        json.addProperty("idGamme", idGamme);
        envoyerMessage(new Gson().toJson(json));
    }

    //Methodes à implémenter pour récupération d'une liste de gamme
    @Override
    public HashMap<String, Gamme> recupererGammes() {
        return null;
    }

    //On envoie les données de connexion au robot.
    @Override
    public void connecter(String login, String pwd)
    {
        JsonObject json = new JsonObject();
        json.addProperty("action", "co");
        json.addProperty("login", login);
        json.addProperty("pwd", pwd);
        envoyerMessage(new Gson().toJson(json));
    }

    //On ferme la connexion au robot
    @Override
    public void deconnecter()
    {
        try {
            JsonObject json = new JsonObject();
            json.addProperty("action", "deco");
            envoyerMessage(new Gson().toJson(json));
            socket.close();
        } catch (Exception e) {
        }
    }

    // TODO : Méthode de création de compte à implémenter
    // Renseigner le login et le mot de passe, le login doit être unique
    // L'utilisateur connecté doit être administrateur
    @Override
    public void creerCompte(String login, String pwd) {

    }

    //TODO : Méthode de suppression de compte à implémenter
    // renseigner le login de l'utilisateur à supprimer
    // le login doit être différent de celui connecté
    // l'utilisateur connecté doit être administrateur

    @Override
    public void supprimerCompte(String login) {

    }

    @Override
    public HashMap<String, String> recupererLogs() {
        return null;
    }

    @Override
    public JSONObject recupererStatut() {
        return null;
    }

    @Override
    public void envoyerMessage(String message) {
        sendThread = this.sendExecService.submit(new Runnable()
        {
            public void run()
            {
                try
                {
                    System.out.println(String.format("Message envoyé : %s", message));
                    out.write(String.format("%s\n", message));
                    out.flush();
                }
                catch(Exception e)
                {
                    System.out.println(String.format("Impossible d'envoyer un message : %s", e.getMessage()));
                }
            }
        });
    }

//On ouvre la connexion au port du robot et la garde ouverte tant qu'il n'y a pas d'action de deconnexion
    @Override
    public void ouvrir(String ip) {
        listenThread = this.listenExecService.submit(new Runnable()
        {
            public void run()
            {
                //On renseigne le port en dur, il doit être identique à celui indiqué côté robot.
                int port = 2048;
                try {
                    socket = new Socket(ip, port);
                    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                    System.out.println(String.format("Connecté sur %s, port %d", ip, port));
                    while(!socket.isClosed())
                    {
                        String s ="";
                        System.out.println("Attente d'un message...");
                        if((s = in.readLine()) != null)
                            System.out.println(String.format("Message reçu : %s", s));
                        else
                            socket.close();
                    }
                    System.out.println("Socket fermé");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //On ferme la connexion
    @Override
    public void fermer() {
        try {
            if(!socket.isClosed())
                socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
