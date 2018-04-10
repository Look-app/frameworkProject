/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectaeroport;

import connect.Connexion;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Angelo-KabyLake
 */
public class ProjectAeroport {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        Connexion con = new Connexion();
        
        try {
           
            con.getConnexion();
        } catch (Exception ex) {
         System.out.println("Error !!!!!!!!!!!!!");
//Logger.getLogger(ProjectAeroport.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
