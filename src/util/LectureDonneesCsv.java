package util;

import au.com.bytecode.opencsv.CSVReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import metier.modele.Circuit;
import metier.modele.Client;
import metier.modele.Conseiller;
import metier.modele.Depart;
import metier.modele.Pays;
import metier.modele.Sejour;
import metier.modele.Voyage;
import metier.service.Service;

/**
 * La classe LectureDonneesCsv permet (comme son nom l'indique) la lecture de données CSV
 * dans des fichiers. Elle doit être complétée et personnalisée pour interagir avec VOTRE couche
 * service pour la création effective des entités. Elle comprend initialement la lecture d'un fichier
 * Clients et d'un fichier Pays. Une méthode {@link main()} permet de tester cette classe avant de
 * l'intégrer dans le reste de votre code.
 * @author Équipe DASI - 2013/2014
 */

public class LectureDonneesCsv {

    /**
     * Format de date pour la lecture des dates dans les fichiers CSV fournis.
     */
    protected static DateFormat CSV_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    
    /**
     * Format de date pour l'affichage à l'écran.
     */
    protected static DateFormat USER_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    
    /**
     * Le lecteur de fichier CSV.
     * Il doit être initialisé avant l'appel aux méthodes de la classe.
     */
    protected CSVReader lecteurFichier;

    /**
     * Unique constructeur de la classe. Le fichier CSV donné en paramètre doit
     * avoir le point-virgule ';' comme séparateur et être encodé en UTF-8. Le fichier est
     * immédiatement ouvert (en lecture) par ce constructeur.
     * @param cheminVersFichier Chemin vers le fichier CSV.
     * @throws FileNotFoundException Si le chemin vers le fichier n'est pas valide ou le fichier non-lisible.
     */
    public LectureDonneesCsv(String cheminVersFichier) throws FileNotFoundException, UnsupportedEncodingException {

        this.lecteurFichier = new CSVReader(new InputStreamReader(new FileInputStream(cheminVersFichier), "UTF-8"), ';');
    }
    
    /**
     * Ferme le fichier CSV. Les autres méthodes ne doivent plus être appelées après cela.
     * @throws IOException 
     */
    public void fermer() throws IOException {

        this.lecteurFichier.close();
    }

    /**
     * Méthode statique pour lire une date à partir d'une chaîne de caractère.
     * Adapté au format de date des fichiers CSV fournis, par exemple: 2014-02-01.
     * @param date Chaîne de caractère représentant la date.
     * @return La date interpétée ou la date actuelle en cas mauvais format en entrée.
     */
    protected static Date parseDate(String date) {
        try {
            return CSV_DATE_FORMAT.parse(date);
        } catch (ParseException ex) {
            return new Date();
        }
    }
    
    /**
     * Méthode statique pour formater une date pour l'affichage.
     * Par exemple: 01/02/2014.
     * @param date Date à formater.
     * @return Chaîne de caractère représentant la date.
     */
    protected static String formatDate(Date date) {
        return USER_DATE_FORMAT.format(date);
    }

    /**
     * Méthode statique pour afficher l'en-tête d'un fichier CSV lu par le lecteur.
     * L'affichage se fait sur la "sortie d'erreur" (en rouge dans la console sous Netbeans).
     * Le nom des colonnes est précédé de leur index dans le tableau (commençant à 0).
     * @param colonnes le tableau des noms de colonnes.
     */
    protected static void afficherEnTeteCsv(String[] colonnes) {
        
        for (int i=0; i<colonnes.length; i++) {
            if (i>0) {
                System.err.print("; " );
            }
            System.err.print("#" + Integer.toString(i) + " => " + colonnes[i] );
        }
        System.err.println();
    }
    
    /**
     * Lit le fichier CSV, affiche son en-tête, puis appelle la création de Client pour chaque ligne.
     * @param limite Nombre maximum de lignes à lire ou -1 pour ne pas limiter
     * @throws IOException 
     */
    public void lireClients(int limite) throws IOException {

        String[] nextLine;

         // En-tete du fichier CSV
        nextLine = this.lecteurFichier.readNext();
        afficherEnTeteCsv(nextLine);
        
        
        // Lecture des lignes
        while ((nextLine = this.lecteurFichier.readNext()) != null) {
        
            creerClient(nextLine);
            
            // Limite (ou -1 si pas de limite)
            if ( !(limite < 0) && (--limite < 1) ) {
                break;
            }
        }

    }
    
    /**
     * Créée un Client à partir de sa description.
     * La date de naissance est notamment interpétée comme un objet Date.
     * @param descriptionClient Ligne du fichier CSV de Clients.
     */
    public void creerClient(String[] descriptionClient) {
        
        String civilite = descriptionClient[0];
        String nom = descriptionClient[1];
        String prenom = descriptionClient[2];
        Date dateNaissance = parseDate(descriptionClient[3]);
        String adresse = descriptionClient[4];
        String telephone = descriptionClient[5];
        String email = descriptionClient[6];
        
        System.out.println("Client: "+  civilite + " " + nom + " " + prenom + ", né le " + formatDate(dateNaissance) + ", habitant à " + adresse + ", téléphone: " + telephone + ", e-mail: " + email);
        
        // À implémenter...
        Client client = new Client(civilite,nom,prenom,dateNaissance,adresse,telephone,email);
        System.out.println(client);
        Service.creerClient(client);
        
        
        
    }

    public void creerDevisAleatoirePourClient(Client c)
    {
          //Lui attribuer un Conseiller aléatoirement pour le test
        int conseillerID = Aleatoire.random(1201, 1238);
        Conseiller conseiller = Service.rechercherConseiller(conseillerID);
        
        /*
        int voyageID = Aleatoire.random(1551, 1748);
        Voyage s = Service.rechercherVoyage(voyageID);
        
        
        List<Depart> l = Service.rechercherDeparts(s.getCodeVoyage());
        
        int departID = Aleatoire.random(l.size());
        Depart d = l.get(departID);

        Date dateCreation = new Date();

        
        int nbPersonnes = Aleatoire.random(2,5);
        
        
        
        Devis d = new Devis(); 
        */
     
    }
    /**
     * Lit le fichier CSV, affiche son en-tête, puis appelle la création de Pays pour chaque ligne.
     * @param limite Nombre maximum de lignes à lire ou -1 pour ne pas limiter
     * @throws IOException 
     */
    public void lirePays(int limite) throws IOException {

        String[] nextLine;

         // En-tete du fichier CSV
        nextLine = this.lecteurFichier.readNext();
        afficherEnTeteCsv(nextLine);
        
        
        // Lecture des lignes
        while ((nextLine = this.lecteurFichier.readNext()) != null) {
        
            creerPays(nextLine);
            
            // Limite (ou -1 si pas de limite)
            if ( !(limite < 0) && (--limite < 1) ) {
                break;
            }
        }

    }
    
    /**
     * Créée un Pays à partir de sa description.
     * La superficie et la population sont notamment interpétées comme des nombres.
     * @param descriptionClient Ligne du fichier CSV de Pays.
     */
    public void creerPays(String[] descriptionPays) {
        
        String nom = descriptionPays[0];
        String code = descriptionPays[1];
        String region = descriptionPays[2];
        String capitale = descriptionPays[3];
        String langues = descriptionPays[4];
        Float superficie = Float.parseFloat(descriptionPays[5]);
        Float population = Float.parseFloat(descriptionPays[6]);
        String regime = descriptionPays[7];
        
        
        // À implémenter...
        Pays pays = new Pays(nom,code,region,capitale,langues,superficie,population,regime);
        System.out.println(pays);
        Service.creerPays(pays);
        
    }
    
     /**
     * Lit le fichier CSV, affiche son en-tête, puis appelle la création de Pays pour chaque ligne.
     * @param limite Nombre maximum de lignes à lire ou -1 pour ne pas limiter
     * @throws IOException 
     */
    public void lireDeparts(int limite) throws IOException {

        String[] nextLine;

         // En-tete du fichier CSV
        nextLine = this.lecteurFichier.readNext();
        afficherEnTeteCsv(nextLine);
        
        
        // Lecture des lignes
        while ((nextLine = this.lecteurFichier.readNext()) != null) {
        
            creerDepart(nextLine);
            
            // Limite (ou -1 si pas de limite)
            if ( !(limite < 0) && (--limite < 1) ) {
                break;
            }
        }

    }
    
    /**
     * Créée un Pays à partir de sa description.
     * La superficie et la population sont notamment interpétées comme des nombres.
     * @param descriptionClient Ligne du fichier CSV de Pays.
     */
    public void creerDepart(String[] descriptionDepart) {
        
        String codeVoyage = descriptionDepart[0];
        Date dateDepart = parseDate(descriptionDepart[1]);
        String villeDepart = descriptionDepart[2];
        Integer tarif = Integer.parseInt(descriptionDepart[3]);
        String transport = descriptionDepart[4];
        
        
        // À implémenter...
        Depart pays = new Depart(codeVoyage,dateDepart,villeDepart,tarif,transport);
        System.out.println(pays);
        Service.creerDepart(pays);
        
    }
    
    
     /**
     * Lit le fichier CSV, affiche son en-tête, puis appelle la création de Conseiller pour chaque ligne.
     * @param limite Nombre maximum de lignes à lire ou -1 pour ne pas limiter
     * @throws IOException 
     */
    public void lireConseillers(int limite) throws IOException {
        String[] nextLine;

         // En-tete du fichier CSV
        nextLine = this.lecteurFichier.readNext();
        afficherEnTeteCsv(nextLine);
        
        
        // Lecture des lignes
        while ((nextLine = this.lecteurFichier.readNext()) != null) {
        
            creerConseiller(nextLine);
            
            // Limite (ou -1 si pas de limite)
            if ( !(limite < 0) && (--limite < 1) ) {
                break;
            }
        }

    }
        
    /**
     * Créée un Conseiller à partir de sa description.
     * La superficie et la population sont notamment interpétées comme des nombres.
     * @param descriptionConseiller Ligne du fichier CSV de Pays.
    */
    public void creerConseiller(String[] descriptionConseiller){
                    
        String civilite = descriptionConseiller[0];
        String nom = descriptionConseiller[1];
        String prenom = descriptionConseiller[2];
        Date dateNaissance = parseDate(descriptionConseiller[3]);
        String adresse = descriptionConseiller[4];
        String telephone = descriptionConseiller[5];
        String email = descriptionConseiller[6];
        
        
        Conseiller conseiller = new Conseiller(civilite,nom,prenom,dateNaissance,adresse,telephone,email); 
        
        for(int i=7 ; i <descriptionConseiller.length; i++){
            String codePays = descriptionConseiller[i];
            Pays pays = Service.rechercherPaysParCode(codePays);
            conseiller.ajouterPaysSpecialisation(pays);
        }
        
        
       
        System.out.println(conseiller);
        Service.creerConseiller(conseiller);
     }
        
  
        
        
        
        
  /**
     * Lit le fichier CSV, affiche son en-tête, puis appelle la création de Sejour pour chaque ligne.
     * @param limite Nombre maximum de lignes à lire ou -1 pour ne pas limiter
     * @throws IOException 
     */
    public void lireSejours(int limite) throws IOException {
        String[] nextLine;

         // En-tete du fichier CSV
        nextLine = this.lecteurFichier.readNext();
        afficherEnTeteCsv(nextLine);
        
        
        // Lecture des lignes
        while ((nextLine = this.lecteurFichier.readNext()) != null) {
        
            creerSejour(nextLine);
            
            // Limite (ou -1 si pas de limite)
            if ( !(limite < 0) && (--limite < 1) ) {
                break;
            }
        }

    }
    
    
    
          
    /**
     * Créée un Sejour à partir de sa description.
     * La superficie et la population sont notamment interpétées comme des nombres.
     * @param descriptionSejour Ligne du fichier CSV de Pays.
    */
    public void creerSejour(String[] descriptionSejour){
                    
        String codePays = descriptionSejour[0];
        String codeVoyage = descriptionSejour[1];
        String intitule = descriptionSejour[2];
        Integer duree = Integer.parseInt(descriptionSejour[3]);
        String description = descriptionSejour[4];
        String residence = descriptionSejour[5];
        
        
        Pays pays = Service.rechercherPaysParCode(codePays);
        List<Depart> l = Service.rechercherDeparts(codeVoyage);

        
        Sejour sejour = new Sejour(residence,codeVoyage,intitule,duree,description);
        sejour.ajouterPaysVoyage(pays);
        sejour.setListeDeparts(l);
        System.out.println(sejour);
        Service.creerVoyage(sejour);
     }
        
    
    
     /**
     * Lit le fichier CSV, affiche son en-tête, puis appelle la création de Circuit pour chaque ligne.
     * @param limite Nombre maximum de lignes à lire ou -1 pour ne pas limiter
     * @throws IOException 
     */
    public void lireCircuits(int limite) throws IOException {
        String[] nextLine;

         // En-tete du fichier CSV
        nextLine = this.lecteurFichier.readNext();
        afficherEnTeteCsv(nextLine);
        
        
        // Lecture des lignes
        while ((nextLine = this.lecteurFichier.readNext()) != null) {
        
            creerCircuit(nextLine);
            
            // Limite (ou -1 si pas de limite)
            if ( !(limite < 0) && (--limite < 1) ) {
                break;
            }
        }

    }
    
    
    
          
    /**
     * Créée un Circuit à partir de sa description.
     * La superficie et la population sont notamment interpétées comme des nombres.
     * @param descriptionSejour Ligne du fichier CSV de Pays.
    */
    public void creerCircuit(String[] descriptionCircuit){
                    
        String codePays = descriptionCircuit[0];
        String codeVoyage = descriptionCircuit[1];
        String intitule = descriptionCircuit[2];
        Integer duree = Integer.parseInt(descriptionCircuit[3]);
        String description = descriptionCircuit[4];
        String transport = descriptionCircuit[5];
        Integer nbKms = Integer.parseInt(descriptionCircuit[6]);

        
        
        Pays pays = Service.rechercherPaysParCode(codePays);
        List<Depart> l = Service.rechercherDeparts(codeVoyage);
        
        Circuit circuit = new Circuit(transport,nbKms,codeVoyage,intitule,duree,description);
        circuit.ajouterPaysVoyage(pays);
        circuit.setListeDeparts(l);
        System.out.println(circuit);
        Service.creerVoyage(circuit);
     }
        
    
    /**
     * Cette méthode main() permet de tester cette classe avant de l'intégrer dans votre code.
     * Elle exploite initialement un fichier de Client et un fichier de Pays, en limitant la lecture aux
     * 10 premiers éléments de chaque fichier.
     * @param args non utilisé ici
     */
}
