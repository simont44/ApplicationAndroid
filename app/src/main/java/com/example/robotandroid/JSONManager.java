package com.example.robotandroid;

import android.icu.util.Output;
import android.util.Log;

import com.example.robotandroid.GammeRepository.Gamme;
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
        //Update pour envoyer au robot
    }
    public static void SendAllList() throws IOException {
        for (MessageJSON msg: listMessage) {
            SendDataJson(msg);
         }
        Log.e("Sav", "Sauvegarde envoyée");
    }

    public static String GetDataJson() throws IOException {
        Socket socket = new Socket("ipRobot",00);
        InputStream in = socket.getInputStream();

        byte[] message = new byte[2048];
        in.read(message);

        return null;
    }

    // Récuperer liste Gamme
    public static List<Gamme> ConvertStringToListGamme(String json)
    {
        Gson gson = new Gson();
        List<Gamme> datagamme = gson.fromJson(json, new TypeToken<List<Gamme>>(){}.getType());
        return datagamme;
    }

   public static List<MessageJSON> listMessage = new ArrayList<MessageJSON>();

}
