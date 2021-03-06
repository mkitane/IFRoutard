/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import metier.modele.Client;
import metier.modele.Conseiller;
import metier.modele.Depart;
import metier.modele.Devis;
import metier.modele.Pays;
import metier.modele.Voyage;
import metier.service.Service;
import util.LectureDonneesCsv;
import util.Saisie;

/**
 *
 * @author Mehdi
 */
public class InscriptionInteractive {
    
    public InscriptionInteractive(){
        
    }
    
    public void menu(){
        
        boolean quitter = false; 
        
        
        while(!quitter){
             System.out.println("********************************************");
             System.out.println("Bienvenue dans le Menu de Saisie interactive");
             System.out.println("********************************************");
        
        
             List<Integer> list = new ArrayList<Integer>();
            list.add(0);
            list.add(1); 
            list.add(2);
            list.add(3);
            list.add(4);
            list.add(5);
            list.add(6);
            list.add(7);
            Integer choix = Saisie.lireInteger("0- Afficher tous les clients \n1- Creer un client \n2- Creer un devis"
                    + " \n3- Afficher tous les devis \n4- Afficher le dernier devis cree"
                    + " \n5- Afficher tous les clients avec un résumé de leur devis et leurs conseillers  \n6- Charger Donnees \n7- Quitter \n", list);

            switch(choix){
                case 0: 
                   afficherClients();
                   break;
                case 1:
                   demanderInscriptionClient();
                   break;
                case 2: 
                   demanderDevis();
                   break; 
                case 3: 
                   afficherDevis();
                   break;
                case 4:
                   afficherDernierDevis();
                   break;
                case 5:
                    afficherDevisEtClient();
                    break;
                case 6: 
                    chargerTout();
                    break;
                case 7:
                   quitter = true;
                   break;
                default:
                  break;
             }
        }
    }
    
    
    public void chargerTout(){
          try {
            //String fichierClients = "/";
            //String fichierPays = "C:\\Temp\\IFRoutard-Pays.csv";
            
            String fichierPays = "C:/Documents and Settings/Administrateur/Bureau/data/IFRoutard-Pays.csv"; 
            String fichierDeparts = "C:/Documents and Settings/Administrateur/Bureau/data/IFRoutard-Departs.csv";
            String fichierConseillers = "C:/Documents and Settings/Administrateur/Bureau/data/IFRoutard-Conseillers.csv";
            String fichierSejours = "C:/Documents and Settings/Administrateur/Bureau/data/IFRoutard-Voyages-Sejours.csv";
            String fichierCircuits = "C:/Documents and Settings/Administrateur/Bureau/data/IFRoutard-Voyages-Circuits.csv";
            String fichierClients =  "C:/Documents and Settings/Administrateur/Bureau/data/IFRoutard-Clients.csv";
           
            
            
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
            
            
            
            
            LectureDonneesCsv lectureDonneesCsv_Clients = new LectureDonneesCsv(fichierClients);
            
            lectureDonneesCsv_Clients.lireClients(-1);
            
            lectureDonneesCsv_Clients.fermer();
            
            
           
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }
    public void afficherDevisEtClient(){
        List<Devis> list= Service.obtenirDevis();
        for(Devis d : list){
            Client c = d.getClient();
            List<Conseiller> listConseiller = c.getListeConseiller();
            
            System.out.println(d);
            System.out.println("Pour ce devis le client est " + c);
            System.out.print("Sa liste de conseiller est : \n    ");
            for(Conseiller cons : listConseiller){
                System.out.print(cons + "\n    Liste pays : ");
                for(Pays p : cons.getPaysSpecialisation()){
                    System.out.print(p.getCode() + " ");
                }
            }
            System.out.println();
        }
    }
    public void afficherClients(){
        List<Client> list = Service.obtenirClients();
        for(Client c : list){
            System.out.println(c);
        }
    }
    
    public void afficherDevis()
    {
        List<Devis> list = Service.obtenirDevis();
        for(Devis d : list){
            System.out.println();
            System.out.println(d);
            System.out.println();
        }
    }
    public void afficherDernierDevis()
    {
        List<Devis> list = Service.obtenirDevis();
        System.out.println(list.get(list.size()-1));
    }
    public void demanderInscriptionClient(){
        System.out.println("**********************************************");
        System.out.println("Bienvenue dans le menu de création d'un client");
        System.out.println("**********************************************");

        List<Integer> list = new ArrayList<Integer>();
        list.add(1); 
        list.add(2);
               
        Integer iCivilite = Saisie.lireInteger("1- Monsieur \n2- Madame\n", list);
        String stringCivilite; 
        if(iCivilite==1){
            stringCivilite = "M.";
        }else{
            stringCivilite = "Mme";
        }
        
        String nom = Saisie.lireChaine("Votre nom \n") ;
        String prenom = Saisie.lireChaine("Votre prenom \n");
        String stringDateDeNaissance = Saisie.lireChaine("Votre date de naissance \n      Format : dd/mm/yyyy \n"); 
        Date dateDeNaissance = parseDate(stringDateDeNaissance); 
        String adresse = Saisie.lireChaine("Votre adresse postale \n") ;
        String telephone = Saisie.lireChaine("Votre telephone \n") ;
        String email = Saisie.lireChaine("Votre email \n");   
    
       Integer acceptez = Saisie.lireInteger("Acceptez vous de recevoir des mails? 1- Oui, 2-Non\n", list);
        boolean accepte; 
        if(iCivilite==1){
            accepte  = true;
        }else{
            accepte  = false;
        }
    
        Client client = new Client(stringCivilite,nom,prenom,dateDeNaissance,adresse,telephone,email);
        client.setAccepte(accepte);
        Service.creerClient(client);
        System.out.println("Le client ajoute est : " + client);
        
        
        if(accepte){
            Service.envoyerMail(client);
        }
    }
    
    public void demanderDevis(){
        
        System.out.println("**********************************************");
        System.out.println("Bienvenue dans le menu de création d'un devis");
        System.out.println("**********************************************");
        
        String emailClient = Saisie.lireChaine("Veuillez entre votre email \n") ; 
        
        Client client = Service.rechercherClientParEmail(emailClient);
        
        
        Date dateCreation = new Date(); 
        
        Integer nbPersonnes = Saisie.lireInteger("Combien de personnes pour ce devis? \n") ; 
        
        
        
        
        List<Voyage> list = Service.obtenirVoyages();
        String afficher = "Veuillez choisir un Voyage \n\n"; 
        for(int i=0; i<20; i++){
            afficher = afficher  + "Code : " + list.get(i).getCodeVoyage() + "  Intitule :" + list.get(i).getIntitule() + "\n"; 
        }
        String codeVoyage = Saisie.lireChaine(afficher);
        Voyage voyage = Service.rechercherVoyage(codeVoyage);
        
        
        
        afficher = "Veuillez choisir un depart \n\n"; 
        List<Depart> listDepart = voyage.getListeDeparts();
        for(int i=0; i<listDepart.size(); i++){
            afficher = afficher  + "n° : " + i + "   " + listDepart.get(i) + "\n"; 
        }
         
       Integer departChoisi = Saisie.lireInteger(afficher);
       Depart depart = listDepart.get(departChoisi);
       

               
       Conseiller conseiller = Service.rechercherBonConseillerPourVoyage(voyage);
       System.out.println("Le conseiller qui vous a été attribué est : " + conseiller.getNom() + " " + conseiller.getPrenom());
       
       
       Devis d = new Devis(depart,voyage,conseiller,client,dateCreation,nbPersonnes); 
       
       
       Service.creerDevis(d);
       System.out.println(d);
       
    }
    
    
    private Date parseDate(String date){
        Date dateReturn; 
        try {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateReturn = dateFormat.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(InscriptionInteractive.class.getName()).log(Level.SEVERE, null, ex);
            dateReturn = new Date();
        }
        
        return dateReturn;
    }
}
