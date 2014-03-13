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
import dao.PartenaireCommercialDAO;
import dao.VoyageDAO;
import java.util.List;
import metier.modele.Conseiller;
import metier.modele.Client;
import metier.modele.Depart;
import metier.modele.Pays;
import metier.modele.Devis;
import metier.modele.PartenaireCommercial;
import metier.modele.Voyage;
import util.Aleatoire;

/**
 *
 * @author Mehdi
 */
public class Service {
    //-----------------------------Methodes Relatives aux Clients-------------------------------//

    /**
     * 
     * Methode statique qui fait persister un client dans la base de donnée
     * @param c Client a creer
     * 
     */
    public static void creerClient(Client c){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       ClientDAO.persist(c);
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
    }
    
    public static void updateClient(Client c){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       ClientDAO.merge(c);
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
    }
    
    
    /**
     * Methode statique qui recherche un Client grace a son identifiant
     * @param ID Identifiant dans la base de donnée
     * @return Client trouvé
     */
    public static Client rechercherClientParID(int ID){
        
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       Client c = ClientDAO.rechercherParID(ID);
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
       return c; 
    }
    
    /**
     * Methode statique qui recherche un Client grace a son adresse email
     * @param email adresse email 
     * @return Client trouvé
     */
    public static Client rechercherClientParEmail(String email){
        JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       Client c = ClientDAO.rechercherParEmail(email);
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
       return c; 
    }
    
    /**
     * Methode statique qui renvoie tous les clients contenus dans la base de donnée
     * @return Liste des clients
     */
    public static List<Client> obtenirClients(){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       List<Client> l = ClientDAO.obtenirClients();
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
       return l; 
    }
    
    //-----------------------------Methodes Relatives aux Sejours et circuit-------------------------------//
    /**
     * 
     * Methode statique qui fait persister un voyage dans la base de donnée
     * @param s Voyage a creer
     * 
     */
    public static void creerVoyage(Voyage s){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       VoyageDAO.persist(s);
       //ajouter depart
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
    }
    
    
  
    /**
     * Methode statique qui recherche un Voyage grace a son identifiant
     * @param ID Identifiant dans la base de donnée
     * @return Voyage trouvé
     */
    public static Voyage rechercherVoyage(int ID){
        
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       Voyage v = VoyageDAO.rechercherParCode(ID);
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
       return v; 
    }
    
    /**
     * Methode statique qui renvoie un Voyage en fonction du codeVoyage correspondant
     * @param codeVoyage  Code voyage correspondant au Voyage recherché
     * @return Voyage trouvé
     */
    public static Voyage rechercherVoyage(String codeVoyage){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       Voyage v = VoyageDAO.rechercherVoyageParCodeVoyage(codeVoyage);
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
       return v; 
    }
    
    /**
     * Methode statique qui renvoie la liste de tous les voyages
     * @return Liste de tous les voyages trouvés
     */
     public static List<Voyage> obtenirVoyages(){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       List<Voyage> l = VoyageDAO.obtenirVoyages();
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
       return l; 
     }
     
     /**
      * Methode statique qui renvoie tous les circuits ou tous les sejours
      * @param circuit Boolean qui permet de savoir si on renvoie les circuits ou les sejours
      * @return Liste des circuits si circuit = true et Liste des sejours si circuit = false
      */
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
     
     /**
      * Methode statique qui renvoie la liste de tous les voyages dans le pays recherché
      * (Pratique pour l'IHM et la recherche par pays)
      * @param p Pays dont on veux obtenir les voyages correspondants
      * @return Voyages renvoyes
      */
     public static List<Voyage> obtenirVoyages(Pays p){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       List<Voyage> v = VoyageDAO.rechercherVoyageParPays(p);
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
       return v; 
    }
    //-----------------------------Methodes Relatives aux Pays-------------------------------//

     /**
     * 
     * Methode statique qui fait persister un pays dans la base de donnée
     * @param p Pays a creer
     * 
     */
    public static void creerPays(Pays p){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       PaysDAO.persist(p);
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
    }
     
    /**
     * Methode statique qui recherche un Pays par son nom
     * @param nom nom du pays recherché
     * @return pays trouvé
     */
    public static Pays rechercherPaysParNom(String nom){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       Pays p = PaysDAO.rechercherParNom(nom);
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
       return p; 
    }
    
     /**
     * Methode statique qui recherche un Pays par son code Pays
     * @param nom code (3lettres) du pays recherché
     * @return pays trouvé
     */
     public static Pays rechercherPaysParCode(String codePays){
        
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       Pays p = PaysDAO.rechercherParCode(codePays);
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
       return p; 
    }
    
    /**
     * Methode statique qui renvoie tous les pays contenus dans la base de donnée
     * @return Liste de tous les pays
     */
    public static List<Pays> obtenirPays(){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       List<Pays> l = PaysDAO.obtenirPays();
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
       return l; 
    }


    //-----------------------------Methodes Relatives aux Departs-------------------------------//
     /**
     * 
     * Methode statique qui fait persister un Depart dans la base de donnée
     * @param c Depart a creer
     * 
     */
    public static void creerDepart(Depart c){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       DepartDAO.persist(c);
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
    }
    
    
    /**
     * Methode statique qui recherche les départs relatifs a un voyage
     * @param codeVoyage code du voyage a rechercher
     * @return Liste des départs qui correspondent a ce voyage
     */
    public static List<Depart> rechercherDeparts(String codeVoyage){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       
       List<Depart> l = DepartDAO.rechercherParCode(codeVoyage);

              
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
       return l; 
    }
    
    /**
     * Methode statique qui recherche le Depart ayant le plus petit prix parmis les départs d'un voyage
     * @param codeVoyage code voyage du pays
     * @return Depart ayant le plus petit prix
     */
    public static Depart rechercherDepartPetitPrix(String codeVoyage)
    {
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       List<Depart> listDepart = DepartDAO.rechercherParCode(codeVoyage);
       
        Depart departMin;
       if(listDepart.size() > 0){
             departMin = listDepart.get(0);
       }else{
            departMin = null;
       }
       for(Depart d : listDepart){
           if(d.getTarif() < departMin.getTarif()){
               departMin = d; 
           }
       }
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
       
       return departMin; 
    }
    
    /**
     * Methode statique qui renvoit tous les départs contenus dans la base de donnée
     * @return Liste de tous les départs contenus dans la base de donnée
     */
    public static List<Depart> obtenirDeparts(){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       List<Depart> l = DepartDAO.obtenirDeparts();

       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
       return l; 
    }
    ////-----------------------------Methodes Relatives aux Conseillers-------------------------------//

     /**
     * 
     * Methode statique qui fait persister un conseiller dans la base de donnée
     * @param c Conseiller a creer
     * 
     */
    public static void creerConseiller(Conseiller c){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       //ajouter pays et ajouter 
       ConseillerDAO.persist(c);
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();

    }
    
    /**
     * Methode statique qui met a jour un conseiller dans la base de donnée
     * @param c Conseiller à mettre a jour
     */
     public static void updateConseiller(Conseiller c){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       ConseillerDAO.merge(c);
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
    }
    
     /**
     * Methode statique qui recherche un Conseiller grace a son identifiant
     * @param ID Identifiant dans la base de donnée
     * @return Conseiller trouvé
     */
    public static Conseiller rechercherConseiller(int ID){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       Conseiller c = ConseillerDAO.rechercherParID(ID);
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
       return c; 
    }
    
    /**
     * Methode qui recherche les conseillers affectés à un pays particulier
     * @param p Pays dont on cherche les conseillers
     * @return Liste des conseillers affectés à un pays particulier
     */
    public static List<Conseiller> rechercherConseiller(Pays p){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       List<Conseiller> c = ConseillerDAO.rechercherParPays(p);
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
       return c; 
    }
    
    /**
     * Methode statique qui renvoie tous les conseillers contenus dans la base de donnée
     * @return Liste des conseillers 
     */
    public static List<Conseiller> obtenirConseillers(){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       List<Conseiller> l = ConseillerDAO.obtenirConseillers();

       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
       return l;    
    }
    
    /**
     * Methode statique qui permet de rechercher le conseiller le mieux adapté pour un client a partir du voyage qu'il veut faire
     * On choisit toujours le conseiller le moins surbooké pour répartir au mieux les clients.
     * @param c Client 
     * @param v Voyage pour lequel on recherche le conseiller
     * @return Conseiller adapté
     */
    public static Conseiller rechercherConseillerPourVoyage(Voyage v){       
       Conseiller conseiller = null; 
       
       String codeVoyage = v.getCodeVoyage();
       
       
       //on regarde un conseiller qui peut le conseiller sur ce pays
            List<Conseiller> l = Service.rechercherConseiller(v.getPaysVoyage());
            
            
            //Sinon on en prend aléatoirement, Si il n'y a pas de conseiller pour ce pays
             if(l.size() == 0){
                int conseillerID = Aleatoire.random(l.size());
                conseiller = l.get(conseillerID); 
                return conseiller; 
             }
             
            conseiller = l.get(0);
            for(Conseiller conseillerListe : l){
               if(conseillerListe.getListeClients().size() < conseiller.getListeClients().size()){
                   conseiller = conseillerListe;
                }
             }
       
            
       return conseiller;
    }
    
    ////----------------------Methodes Relatives aux Partenaires Commerciaux---------------------//
     /**
     * 
     * Methode statique qui fait persister un PartenaireCommercial dans la base de donnée
     * @param d PartenaireCommercial a creer
     * 
     */
        public static void creerPartenaireCommercial(PartenaireCommercial d){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       PartenaireCommercialDAO.persist(d);
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
    }

    /**
     * Methode statique qui renvoie la liste de tous les partenaires commerciaux enregistrés 
     * (utile si le client accepte d’être alerté).
     * @return Liste des partenaires commerciaux
     */
    public static List<PartenaireCommercial> obtenirPartenaireCommerciaux(){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       List<PartenaireCommercial> l = PartenaireCommercialDAO.obtenirPartenaireCommerciaux();

       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
       
       return l;
    }
    
    ////-----------------------------Methodes Relatives aux Devis-------------------------------//
    /**
     * 
     * Methode statique qui fait persister un devis dans la base de donnée
     * @param d Devis a creer
     * 
     */
    public static void creerDevis(Devis d){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       DevisDAO.persist(d);
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
    }


    /**
     * Methode qui permet d'obtenir tous les devis contenus dans la base de donnée
     * @return Liste des devis
     */
    public static List<Devis> obtenirDevis(){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       List<Devis> l = DevisDAO.obtenirDevis();

       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
       
       return l;
    }
    
    /**
     * Methode qui permet de rechercher les devis relatifs a un client
     * @param c Client dont on recherche les Devis
     * @return Liste des devis
     */
      public static List<Devis> rechercherDevis(Client c){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       List<Devis> l = DevisDAO.rechercherDevis(c);

       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
       
       return l;
    }
      
    /**
     * Methode qui simule l'envoi d'un mail a un client 
     * @param c Client a qui envoyer le mail
     */
    public static void envoyerMail(Client c){
        for(PartenaireCommercial pC : Service.obtenirPartenaireCommerciaux()){
            String s = "Expediteur : ifroutard@ifroutard.com \n";
            s += "Pour : " + pC.getEmail() + "\n" ; 
            s += "Sujet : nouveau client \n";
            s += "Corps : \n";
            s += "nom : " + c.getNom().toUpperCase() + "\n";
            s += "prenom : " + c.getPrenom() +"\n"; 
            s += "adresse mail : " + c.getEmail() +"\n";
        
            System.out.println(s);
        }
    }
}

