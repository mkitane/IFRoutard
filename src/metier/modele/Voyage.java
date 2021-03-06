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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
/**
 *
 * @author Mehdi
 */
@Entity
@Inheritance (strategy = InheritanceType.JOINED)
public abstract class Voyage{
    @Id   
    @Column(name = "ID_Voyage")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id; 
    
    @Column(name = "codeVoyage")
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

    

    public void setListeDeparts(List<Depart> listeDeparts) {
        this.listeDeparts = listeDeparts;
    }



    public int getId() {
        return id;
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

    public void setCodeVoyage(String codeVoyage) {
        this.codeVoyage = codeVoyage;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPaysVoyage(Pays paysVoyage) {
        this.paysVoyage = paysVoyage;
    }

  
    
    
    
    
}
