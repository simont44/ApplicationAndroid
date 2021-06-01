package com.example.robotandroid;
import android.icu.util.Output;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
public class JSONManager {
    public static String SendDataJson(MessageJSONConnexion msg) throws IOException
    {
        Gson gson = new Gson();
        String json = gson.toJson(msg);
        return json;


    }
}
