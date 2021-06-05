package com.example.robotandroid;
import com.example.robotandroid.Utilisateur;

public class MessageJSONConnexion {
    private String typeMessage;
    private String login;
    private String mdp;


    public MessageJSONConnexion(String type, String leLogin, String leMdp ){
        this.typeMessage = type;
        this.login = leLogin;
        this.mdp = leMdp;
    }

    public void setTypeMessage(String type){
        this.typeMessage=type;
    }

    public void setLogin(String leLogin){
        this.typeMessage=leLogin;
    }

    public void setMdp(String leMdp){
        this.typeMessage=leMdp;
    }

    public String getTypeMessage(){
        return this.typeMessage;
    }

    public String getLogin(){
        return this.login;
    }
    public String getMdp(){
        return this.mdp;
    }


}
