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
public class Circuit extends Voyage{
    
    private String transport; 
    private int kmParcourus;

    public Circuit() {
        super();
    }

    public Circuit(String transport, int kmParcourus, String codeVoyage, String codePays, String intitule, String duree, String description) {
        super(codeVoyage, codePays, intitule, duree, description);
        this.transport = transport;
        this.kmParcourus = kmParcourus;
    }
    
    
}
