/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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
    
    public static Pays rechercherParCode(String codePays){
        
        EntityManager em = JpaUtil.obtenirEntityManager();
        Query query = em.createQuery("SELECT e from Pays e where e.code = :codePays");
        query.setParameter("codePays", codePays);
   
        
        return (Pays) query.getSingleResult(); 
        
    } 
       public static Pays rechercherParNom(String nomPays){
        
        EntityManager em = JpaUtil.obtenirEntityManager();
        Query query = em.createQuery("SELECT e from Pays e where e.nom = :nomPays");
        query.setParameter("nomPays", nomPays);
   
        
        return (Pays) query.getSingleResult(); 
        
    } 
    public static List<Pays> obtenirPays(){
        EntityManager em = JpaUtil.obtenirEntityManager();
        Query query = em.createQuery("SELECT e from Pays e");
        
        List<Pays> list = query.getResultList();
        
        return list; 
    }

}