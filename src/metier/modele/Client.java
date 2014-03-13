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
import javax.persistence.ManyToMany;
        
/**
 *
 * @author Mehdi
 */
@Entity
public class Client {
   
    @Id   
    @Column(name = "ID_CLIENT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int ID; 
    
    protected String civilite; 
    protected String nom; 
    protected String prenom; 
    
    @Temporal(TemporalType.DATE)
    protected Date dateNaissance; 
    
    protected String adresse; 
    protected String telephone; 
    protected String email; 
    
    
    protected boolean accepte;
    protected String motDePasse; 
    
    @ManyToMany(mappedBy="listeClients")
    protected List<Conseiller> listeConseiller = new ArrayList<Conseiller>();
    
    
    
    public Client() {
        
    }

    public Client(String civilite, String nom, String prenom, Date dateNaissance, String adresse, String telephone, String email) {
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
    }
    
  
   
    
    public String toString(){
        return ("Client: "+  civilite + " " + nom + " " + prenom + ", né le " + dateNaissance + ", habitant à " + adresse + ", téléphone: " + telephone + ", e-mail: " + email);
    }
    
    public void AjoutConseiller(Conseiller c){
        listeConseiller.add(c);
    }

    public void setListeConseiller(List<Conseiller> listeConseiller) {
        this.listeConseiller = listeConseiller;
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

    public String getMotDePasse() {
        return motDePasse;
    }

    public List<Conseiller> getListeConseiller() {
        return listeConseiller;
    }


  
}
