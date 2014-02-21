/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.modele;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
        
/**
 *
 * @author Mehdi
 */
@Entity
public class Client {
   
    @Id   
    @Column(name = "ID_CLIENT")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID; 
    
    private String civilite; 
    private String nom; 
    private String prenom; 
    
    @Temporal(TemporalType.DATE)
    private Date date; 
    
    private String adressePostale; 
    private String telephone; 
    private String adresseElectronique; 
    private boolean accepte; 

    public Client() {
        
    }
    
    public Client(String nom, String prenom){
        this.nom = nom; 
        this.prenom = prenom; 
    }
    
    
    public String toString(){
        String s = "Client n" + ID + " Nom : " + nom + " Prenom : " + prenom;
        return s; 
    }

    
    

  
}
