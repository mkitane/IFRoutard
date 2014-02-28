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
public class Depart {
    @Id   
    @Column(name = "ID_Depart")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID; 
      
    private String codeVoyage;
    
    @Temporal(TemporalType.DATE)
    private Date dateDepart; 
    
    
    private String villeDepart; 
    private int tarif; 
    private String transport;

    
    
    public Depart() {
    }

    public Depart(String codeVoyage, Date dateDepart, String villeDepart, int tarif, String transport) {
        this.codeVoyage = codeVoyage;
        this.dateDepart = dateDepart;
        this.villeDepart = villeDepart;
        this.tarif = tarif;
        this.transport = transport;
    }
    
    
    
}
