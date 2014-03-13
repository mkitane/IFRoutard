/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Mehdi
 */
@Entity
public class Pays {
    @Id   
    @Column(name = "ID_Pays")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int ID; 
      
    protected String code;
        
    protected String nom; 
    protected String region; 
    protected String capitale; 
    protected String langues; 
    protected float superficie; 
    protected float population; 
    protected String regimePolitique; 

    public Pays() {
    }

    public Pays(String nom, String code, String region, String capitale, String langues, float superficie, float population, String regimePolitique) {
        this.nom = nom;
        this.code = code;
        this.region = region;
        this.capitale = capitale;
        this.langues = langues;
        this.superficie = superficie;
        this.population = population;
        this.regimePolitique = regimePolitique;
    }

    public String toString() {
        String s = "";
        s += "---------------------------------------------------------------------------------------------------" + "\n";
        s += "Pays : " + getNom() + "\n";
        s += getCapitale() + " (cap), " + getPopulation() + " hab., " + getSuperficie() + " km², langue officielle : " + getLangues() + "\n";
        s += "---------------------------------------------------------------------------------------------------" + "\n"; 
        s += "\n";
        
        return s;
    }

    public String getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public String getRegion() {
        return region;
    }

    public String getCapitale() {
        return capitale;
    }

    public String getLangues() {
        return langues;
    }

    public float getSuperficie() {
        return superficie;
    }

    public float getPopulation() {
        return population;
    }

    public String getRegimePolitique() {
        return regimePolitique;
    }
    
    
}
