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
public class Client {
    @Id
    private int ID; 
    private String nom; 

    /*
    private String civilite; 
    private String nom; 
    private String prenom; 
    private int date; 
    private String adressePostale; 
    private String adresseElectronique; 
    private String telephone; 
    private boolean accepte; 
    */
    
    public Client(){
        ID = 1 ; 
        nom = "okok"; 
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
   

}
