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
    
    
    
}
