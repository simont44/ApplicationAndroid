package com.example.robotandroid;

import com.example.robotandroid.GammeRepository.Gamme;

import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.HashMap;

public class RobotConnexion implements IRobot
{
    Socket socketRobot;

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
    public void connecter(String login, String pwd) {

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
    public void envoyerMessage(String message) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socketRobot.getOutputStream()));
        out.write(message);
        out.flush();
    }

    @Override
    public void ouvrir(String ip) throws IOException {
        socketRobot = new Socket(ip, 80);
    }

    @Override
    public void fermer() {
        try {
            if(!socketRobot.isClosed())
                socketRobot.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
