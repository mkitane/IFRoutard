/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import metier.modele.Devis;
import metier.modele.Circuit;
import metier.modele.Client;
import metier.modele.Conseiller;
import metier.modele.Depart;
import metier.modele.Pays;
import metier.modele.Sejour;
import metier.service.Service;
import metier.modele.Voyage;
import util.LectureDonneesCsv;



/**
 *
 * @author Mehdi
 */
public class Main {
    public static void main(String[] args) {

        
       /*
       Date d = new Date();
       
       Client e = new Client(); 
       Client a = new Client( "mr","escure", "thomas", d, "france","06","monmail",true,"mdp"); 
       Client c = new Client( "mr","kitane", "mehdi", d, "france","06","monmail",true,"mdp"); 
       
       
       Service.creerClient(e);
       Service.creerClient(a);
       Service.creerClient(c);

       System.out.println(Service.rechercherClientParID(2));
   
        List<Client> l = Service.obtenirClients();
        for(int i=0; i < l.size(); i++){
            System.out.println(l.get(i));
        }
        
        
        
        Sejour s = new Sejour("1","2","4","5","6");
        Circuit s1 = new Circuit("7",8,"10","11","12","13");
        
        Service.creerSejour(s);
        Service.creerCircuit(s1);

        
        Pays p1 = new Pays("B1","B2","B3","B4","B5",23,23.3,"B6");
        Service.creerPays(p1);
        
        Depart d1 = new Depart("D1",d,"D2",23,"D3");
        Service.creerDepart(d1);
        
          
        Pays p2 = new Pays("Afrique du sud","AFR","B3","B4","B5",23,23.3,"B6");
        Service.creerPays(p2);
        Pays p3 = new Pays("Albanie","ALB","B3","B4","B5",23,23.3,"B6");
        Service.creerPays(p3);
        
        System.out.println("Le pays recherche est : " + Service.rechercherPaysParCode("AFR"));
        
        
        Conseiller a1 = new Conseiller("Mr","Kar","Ben",d,"adresse","tel","email","mdp"); 
        Service.creerConseiller(a1);
        
        
        
        Devis dev = new Devis(d1, s, a1, a, d, 3);
        Service.creerDevis(dev);
        */
       
      
        
        /*
        try {
            //String fichierClients = "/";
            //String fichierPays = "C:\\Temp\\IFRoutard-Pays.csv";
            
            String fichierPays = "/Users/Mehdi/Dropbox/Tps/DASI/data/IFRoutard-Pays.csv"; 
            String fichierDeparts = "/Users/Mehdi/Dropbox/Tps/DASI/data/IFRoutard-Departs.csv";
            String fichierConseillers = "/Users/Mehdi/Dropbox/Tps/DASI/data/IFRoutard-Conseillers.csv";
            String fichierSejours = "/Users/Mehdi/Dropbox/Tps/DASI/data/IFRoutard-Voyages-Sejours.csv";
            String fichierCircuits = "/Users/Mehdi/Dropbox/Tps/DASI/data/IFRoutard-Voyages-Circuits.csv";
            String fichierClients =  "/Users/Mehdi/Dropbox/Tps/DASI/data/IFRoutard-Clients.csv";
           
            
            
            LectureDonneesCsv lectureDonneesCsv_Pays = new LectureDonneesCsv(fichierPays);
            
            lectureDonneesCsv_Pays.lirePays(-1);
            
            lectureDonneesCsv_Pays.fermer();
            
                        
            LectureDonneesCsv lectureDonneesCsv_Departs = new LectureDonneesCsv(fichierDeparts);
            
            lectureDonneesCsv_Departs.lireDeparts(-1);
            
            lectureDonneesCsv_Departs.fermer();
            
          
            LectureDonneesCsv lectureDonneesCsv_Conseillers = new LectureDonneesCsv(fichierConseillers);
            
            lectureDonneesCsv_Conseillers.lireConseillers(-1);
            
            lectureDonneesCsv_Conseillers.fermer();
          
          
            LectureDonneesCsv lectureDonneesCsv_Sejours = new LectureDonneesCsv(fichierSejours);
            
            lectureDonneesCsv_Sejours.lireSejours(-1);
            
            lectureDonneesCsv_Sejours.fermer();
              
            
            
            LectureDonneesCsv lectureDonneesCsv_Circuits = new LectureDonneesCsv(fichierCircuits);
            
            lectureDonneesCsv_Circuits.lireCircuits(-1);
            
            lectureDonneesCsv_Circuits.fermer();
            
            
            //System.out.println(Service.rechercherVoyage(2897));

            
            
            LectureDonneesCsv lectureDonneesCsv_Clients = new LectureDonneesCsv(fichierClients);
            
            lectureDonneesCsv_Clients.lireClients(300);
            
            lectureDonneesCsv_Clients.fermer();
            
            
           
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
        */
        
      
        /*
        List<Devis> l = Service.obtenirDevis();
        for(int i=0; i < l.size(); i++){
            System.out.println(l.get(i));
        }
        */
        
        
        //System.out.print(Service.rechercherDevis(Service.rechercherClientParID(2115)));
        
        
        InscriptionInteractive i = new InscriptionInteractive();
        i.menu();
    }
}
