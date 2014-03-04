/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.modele;

import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author Thomas
 */
@Entity
public class Conseiller {
    // attributs privés

    @Id   
    @Column(name = "ID_CONSEILLER")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    
    @OneToMany
    private List<Pays> paysSpecialisation = new ArrayList<Pays>();
    
    private String mdp;
    @ManyToMany
    private List<Client> listeClients = new ArrayList<Client>();

    public Conseiller() {
    }

    /*public Conseiller(String mdp) {
        this.mdp = mdp;    COMMENT initialiser les listes de client et de paysspécialisation? c'est géré par la base de données?
    }*/

  
}
