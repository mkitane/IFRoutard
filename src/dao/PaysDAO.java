/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import metier.modele.Pays;

/**
 *
 * @author Mehdi
 */
public class PaysDAO {
    public static void persist(Pays c){
       JpaUtil.obtenirEntityManager().persist(c); 
    }
    
    public static void merge(Pays c){
        JpaUtil.obtenirEntityManager().merge(c); 
    }
    
    public static void remove(Pays c){
        JpaUtil.obtenirEntityManager().remove(c); 
    }
}