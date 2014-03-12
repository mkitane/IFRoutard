/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.modele;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
/**
 *
 * @author Mehdi
 */
@Entity
@Inheritance (strategy = InheritanceType.JOINED)
public abstract class Voyage{
    @Id   
    @Column(name = "ID_Voyage")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id; 
    
    
    protected String codeVoyage;

    
    protected String intitule; 
    protected int duree; 
    protected String description; 

    
    
    @OneToOne
    protected Pays paysVoyage; 
    
    @OneToMany
    protected List<Depart> listeDeparts = new ArrayList<Depart>(); 
    
    
    public Voyage(){
        
    }
    
    public Voyage(String codeVoyage, String intitule, int duree, String description) {
        this.codeVoyage = codeVoyage;
        this.intitule = intitule;
        this.duree = duree;
        this.description = description;
    }

    public String toString() {
        return "codeVoyage=" + codeVoyage + ", intitule=" + intitule + ", duree=" + duree + ", description=" + description ;
    }

    public void setListeDeparts(List<Depart> listeDeparts) {
        this.listeDeparts = listeDeparts;
    }

    public void ajouterPaysVoyage(Pays p){
        paysVoyage = p ; 
    }
    public String getCodeVoyage() {
        return codeVoyage;
    }

    public String getIntitule() {
        return intitule;
    }

    public int getDuree() {
        return duree;
    }

    public String getDescription() {
        return description;
    }

    public Pays getPaysVoyage() {
        return paysVoyage;
    }

    public List<Depart> getListeDeparts() {
        return listeDeparts;
    }
    
    
}
