/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.service;

import dao.CircuitDAO;
import dao.ClientDAO;
import dao.JpaUtil;
import dao.PaysDAO;
import dao.SejourDAO;
import java.util.List;
import metier.modele.Circuit;
import metier.modele.Client;
import metier.modele.Pays;
import metier.modele.Sejour;

/**
 *
 * @author Mehdi
 */
public class Service {

    public static void ajouterClient(Client c){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       ClientDAO.persist(c);
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
    }
    
    
    public static Client rechercherClientParID(int ID){
        
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       Client c = ClientDAO.rechercherParID(ID);
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
       return c; 
    }
    
    public static List<Client> obtenirClients(){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       List<Client> l = ClientDAO.obtenirClients();
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
       return l; 
    }
    
    
    public static void ajouterSejour(Sejour s){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       SejourDAO.persist(s);
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
    }
    
     public static void ajouterCircuit(Circuit c){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       CircuitDAO.persist(c);
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
    }
     
    public static void ajouterPays(Pays c){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       PaysDAO.persist(c);
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
    }
     
     
}
