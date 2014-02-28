/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.modele;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.*;
        
/**
 *
 * @author Mehdi
 */
@Entity
public class Client {
   
    @Id   
    @Column(name = "ID_CLIENT")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID; 
    
    private String civilite; 
    private String nom; 
    private String prenom; 
    
    @Temporal(TemporalType.DATE)
    private Date dateNaissance; 
    
    private String adresse; 
    private String telephone; 
    private String email; 
    private boolean accepte; 
    private ArrayList<Conseiller> listeConseiller = new ArrayList<Conseiller>();
    public Client() {
        
    }
    
    public Client( String civilite, String nom, String prenom, Date date, String adressePostale,String telephone,String adresseElectronique,boolean accepte){
        this.nom = nom; 
        this.prenom = prenom;
        this.civilite=civilite;
        this.dateNaissance=date;
        this.telephone=telephone;
        this.accepte=accepte;
        this.adresse=adressePostale;
        this.email=adresseElectronique;
    }
    
    
    public String toString(){
        return ("Client: "+  civilite + " " + nom + " " + prenom + ", né le " + dateNaissance + ", habitant à " + adresse + ", téléphone: " + telephone + ", e-mail: " + email);
    }
    
    public void AjoutConseiller(Conseiller c){
        
        listeConseiller.add(c);
    }

       
    public int getID() {
        return ID;
    }

    public String getCivilite() {
        return civilite;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAccepte() {
        return accepte;
    }

    
    

  
}
