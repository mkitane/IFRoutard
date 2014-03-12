/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.service;

import dao.ConseillerDAO;
import dao.ClientDAO;
import dao.DepartDAO;
import dao.JpaUtil;
import dao.PaysDAO;
import dao.DevisDAO;
import dao.VoyageDAO;
import java.util.List;
import metier.modele.Conseiller;
import metier.modele.Circuit;
import metier.modele.Client;
import metier.modele.Depart;
import metier.modele.Pays;
import metier.modele.Sejour;
import metier.modele.Devis;
import metier.modele.Voyage;

/**
 *
 * @author Mehdi
 */
public class Service {
    //-----------------------------Methodes Relatives aux Clients-------------------------------//

    public static void creerClient(Client c){
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
    
    //-----------------------------Methodes Relatives aux Sejours et circuit-------------------------------//

    public static void creerVoyage(Voyage s){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       VoyageDAO.persist(s);
       //ajouter depart
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
    }
    
    public static Voyage rechercherVoyage(int ID){
        
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       Voyage v = VoyageDAO.rechercherParCode(ID);
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
       return v; 
    }
     public static List<Voyage> obtenirVoyages(){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       List<Voyage> l = VoyageDAO.obtenirVoyages();
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
       return l; 
     }
     
     public static List<Voyage> obtenirVoyages(boolean circuit){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       
       List<Voyage> l;
        
       if(circuit){
           l= VoyageDAO.obtenirCircuits();
       }else{
           l= VoyageDAO.obtenirSejours();
       }
       
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
       return l; 
     }
     
    //-----------------------------Methodes Relatives aux Pays-------------------------------//

    public static void creerPays(Pays c){
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
    
    public static List<Pays> creerPays(){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       List<Pays> l = PaysDAO.obtenirPays();
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
       return l; 
    }


    //-----------------------------Methodes Relatives aux Departs-------------------------------//
    public static void creerDepart(Depart c){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       DepartDAO.persist(c);
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
    }
    
    public static List<Depart> rechercherDeparts(String codeVoyage){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       
       List<Depart> l = DepartDAO.rechercherParCode(codeVoyage);

              
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
       return l; 
    }
    
    public static List<Depart> obtenirDeparts(){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       List<Depart> l = DepartDAO.obtenirDeparts();

       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
       return l; 
    }
    ////-----------------------------Methodes Relatives aux onseillers-------------------------------//

    public static void creerConseiller(Conseiller c){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       //ajouter pays et ajouter 
       ConseillerDAO.persist(c);
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();

    }
    
    public static Conseiller rechercherConseiller(int ID){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       Conseiller c = ConseillerDAO.rechercherParID(ID);
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
       return c; 
    }
    
    public static List<Conseiller> obtenirConseillers(){
         JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       List<Conseiller> l = ConseillerDAO.obtenirConseillers();

       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
       return l;    
    }
    ////-----------------------------Methodes Relatives aux Devis-------------------------------//

    public static void creerDevis(Devis d){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       DevisDAO.persist(d);
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
    }


    
    public static int calculerPrix(Devis d){
        int prix = d.getNbPersonnes() * d.getConditionsDepart().getTarif(); 
        return prix; 
    }
    public static void envoyerMails(){
        
    }
}

