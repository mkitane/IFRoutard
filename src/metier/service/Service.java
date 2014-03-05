/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.service;

import dao.ConseillerDAO;
import dao.CircuitDAO;
import dao.ClientDAO;
import dao.DepartDAO;
import dao.JpaUtil;
import dao.PaysDAO;
import dao.SejourDAO;
import java.util.List;
import metier.modele.Conseiller;
import metier.modele.Circuit;
import metier.modele.Client;
import metier.modele.Depart;
import metier.modele.Pays;
import metier.modele.Sejour;


/**
 *
 * @author Mehdi
 */
public class Service {
    //-----------------------------Methodes Relatives aux Clients-------------------------------//

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
    
    //-----------------------------Methodes Relatives aux Sejours-------------------------------//

    public static void ajouterSejour(Sejour s){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       SejourDAO.persist(s);
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
    }
    
    
     //-----------------------------Methodes Relatives aux Circuits-------------------------------//
     public static void ajouterCircuit(Circuit c){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       CircuitDAO.persist(c);
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
    }
     
    
     
     
    //-----------------------------Methodes Relatives aux Pays-------------------------------//

    public static void ajouterPays(Pays c){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       PaysDAO.persist(c);
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
    }
     
    
     public static Pays rechercherPaysParCode(String codePays){
        
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       Pays p = PaysDAO.rechercherParCode(codePays);
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
       return p; 
    }
    
    public static List<Pays> obtenirPays(){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       List<Pays> l = PaysDAO.obtenirPays();
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
       return l; 
    }
    
    
    //-----------------------------Methodes Relatives aux Departs-------------------------------//
    public static void ajouterDepart(Depart c){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       DepartDAO.persist(c);
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
    }
    
    ////-----------------------------Methodes Relatives aux onseillers-------------------------------//

    public static void ajouterConseiller(Conseiller c){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       ConseillerDAO.persist(c);
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();

    }
    
    
}

