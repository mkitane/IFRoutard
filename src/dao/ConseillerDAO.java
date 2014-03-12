/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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
    
    
    public static Conseiller rechercherParID(int ID){
        
        EntityManager em = JpaUtil.obtenirEntityManager();
        Query query = em.createQuery("SELECT e from Conseiller e where e.id = :ID");
        query.setParameter("ID", ID);
        
        return (Conseiller) query.getSingleResult(); 
        
    } 
    
    public static List<Conseiller> obtenirConseillers(){
        EntityManager em = JpaUtil.obtenirEntityManager();
        Query query = em.createQuery("SELECT e from Conseiller e");
        
        List<Conseiller> list = query.getResultList();
        
        return list; 
    }
}
