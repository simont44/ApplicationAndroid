package com.example.robotandroid;

import com.example.robotandroid.GammeRepository.Gamme;
import com.google.gson.Gson;

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


    @Override
    public void creerGamme(Gamme g) {

    }

    @Override
    public void modifierGamme(Gamme g) {

    }

    @Override
    public void supprimerGamme(Gamme g) {

    }

    @Override
    public HashMap<String, Gamme> recupererGammes() {
        return null;
    }

    @Override
    public void connecter(String login, String pwd)
    {

    }

    @Override
    public void deconnecter() {

    }

    @Override
    public void creerCompte(String login, String pwd) {

    }

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

    @Override
    public void ouvrir(String ip) {
        listenThread = this.listenExecService.submit(new Runnable()
        {
            public void run()
            {
                int port = 80;
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
