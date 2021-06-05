package com.example.robotandroid;
import com.example.robotandroid.Utilisateur;

public class userDataUtils {
    public static Utilisateur[] getUtilisateur(){
        Utilisateur u1 = new Utilisateur("jean",false,"jeanjean","123456");
        Utilisateur u2 = new Utilisateur("jean",true,"jeanjean","123456");
 return new Utilisateur[]{u1,u2};
    }
}
