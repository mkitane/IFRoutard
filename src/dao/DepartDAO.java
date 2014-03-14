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

    public static void persist(Depart c) {
        JpaUtil.obtenirEntityManager().persist(c);
    }

    public static void merge(Depart c) {
        JpaUtil.obtenirEntityManager().merge(c);
    }

    public static void remove(Depart c) {
        JpaUtil.obtenirEntityManager().remove(c);
    }

    public static List<Depart> rechercherParCode(String codeVoyage) {

        EntityManager em = JpaUtil.obtenirEntityManager();
        Query query = em.createQuery("SELECT e from Depart e where e.codeVoyage = :codeVoyage");
        query.setParameter("codeVoyage", codeVoyage);

        List<Depart> list = query.getResultList();

        try {
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return null;
        }
    }

    public static Depart rechercherDepartPetitPrix(String codeVoyage) {
        EntityManager em = JpaUtil.obtenirEntityManager();
        Query query = em.createQuery("SELECT p FROM Depart p WHERE p.tarif=(SELECT MIN(e.tarif) FROM Depart e where e.codeVoyage = :codeVoyage)");
        query.setParameter("codeVoyage", codeVoyage);

        List<Depart> list = query.getResultList();
        try {
            if (list.isEmpty()) {
                throw new Exception();
            }
            return list.get(0);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return null;
        }

    }

    public static List<Depart> obtenirDeparts() {
        EntityManager em = JpaUtil.obtenirEntityManager();
        Query query = em.createQuery("SELECT e from Depart e");

        List<Depart> list = query.getResultList();
        try {
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return null;
        }
    }
}
