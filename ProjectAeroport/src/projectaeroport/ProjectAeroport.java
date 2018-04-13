/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectaeroport;

import annotations.Nokia;
import annotations.Smartphone;
import connect.Connexion;
import java.lang.annotation.Annotation;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Client;
import model.GeneriqueDAO;

/**
 *
 * @author Angelo-KabyLake
 */
public class ProjectAeroport {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
       
        Nokia myPhone = new Nokia("Fire", 5);
        Class c = myPhone.getClass();
        Annotation ann = c.getAnnotation(Smartphone.class);
        Smartphone s = (Smartphone)ann;
        GeneriqueDAO dao = new GeneriqueDAO();
        
        try {
            Connexion co =  new Connexion();
            Connection con = co.getConnexion();
             
            Client[] list = (Client[]) dao.findAll(con, new Client(), "CLT");
            for(int i=0;i<list.length;i++){
                System.out.println(list[i].getId()+" | "+list[i].getNom()+" | "+list[i].getPrenom());
            }
        
            
        } catch (Exception ex) {
         System.out.println("Error !!!!!!!!!!!!!");

        }
        
    }
    
}
