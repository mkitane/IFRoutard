/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.modele;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Mehdi
 */
@Entity
public class Pays {
    @Id   
    private String code;
        
    private String nom; 
    private String region; 
    private String capitale; 
    private String langues; 
    private int superficie; 
    private double population; 
    private String regimePolitique; 

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
    
    
}
