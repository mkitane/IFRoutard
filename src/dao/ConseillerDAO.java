/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import metier.modele.Conseiller;



/**
 *
 * @author Thomas
 */
public class ConseillerDAO {
   
    public static void persist(Conseiller c){
       JpaUtil.obtenirEntityManager().persist(c); 
    }
    
    public static void merge(Conseiller c){
        JpaUtil.obtenirEntityManager().merge(c); 
    }
    
    public static void remove(Conseiller c){
        JpaUtil.obtenirEntityManager().remove(c); 
    }
}
