/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import metier.modele.Circuit;
import metier.modele.Pays;
import metier.modele.Sejour;
import metier.modele.Voyage;

/**
 *
 * @author Mehdi
 */
public class VoyageDAO {
    public static void persist(Voyage c){
       JpaUtil.obtenirEntityManager().persist(c); 
    }
    
    public static void merge(Voyage c){
        JpaUtil.obtenirEntityManager().merge(c); 
    }
    
    public static void remove(Voyage c){
        JpaUtil.obtenirEntityManager().remove(c); 
    }
    
    public static Voyage rechercherParCode(int IDVoyage){
        
        EntityManager em = JpaUtil.obtenirEntityManager();
        Query query = em.createQuery("SELECT e from Voyage e where e.id = :IDlVoyage");
        query.setParameter("IDlVoyage", IDVoyage);
   
        
        return (Voyage) query.getSingleResult(); 
        
    } 
    
    public static Voyage rechercherVoyageParCodeVoyage(String codeVoyage){
         EntityManager em = JpaUtil.obtenirEntityManager();
        Query query = em.createQuery("SELECT e from Voyage e where e.codeVoyage = :codeVoyage");
        query.setParameter("codeVoyage", codeVoyage);
   
        
        return (Voyage) query.getSingleResult(); 
    }
    
    public static List<Voyage> rechercherVoyageParPays(Pays pays){
         EntityManager em = JpaUtil.obtenirEntityManager();
        Query query = em.createQuery("SELECT e from Voyage e where e.paysVoyage = :pays");
        query.setParameter("pays", pays);
   
        
        List<Voyage> list = query.getResultList();
        return list;
    }
      
    public static List<Voyage> obtenirSejours(){
        
        EntityManager em = JpaUtil.obtenirEntityManager();
        Query query = em.createQuery("SELECT e from Sejour e");
        
        List<Voyage> list = query.getResultList();
        
        return list; 
        
    } 
    public static List<Voyage> obtenirCircuits(){
        EntityManager em = JpaUtil.obtenirEntityManager();
        Query query = em.createQuery("SELECT e from Circuit e");
        
        List<Voyage> list = query.getResultList();
        
        return list; 
    }
    
    public static List<Voyage> obtenirVoyages(){
        EntityManager em = JpaUtil.obtenirEntityManager();
        Query query = em.createQuery("SELECT e from Voyage e");
        
        List<Voyage> list = query.getResultList();
        
        return list; 
    }

}