package com.example.robotandroid.GammeRepository;

import com.example.robotandroid.Operation;

import java.util.ArrayList;

public class Gamme {

        String id;
        String description;
        ArrayList<Operation> listeOperations;


        public Gamme(String i, String d)
        {
            this.id = i;
            this.description = d;
            listeOperations = new ArrayList<Operation>();
        }


        public void AjouterOperation(Operation o) throws Exception {
            if(!listeOperations.contains(o))
                listeOperations.add(o);
            else
                throw new Exception("Cette opération est déjà présente dans la gamme.");
        }


        public void SupprimerOperation(Operation o) throws Exception {
            if (listeOperations.contains(o))
                listeOperations.remove(o);
            else
                throw new Exception("Cette opération n'est pas présente dans la gamme.");
        }



}
