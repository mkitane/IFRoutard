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

    public Circuit(String transport, int kmParcourus, String codeVoyage, String intitule, int duree, String description) {
        super(codeVoyage, intitule, duree, description);
        this.transport = transport;
        this.kmParcourus = kmParcourus;
    }

    public String toString() {
         String s = "";
         
        s += "****[" + super.getId() + "] " + super.getIntitule() + "\n";
        s += "Circuit, "+ super.getDuree()+" jours"  + "\n";
        s += super.getDescription()  + "\n";
        s += "\n";
        s += "*Fiche voyage"  + "\n";
        s += "Transport :" + getTransport()  + "\n";
        s += "Nombre de kms parcourus : " + getKmParcourus() + " km"  + "\n";
        s += "\n";
        s += "*Periodes et tarifs"  + "\n";
        for(int i=0; i<listeDeparts.size(); i++)
            s += listeDeparts.get(i);
        
        
        s += "\n";
        
        return s;
    }

    public String getTransport() {
        return transport;
    }

    public int getKmParcourus() {
        return kmParcourus;
    }
    
    
}
