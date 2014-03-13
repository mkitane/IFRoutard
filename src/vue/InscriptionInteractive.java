/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

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
import metier.modele.Voyage;
import metier.service.Service;
import util.Saisie;

/**
 *
 * @author Mehdi
 */
public class InscriptionInteractive {
    
    public InscriptionInteractive(){
        
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
    
    
        Client client = new Client(stringCivilite,nom,prenom,dateDeNaissance,adresse,telephone,email);
        Service.creerClient(client);
        System.out.println("Le client ajoute est : " + client);
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
       

       
       afficher = "Veuillez choisir un conseiller \n\n"; 
       List<Conseiller> listConseiller = Service.rechercherConseiller(voyage.getPaysVoyage());
       for(int i=0; i<listConseiller.size(); i++){
            afficher = afficher  + "n° : " + i + "  nom :  " + listConseiller.get(i).getNom()+ "\n"; 
        }
       Integer conseillerChoisi = Saisie.lireInteger(afficher);
       Conseiller conseiller = listConseiller.get(conseillerChoisi);
       
               
       
       Devis d = new Devis(depart,voyage,conseiller,client,dateCreation,nbPersonnes); 
       
       
       Service.creerDevis(d);
       System.out.println(d);
       
       
       client.AjoutConseiller(conseiller); //A faire ? 
       
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
