/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import metier.modele.Client;
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
    
    public static List<Devis> obtenirDevis(){
        EntityManager em = JpaUtil.obtenirEntityManager();
        Query query = em.createQuery("SELECT e from Devis e");
        
        List<Devis> list = query.getResultList();
        
        return list; 
    }
    public static List<Devis> rechercherDevis(Client c){
        EntityManager em = JpaUtil.obtenirEntityManager();
        Query query = em.createQuery("SELECT e from Devis e where e.client = :client");
        query.setParameter("client", c);

        List<Devis> list = query.getResultList();
        
        return list; 
    }
}
