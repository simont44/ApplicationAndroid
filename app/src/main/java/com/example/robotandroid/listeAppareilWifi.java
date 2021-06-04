package com.example.robotandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.robotandroid.databinding.ActivityListeAppareilWifiBinding;
import com.stealthcopter.networktools.SubnetDevices;
import com.stealthcopter.networktools.subnet.Device;

import java.util.ArrayList;
import java.util.Scanner;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class listeAppareilWifi extends AppCompatActivity {

    private Spinner listeAppareilWifiSpinner;
    private TextView etatWifiTextView;
    WifiManager wifiManager;
    ArrayList<InetAddress> listeAdresseIp;
    private TextView etatScanTextView;
    private ArrayList<Device> devices;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_appareil_wifi);
        etatWifiTextView = (TextView)findViewById(R.id.etatWifi);
        etatScanTextView =(TextView)findViewById(R.id.etatScan);
        this.listeAppareilWifiSpinner = (Spinner)findViewById(R.id.spinnerListeAppareilWifi);
        findSubnetDevices();    //On lance la méthode qui récupère la liste des appareils connectés
        ArrayAdapter<Device> adapterDevice = new ArrayAdapter<Device>(this, android.R.layout.simple_spinner_dropdown_item,devices);
        adapterDevice.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.listeAppareilWifiSpinner.setAdapter(adapterDevice);

        this.listeAppareilWifiSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                onItemSelected(parent,view,position,id);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    private void onItemSelectedHandler(AdapterView<?>adapterView,View view,int position,long id){
        Adapter adapter =adapterView.getAdapter();
        Device device = (Device)adapter.getItem(position);
    }
    private void findSubnetDevices() {

        final long startTimeMillis = System.currentTimeMillis();
        etatScanTextView.setText("Scanning...");
        SubnetDevices subnetDevices = SubnetDevices.fromLocalAddress().findDevices(new SubnetDevices.OnSubnetDeviceFound() {

            @Override
            public void onDeviceFound(Device device) {

            }

            public void onFinished(ArrayList<Device> devicesFound) {
                float timeTaken =  (System.currentTimeMillis() - startTimeMillis)/1000.0f;

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        etatScanTextView.setText("Scan terminé");
                        for(Device device:devicesFound) {
                            devices.add(device);

                        }
                    }
                });

              /*  appendResultsText("Finished "+timeTaken+" s");
                setEnabled(subnetDevicesButton, true);*/
            }
        });

        // Below is example of how to cancel a running scan
        // subnetDevices.cancel();

    }




    private String readtvWifiState(WifiManager wm){
        String result = "";
        switch (wm.getWifiState()){
            case WifiManager.WIFI_STATE_DISABLED:
                result = "WIFI_STATE_DISABLED";
                break;
            case WifiManager.WIFI_STATE_DISABLING:
                result = "WIFI_STATE_DISABLING";
                break;
            case WifiManager.WIFI_STATE_ENABLED:
                result = "WIFI_STATE_ENABLED";
                break;
            case WifiManager.WIFI_STATE_ENABLING:
                result = "WIFI_STATE_ENABLING";
                break;
            case WifiManager.WIFI_STATE_UNKNOWN:
                result = "WIFI_STATE_UNKNOWN";
                break;
            default:
        }
        return result;
    }

}