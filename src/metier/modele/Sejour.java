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

    public Sejour(String Residence, String codeVoyage, String intitule, int duree, String description) {
        super(codeVoyage, intitule, duree, description);
        this.Residence = Residence;
    }

    public String toString() {
        String s = "";
        s += "****[" + super.getId() + "] " + super.getIntitule() + "\n";
        s += "Sejour, "+ super.getDuree()+" jours"  + "\n";
        s += super.getDescription()  + "\n";
        s += "\n";
        s += "*Fiche voyage"  + "\n";
        s += "Residence : " + getResidence()+ "\n" ;
        s += "\n";
        s += "*Periodes et tarifs"  + "\n";
        for(int i=0; i<listeDeparts.size(); i++)
            s += listeDeparts.get(i);
        
        
        s += "\n";
        
        return s;
    }

    public String getResidence() {
        return Residence;
    }
 
    
}
