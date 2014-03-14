/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.modele;

import java.text.SimpleDateFormat;
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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
        
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
    
    
    @Column(name = "email")
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

    public Client(String civilite, String nom, String prenom, Date dateNaissance, String adresse, String telephone, String email, boolean accepte, String motDePasse) {
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
        this.accepte = accepte;
        this.motDePasse = motDePasse;
    }
    
  
   
    
    public String toString(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        return ("Client: "+  civilite + " " + nom + " " + prenom + ", né le " + formatter.format(dateNaissance)+ ", habitant à " + adresse + ", téléphone: " + telephone + ", e-mail: " + email);
    }
    
    public void ajoutConseiller(Conseiller c){
        listeConseiller.add(c);
    }

    public void supprimerConseiller(Conseiller c){
        listeConseiller.remove(c);
    }
    
    
    public void setListeConseiller(List<Conseiller> listeConseiller) {
        this.listeConseiller = listeConseiller;
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

    public String getMotDePasse() {
        return motDePasse;
    }

    public List<Conseiller> getListeConseiller() {
        return listeConseiller;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAccepte(boolean accepte) {
        this.accepte = accepte;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    
  
}
