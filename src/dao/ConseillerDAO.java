/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import metier.modele.Conseiller;
import metier.modele.Pays;

/**
 *
 * @author Thomas
 */
public class ConseillerDAO {

    public static void persist(Conseiller c) {
        JpaUtil.obtenirEntityManager().persist(c);
    }

    public static void merge(Conseiller c) {
        JpaUtil.obtenirEntityManager().merge(c);
    }

    public static void remove(Conseiller c) {
        JpaUtil.obtenirEntityManager().remove(c);
    }

    public static Conseiller rechercherParID(int ID) {

        EntityManager em = JpaUtil.obtenirEntityManager();
        Query query = em.createQuery("SELECT e from Conseiller e where e.id = :ID");
        query.setParameter("ID", ID);


        try {
            return (Conseiller) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return null;
        }
    }

    public static List<Conseiller> rechercherParPays(Pays pays) {
        EntityManager em = JpaUtil.obtenirEntityManager();
        Query query = em.createQuery("SELECT e from Conseiller e where :pays Member Of e.paysSpecialisation", Conseiller.class);
        query.setParameter("pays", pays);

        List<Conseiller> list = query.getResultList();


        try {
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return null;
        }
    }

    public static List<Conseiller> obtenirConseillers() {
        EntityManager em = JpaUtil.obtenirEntityManager();
        Query query = em.createQuery("SELECT e from Conseiller e");

        List<Conseiller> list = query.getResultList();
        try {
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return null;
        }
    }
}
