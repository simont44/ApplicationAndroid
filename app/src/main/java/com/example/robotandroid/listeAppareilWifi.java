package com.example.robotandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class listeAppareilWifi extends AppCompatActivity {

    private Spinner listeAppareilWifi;
    final Scanner sc = new Scanner(System.in);//pour lire à partir du clavier
    private InetAddress adresseIP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_appareil_wifi);
    }

}