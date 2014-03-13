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
import java.util.*;
import javax.persistence.ManyToOne;
/**
 *
 * @author Thomas
 */
@Entity
public class Devis {
    
    @Id   
    @Column(name = "ID_DEVIS")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @ManyToOne
    private Depart conditionsDepart;
    
    @ManyToOne
    private Voyage voyage;
    
    @ManyToOne
    private Conseiller conseiller;
    
    @ManyToOne
    private Client client;

    
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    
    private Integer nbPersonnes;

    
    public Devis() {
    }

    public Devis(Depart conditionsDepart, Voyage voyage, Conseiller conseiller, Client client, Date dateCreation, Integer nbPersonnes) {
        this.conditionsDepart = conditionsDepart;
        this.voyage = voyage;
        this.conseiller = conseiller;
        this.client = client;
        this.dateCreation = dateCreation;
        this.nbPersonnes = nbPersonnes;
    }

    
    public int getPrix(){
        return this.getNbPersonnes() * this.getConditionsDepart().getTarif(); 

    }
    public String toString() {
        String s  = ""; 
        s += "------------------------------------------------------------------------------------------------------------------------------\n";
        s += "Date : "+ dateCreation + "\n";
        s += client.getPrenom()+" "+client.getNom().toUpperCase() + "\n";
        s += client.getAdresse() + "\n";
        s += client.getTelephone() + "\n";
        s +=  "\n";
        s += "Votre conseiller pour ce voyage : "+conseiller.getPrenom()+" "+ conseiller.getNom()+" ("+conseiller.getEmail()+")" + "\n";
        s +=  "\n";
        s += "Votre voyage : "+voyage.getIntitule()+". "+voyage.getPaysVoyage().getNom().toUpperCase() + "\n";
        if(voyage.getClass().getName().equals("metier.modele.Circuit")){
            Circuit v = (Circuit) voyage;
            s += "Circuit ("+v.getDuree()+" jours, "+v.getKmParcourus()+" kms, "+v.getTransport()+")" + "\n";
        }else if(voyage.getClass().getName().equals("metier.modele.Sejour"))
        {
            Sejour sejour = (Sejour)voyage;
            s += "Sejour ("+sejour.getDuree()+" jours, "+sejour.getResidence()+")" + "\n";
        }
        s += "\n";
        s += "Depart : le "+conditionsDepart.getDateDepart()+" de "+conditionsDepart.getVilleDepart() + "\n";
        s += "Transport aerien (susceptible d'etre modifie) : "+conditionsDepart.getTransport() + "\n";
        s += "\n";
        s += voyage.getDescription() + "\n";
        s += "\n";
        s += "---------------------------------------" + "\n";
        s += "Nombre de personnes : "+getNbPersonnes() + "\n";
        s += "Tarif par personne : "+conditionsDepart.getTarif() + "\n";
        s += "TOTAL : "+ getPrix() + "\n";
        
        
        return s; 
                
    }

    
    public Depart getConditionsDepart() {
        return conditionsDepart;
    }

    public Voyage getVoyage() {
        return voyage;
    }

    public Conseiller getConseiller() {
        return conseiller;
    }

    public Client getClient() {
        return client;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public Integer getNbPersonnes() {
        return nbPersonnes;
    }
    
    
    
}
