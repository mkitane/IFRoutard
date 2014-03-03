/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.modele;

import javax.persistence.Id;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.*;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
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
    private Pays paysSpecialisation;
    
    private String mdp;
    @ManyToMany
    private ArrayList<Client> listeClients = new ArrayList<Client>();

    public Conseiller() {
    }

    public Conseiller(Pays PaysSpecialisation, String mdp) {
        this.paysSpecialisation = PaysSpecialisation;
        this.mdp = mdp;
    }

    public void AjoutClient(Client c) {
        listeClients.add(c);
    }
}
