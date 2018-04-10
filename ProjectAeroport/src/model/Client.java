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
public class Client {
    private String id;
    private String nom;
    private String prenom;
    
    String pre = "CLT";
    private Connection connexion = null ;

    public Client(String id, String nom, Connection con) {
        this.setId(id);
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setConnexion(con);
        
    }

    public Connection getConnexion() {
        return connexion;
    }

    public void setConnexion(Connection con) {
        this.connexion = con;
    }
    
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
  
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

    public Client(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }
    public Client (){}
    
    public String getPre() {
        return pre;
    }
    public void setPre(String pre) {
        this.pre = pre;
    }
    
    public Client[] find(String table,String where) throws Exception{
        Client[] ret = null;
        if(this.getConnexion()==null){
            throw new Exception("Erreur : veuillez donner la connection!!!");
        }
        try{
           ret = this.find(this.connexion, table, where);
        }catch(Exception e){
            throw e;
        }
        
        return ret; 
    }
    public Client[] find(Connection con,String table,String where) throws Exception{
		Client[] tabMed;
		Vector listMed = new Vector();
                Statement stmt = null;
                ResultSet rs = null;
                String sql = "select * from "+table;
                
		try{
                if(!where.equals("")){
                    sql = "select * from "+table+" where 1<2 AND "+where;
                }
                stmt = con.createStatement();
                
		rs = stmt.executeQuery(sql);
                
		Boolean exist = rs.next();
                while(exist){
                        Client temporaire = new Client();
                        temporaire.setId(rs.getString(1));
                        temporaire.setNom(rs.getString(2));
                        temporaire.setPrenom(rs.getString(3));
                        listMed.add(temporaire);
                        exist = rs.next();
                } 

		tabMed = new Client[listMed.size()];
		listMed.copyInto(tabMed);
		rs.close();
		stmt.close();
		}catch(Exception e){
			throw e;
		}
		finally{
                    if(stmt!=null){
                        stmt.close();
                    }
                    if(rs!=null){
                        rs.close();
                    }
                    if(con!=null){
                        con.close();
                    }
		}
		return tabMed;
		
    }

   /* public void insert(Connection con, Client a)throws Exception{
       Fonction fon = new Fonction();
       PreparedStatement stmt = null;
       try{

           stmt = con.prepareStatement("INSERT INTO Client(id, nom, prenom) VALUES(?,?,?)");

           stmt.setString(1, fon.getSeq(pre, "seq_Client"));
           stmt.setString(2, a.getNom());
           stmt.setString(3, a.getPrenom());

           stmt.executeUpdate();

       }
       catch(Exception e){
           throw new Exception("Insertion echoué!!!");
       }
       finally{
           if(stmt!=null){
               stmt.close();
           }
           if(con!=null){
               con.close();
           };
       }
    } */
    public void insert()throws Exception{
       Fonction fon = new Fonction();
       PreparedStatement stmt = null;
       try{

           stmt = this.getConnexion().prepareStatement("INSERT INTO Client(id, nom, prenom) VALUES(?,?,?)");

           stmt.setString(1, fon.getSeq(pre, "seq_Client"));
           stmt.setString(2, this.getNom());
           stmt.setString(3, this.getPrenom());

           stmt.executeUpdate();

       }
       catch(Exception e){
           throw new Exception("Insertion echoué!!!");
       }
       finally{
           if(stmt!=null){
               stmt.close();
           }
           if(this.getConnexion()!=null){
               this.getConnexion().close();
           };
       }
    }
    public void insert(Connection con)throws Exception{
       Fonction fon = new Fonction();
       PreparedStatement stmt = null;
       try{

           stmt = con.prepareStatement("INSERT INTO Client(id, nom, prenom) VALUES(?,?,?)");

           stmt.setString(1, fon.getSeq(pre, "seq_Client"));
           stmt.setString(2, this.getNom());
           stmt.setString(3, this.getPrenom());

           stmt.executeUpdate();

       }
       catch(Exception e){
           throw new Exception("Insertion echoué!!!");
       }
       finally{
           if(stmt!=null){
               stmt.close();
           }
           if(con!=null){
               con.close();
           };
       }
    } 
   
    public void update(Connection con)throws Exception{
        PreparedStatement stmt = null;
        try{

            stmt = con.prepareStatement("UPDATE Client SET id=? , nom=?, prenom=? where id=?");

            stmt.setString(1, this.getId());
            stmt.setString(2, this.getNom());
            stmt.setString(3, this.getPrenom());

            stmt.setString(4, this.getId());

            stmt.executeUpdate();

        }
        catch(Exception e){
            throw new Exception("Insertion echoué!!!");
        }
        finally{
            if(stmt!=null){
                stmt.close();
            }
            if(con!=null){
                con.close();
            };
        }
    }
    public void update()throws Exception{
        PreparedStatement stmt = null;
        try{

            stmt = this.getConnexion().prepareStatement("UPDATE Client SET id=? , nom=?, prenom=? where id=?");

            stmt.setString(1, this.getId());
            stmt.setString(2, this.getNom());
            stmt.setString(3, this.getPrenom());

            stmt.setString(4, this.getId());

            stmt.executeUpdate();

        }
        catch(Exception e){
            throw new Exception("Insertion echoué!!!");
        }
        finally{
            if(stmt!=null){
                stmt.close();
            }
            if(this.getConnexion()!=null){
                this.getConnexion().close();
            };
        }
    }
    public void closeConnection() throws SQLException {
        
        try{
            if(this.getConnexion()!=null){
            
                this.getConnexion().close();
            
            }
            else{
                System.out.println("La connexion est deja fermé!!!");
            }
        }catch (Exception e) {
           System.out.println(e.getMessage());
        }
    }
}
