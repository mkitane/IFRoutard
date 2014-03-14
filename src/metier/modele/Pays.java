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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Mehdi
 */
@Entity
public class Pays {
    @Id   
    @Column(name = "ID_Pays")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int ID; 
      
    @Column(name = "codePays")
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
        s += "Pays : " + nom + "\n";
        s += capitale + " (cap), " + population + " hab., " + superficie + " km², langue officielle : " + langues+ "\n";
        s += "---------------------------------------------------------------------------------------------------" + "\n"; 
        s += "\n";
        
        return s;
    }

    public int getID() {
        return ID;
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

    public void setCode(String code) {
        this.code = code;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCapitale(String capitale) {
        this.capitale = capitale;
    }

    public void setLangues(String langues) {
        this.langues = langues;
    }

    public void setSuperficie(float superficie) {
        this.superficie = superficie;
    }

    public void setPopulation(float population) {
        this.population = population;
    }

    public void setRegimePolitique(String regimePolitique) {
        this.regimePolitique = regimePolitique;
    }

  
    
    
}
