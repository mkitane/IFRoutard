/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import metier.modele.Client;

/**
 *
 * @author Mehdi
 */
public class ClientDAO {
    public static void Persist(Client c){
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       JpaUtil.obtenirEntityManager().persist(c); 
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();
    }
}
