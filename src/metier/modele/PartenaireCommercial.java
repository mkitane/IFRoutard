package metier.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Mehdi
 */
@Entity

public class PartenaireCommercial {

    @Id   
    @Column(name = "ID_Partenaire")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id; 
    
    protected String nom;
    
    @Column(name = "email")
    protected String email; 

    public PartenaireCommercial() {
    }

    
    public PartenaireCommercial(String nom, String email) {
        this.nom = nom;
        this.email = email;
    }

    public String toString() {
        return "PartenaireCommercial " + "nom=" + nom + ", email=" + email;
    }

    
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
  
    
}
