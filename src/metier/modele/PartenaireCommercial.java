package metier.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    
    protected String nomEntreprise;
    protected String email; 

    public PartenaireCommercial() {
    }

    
    public PartenaireCommercial(String nomEntreprise, String email) {
        this.nomEntreprise = nomEntreprise;
        this.email = email;
    }

    
    public int getId() {
        return id;
    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public String getEmail() {
        return email;
    }

    
    
    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
