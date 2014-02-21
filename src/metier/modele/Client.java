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
    private Date date; 
    
    private String adressePostale; 
    private String telephone; 
    private String adresseElectronique; 
    private boolean accepte; 

    public Client() {
        
    }
    
    public Client( String civilite, String nom, String prenom, Date date, String adressePostale,String telephone,String adresseElectronique,boolean accepte){
        this.nom = nom; 
        this.prenom = prenom;
        this.civilite=civilite;
        this.date=date;
        this.telephone=telephone;
        this.accepte=accepte;
        this.adressePostale=adressePostale;
        this.adresseElectronique=adresseElectronique;
    }
    
    
    public String toString(){
        String s = "Client n" + ID + " civilite " + civilite + " Nom : " + nom + " Prenom : " + prenom + " date de naissance : " + date + "adresse postale" + adressePostale + " adresse electronique : " + adresseElectronique + " telephone : " + telephone + " accepte les alertes : " + accepte ;
        return s; 
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

    public Date getDate() {
        return date;
    }

    public String getAdressePostale() {
        return adressePostale;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getAdresseElectronique() {
        return adresseElectronique;
    }

    public boolean isAccepte() {
        return accepte;
    }

    
    

  
}
