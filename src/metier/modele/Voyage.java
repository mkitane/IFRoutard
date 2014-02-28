/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
/**
 *
 * @author Mehdi
 */
@Entity
@Inheritance (strategy = InheritanceType.JOINED)
public abstract class Voyage{
    @Id   
    @Column(name = "Code_Voyage")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //private int ID; 
    protected String codeVoyage;

    
    protected String codePays; 
    protected String intitule; 
    protected String duree; 
    protected String description; 

    
    public Voyage(){
        
    }
    
    public Voyage(String codeVoyage, String codePays, String intitule, String duree, String description) {
        this.codeVoyage = codeVoyage;
        this.codePays = codePays;
        this.intitule = intitule;
        this.duree = duree;
        this.description = description;
    }

    public String toString() {
        return "codeVoyage=" + codeVoyage + ", codePays=" + codePays + ", intitule=" + intitule + ", duree=" + duree + ", description=" + description ;
    }
    
    
}
