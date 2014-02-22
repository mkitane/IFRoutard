/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import metier.modele.Circuit;

/**
 *
 * @author Mehdi
 */

public class CircuitDAO {
    public static void persist(Circuit c){
       JpaUtil.obtenirEntityManager().persist(c); 
    }
    
    public static void merge(Circuit c){
        JpaUtil.obtenirEntityManager().merge(c); 
    }
    
    public static void remove(Circuit c){
        JpaUtil.obtenirEntityManager().remove(c); 
    }
    
}
