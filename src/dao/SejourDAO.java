/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import metier.modele.Sejour;

/**
 *
 * @author Mehdi
 */
public class SejourDAO {
    public static void persist(Sejour c){
       JpaUtil.obtenirEntityManager().persist(c); 
    }
    
    public static void merge(Sejour c){
        JpaUtil.obtenirEntityManager().merge(c); 
    }
    
    public static void remove(Sejour c){
        JpaUtil.obtenirEntityManager().remove(c); 
    }
    
}
    
