/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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
    
    public static List<Depart> rechercherParCode(String codeVoyage){
        
        EntityManager em = JpaUtil.obtenirEntityManager();
        Query query = em.createQuery("SELECT e from Depart e where e.codeVoyage = :codeVoyage");
        query.setParameter("codeVoyage", codeVoyage);
   
        List<Depart> list = query.getResultList();

        return list; 
        
    } 
  
   public static List<Depart> obtenirDeparts(){
        EntityManager em = JpaUtil.obtenirEntityManager();
        Query query = em.createQuery("SELECT e from Depart e");
        
        List<Depart> list = query.getResultList();
        
        return list; 
    }

}
