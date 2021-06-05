package com.example.robotandroid;

import android.net.wifi.WifiManager;

import java.net.InetAddress;
import java.util.ArrayList;


public class WifiClass {
    private InetAddress ipRobot;
    private Integer port;

    public WifiClass(InetAddress ipDuRobot, Integer lePort){
        this.ipRobot = ipDuRobot;
        this.port = lePort;
    }


    public InetAddress getIpRobot() {
        return ipRobot;
    }

    public void setIpRobot(InetAddress ipRobot) {
        this.ipRobot = ipRobot;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
