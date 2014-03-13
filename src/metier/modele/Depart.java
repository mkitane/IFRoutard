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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int ID; 
      
    protected String codeVoyage;
    
    @Temporal(TemporalType.DATE)
    protected Date dateDepart; 
    
    
    protected String villeDepart; 
    protected int tarif; 
    protected String transport;

    @Override
    public String toString() {
        String s = "";
        s += "Au depart de "+getVilleDepart()+" le "+ getDateDepart()+"       Tarif : "+getTarif()+"  Transport aérien : "+getTransport()  + "\n";

        return s;
    }

    
    
    public Depart() {
    }

    public Depart(String codeVoyage, Date dateDepart, String villeDepart, int tarif, String transport) {
        this.codeVoyage = codeVoyage;
        this.dateDepart = dateDepart;
        this.villeDepart = villeDepart;
        this.tarif = tarif;
        this.transport = transport;
    }

    public String getCodeVoyage() {
        return codeVoyage;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public String getVilleDepart() {
        return villeDepart;
    }

    public int getTarif() {
        return tarif;
    }

    public String getTransport() {
        return transport;
    }
    
    
    
}
