/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import metier.modele.Depart;

/**
 *
 * @author Mehdi
 */
public class DepartDAO {
    public static void persist(Depart c){
       JpaUtil.obtenirEntityManager().persist(c); 
    }
    
    public static void merge(Depart c){
        JpaUtil.obtenirEntityManager().merge(c); 
    }
    
    public static void remove(Depart c){
        JpaUtil.obtenirEntityManager().remove(c); 
    }
}
