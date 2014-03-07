/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.modele;

import javax.persistence.Entity;


/**
 *
 * @author Mehdi
 */
@Entity
public class Sejour extends Voyage{
    protected String Residence;

    public Sejour() {
        super();
    }

    public Sejour(String Residence, String codeVoyage, String codePays, String intitule, String duree, String description) {
        super(codeVoyage, codePays, intitule, duree, description);
        this.Residence = Residence;
    }

    public String toString() {
        return "Sejour{" + super.toString() + "Residence=" + Residence + '}';
    }

    public String getResidence() {
        return Residence;
    }
 
    
}
