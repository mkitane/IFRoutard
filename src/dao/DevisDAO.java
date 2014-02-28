/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import metier.modele.Devis;
/**
 *
 * @author Thomas
 */
public class DevisDAO {
    
    public static void persist(Devis c){
       JpaUtil.obtenirEntityManager().persist(c); 
    }
    
    public static void merge(Devis d){
        JpaUtil.obtenirEntityManager().merge(d); 
    }
    
    public static void remove(Devis d){
        JpaUtil.obtenirEntityManager().remove(d); 
    }
}
