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
    private Depart ConditionsDepart;
    
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

    public Devis(Depart ConditionsDepart, Voyage voyage, Conseiller conseiller, Client client, Date dateCreation, Integer nbPersonnes) {
        this.ConditionsDepart = ConditionsDepart;
        this.voyage = voyage;
        this.conseiller = conseiller;
        this.client = client;
        this.dateCreation = dateCreation;
        this.nbPersonnes = nbPersonnes;
    }

    public Depart getConditionsDepart() {
        return ConditionsDepart;
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
