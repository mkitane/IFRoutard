/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.modele;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Thomas
 */
@Entity
public class Conseiller {
    // attributs privés

    @Id   
    @Column(name = "ID_CONSEILLER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    
    protected String civilite; 
    protected String nom; 
    protected String prenom; 
    @Temporal(TemporalType.DATE)
    protected Date dateNaissance; 
    
    protected String adresse; 
    protected String telephone; 
    
    @Column(name = "email")
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

    public Conseiller(String civilite, String nom, String prenom, Date dateNaissance, String adresse, String telephone, String email, String mdp) {
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
        this.mdp = mdp;
    }
    
    

    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        return ("Conseiller: "+  civilite + " " + nom + " " + prenom + ", né le " + formatter.format(dateNaissance) + ", habitant à " + adresse + ", téléphone: " + telephone + ", e-mail: " + email);
    }

    
    public boolean estConseillerPour(String codeVoyage){
        for(int i=0; i<paysSpecialisation.size();i++){
            Pays p = paysSpecialisation.get(i);
            if(codeVoyage.equals(p.getCode())){
                return true;
            }
        }
        return false;
    }
    public void setPaysSpecialisation(List<Pays> paysSpecialisation) {
        this.paysSpecialisation = paysSpecialisation;
    }

    public void setListeClients(List<Client> listeClients) {
        this.listeClients = listeClients;
    }

    public void ajouterPaysSpecialisation(Pays paysSpec){
        paysSpecialisation.add(paysSpec);
    }
    
    public void ajouterClient(Client client){
        listeClients.add(client);
    }
    public void supprimerPaysSpecialisation(Pays paysSpec){
        paysSpecialisation.remove(paysSpec);
    }
    
    public void supprimerClient(Client client){
        listeClients.remove(client);
    }
    
    

    public Integer getId() {
        return id;
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

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    
   
    
    
    

    
  
}
