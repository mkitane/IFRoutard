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
public class Circuit extends Voyage{
    
    protected String transport; 
    protected int kmParcourus;

    public Circuit() {
        super();
    }

    public Circuit(String transport, int kmParcourus, String codeVoyage, String codePays, String intitule, String duree, String description) {
        super(codeVoyage, codePays, intitule, duree, description);
        this.transport = transport;
        this.kmParcourus = kmParcourus;
    }

    public String toString() {
        return "Circuit{" + super.toString() + "transport=" + transport + ", kmParcourus=" + kmParcourus + '}';
    }

    public String getTransport() {
        return transport;
    }

    public int getKmParcourus() {
        return kmParcourus;
    }
    
    
}
