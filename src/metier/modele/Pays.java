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
    protected int superficie; 
    protected double population; 
    protected String regimePolitique; 

    public Pays() {
    }

    public Pays(String nom, String code, String region, String capitale, String langues, int superficie, double population, String regimePolitique) {
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
        return ("Pays: "+  nom + " [" + code + "] (" + regimePolitique + "), Capitale: " + capitale + ", Région: " + region + ", Langues: " + langues + ", " + superficie + " km², " + population + " millions d'hbitants");
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

    public int getSuperficie() {
        return superficie;
    }

    public double getPopulation() {
        return population;
    }

    public String getRegimePolitique() {
        return regimePolitique;
    }
    
    
}
