/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.service;

import dao.ClientDAO;
import dao.JpaUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import metier.modele.Client;

/**
 *
 * @author Mehdi
 */
public class ClientService {

    public static void ajouterClient(Client c){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       ClientDAO.Persist(c);
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
    }
    
    
    public static Client rechercherClientParID(int ID){
        String urlDB = "jdbc:derby://localhost:1527/IFRoutardDB";
        try {
            Connection maConnection = DriverManager.getConnection(urlDB,"mkitane","test");
            Statement monStatement = maConnection.createStatement(); 
            
            ResultSet monResult = monStatement.executeQuery("SELECT * from client where ID_CLIENT = " + ID); 
            
                        
            while(monResult.next()){
                System.out.println(monResult);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null; 
    }
    
    
}
