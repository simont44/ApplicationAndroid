package com.example.robotandroid;

import android.icu.util.Output;
import android.util.Log;

import com.example.robotandroid.GammeRepository.Gamme;
import com.example.robotandroid.OperationRepository.Operation;
import com.example.robotandroid.TacheRepository.Tache;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class JSONManager {


    public static String SendDataJson(MessageJSON msg) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(msg);

        Socket socket = new Socket("ipRobot",00);
        OutputStream out = socket.getOutputStream();
        out.write(json.getBytes());

        socket.close();
        return json;
    }
    public static void SendAllList() throws IOException {
        for (MessageJSON msg: listMessage) {
            SendDataJson(msg);
         }
        Log.e("Sav", "Sauvegarde envoyée");
    }

    public static ArrayList<Gamme> GetDataFromBDD() throws IOException {
        ArrayList<Gamme> listeGamme = new ArrayList<Gamme>();
//        Socket socket = new Socket("ipRobot",00);
//        InputStream in = socket.getInputStream();
//
//        byte[] message = new byte[2048];
//        in.read(message);

        //Jeu de données temporaire
        Gamme gamme2 = new Gamme("2", "Test");
        Operation op1 = new Operation("Tourner","ça tourne");
        try {
            gamme2.AjouterOperation(op1);
            op1.AjouterTache(new Tache("1", "attendre", Tache.TypeAction.Attendre, 1000,'A'));
        } catch (Exception e) {
            e.printStackTrace();
        }
        listeGamme.add(gamme2);

        return listeGamme;
    }

   public static List<MessageJSON> listMessage = new ArrayList<MessageJSON>();

}
