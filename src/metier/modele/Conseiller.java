/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.modele;

import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Thomas
 */
@Entity
public class Conseiller {
    // attributs privés

    @Id   
    @Column(name = "ID_CONSEILLER")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;
    
    protected String civilite; 
    protected String nom; 
    protected String prenom; 
    @Temporal(TemporalType.DATE)
    protected Date dateNaissance; 
    
    protected String adresse; 
    protected String telephone; 
    protected String email; 
    
    
    protected String mdp;

    @OneToMany
    protected List<Pays> paysSpecialisation = new ArrayList<Pays>();
    
    @ManyToMany
    protected List<Client> listeClients = new ArrayList<Client>();

    public Conseiller() {
    }

    public Conseiller(String civilite,String nom, String prenom, Date dateNaissance, String adresse, String telephone, String email) {
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
    }

    public String toString() {
        return "Conseiller{" + "civilite=" + civilite + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + ", adresse=" + adresse + ", telephone=" + telephone + ", email=" + email + ", mdp=" + mdp + '}';
    }

    public void setPaysSpecialisation(List<Pays> paysSpecialisation) {
        this.paysSpecialisation = paysSpecialisation;
    }

    public void ajouterPaysSpecialisation(Pays paysSpec){
        paysSpecialisation.add(paysSpec);
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

    public String getMdp() {
        return mdp;
    }

    public List<Pays> getPaysSpecialisation() {
        return paysSpecialisation;
    }

    public List<Client> getListeClients() {
        return listeClients;
    }


    
  
}
