package com.example.robotandroid;

import com.example.robotandroid.GammeRepository.Gamme;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class JSONManager {


    public static String SendDataJson(MessageJSON msg)
    {
        Gson gson = new Gson();
        String json = gson.toJson(msg);
        return json;

        //Update pour envoyer au robot
    }

    // Récuperer liste Gamme
    public static List<Gamme> ConvertStringToListGamme(String json)
    {
        Gson gson = new Gson();
        List<Gamme> datagamme = gson.fromJson(json, new TypeToken<List<Gamme>>(){}.getType());
        return datagamme;
    }

}
