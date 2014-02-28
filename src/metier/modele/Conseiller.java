/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.modele;

import java.util.*;

/**
 *
 * @author Thomas
 */
public class Conseiller {
    // attributs privés

    private Pays paysSpecialisation;
    private Integer id;
    private String mdp;
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
