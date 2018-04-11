/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connect.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import outil.Fonction;

/**
 *
 * @author Angelo-KabyLake
 */
public class Client extends BaseModel{
    //private String id;
    private String nom;
    private String prenom;

    //Constructeur
    public Client(String id, String nomTable) {
        super(id, nomTable);
    }

    public Client( String id, String nomTable, String nom, String prenom) {
        super(id, nomTable);
        this.nom = nom;
        this.prenom = prenom;
    }
    public Client(){}
    
    
    ///SETTERS && GETTERS
    
    /*public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }*/
  
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
  
}
