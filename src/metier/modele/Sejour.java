/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.modele;

import java.io.Serializable;
import javax.persistence.Entity;


/**
 *
 * @author Mehdi
 */
@Entity
public class Sejour extends Voyage{
    private String Residence;

    public Sejour() {
        super();
    }

    public Sejour(String Residence, String codeVoyage, String codePays, String intitule, String duree, String description) {
        super(codeVoyage, codePays, intitule, duree, description);
        this.Residence = Residence;
    }
    
}
