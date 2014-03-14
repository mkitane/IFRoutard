/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import metier.modele.PartenaireCommercial;

/**
 *
 * @author Mehdi
 */
public class PartenaireCommercialDAO {

    public static void persist(PartenaireCommercial c) {
        JpaUtil.obtenirEntityManager().persist(c);
    }

    public static void merge(PartenaireCommercial d) {
        JpaUtil.obtenirEntityManager().merge(d);
    }

    public static void remove(PartenaireCommercial d) {
        JpaUtil.obtenirEntityManager().remove(d);
    }

    public static List<PartenaireCommercial> obtenirPartenaireCommerciaux() {
        EntityManager em = JpaUtil.obtenirEntityManager();
        Query query = em.createQuery("SELECT e from PartenaireCommercial e");

        List<PartenaireCommercial> list = query.getResultList();


        try {
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return null;
        }

    }
}
