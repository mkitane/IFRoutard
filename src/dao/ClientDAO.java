/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import metier.modele.Client;

/**
 *
 * @author Mehdi
 */
public class ClientDAO {

    public static void persist(Client c) {
        JpaUtil.obtenirEntityManager().persist(c);
    }

    public static void merge(Client c) {
        JpaUtil.obtenirEntityManager().merge(c);
    }

    public static void remove(Client c) {
        JpaUtil.obtenirEntityManager().remove(c);
    }

    public static Client rechercherParID(int ID) {

        EntityManager em = JpaUtil.obtenirEntityManager();
        Query query = em.createQuery("SELECT e from Client e where e.ID = :id");
        query.setParameter("id", ID);

        try {
            return (Client) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return null;
        }


    }

    public static Client rechercherParEmail(String email) {
        EntityManager em = JpaUtil.obtenirEntityManager();
        Query query = em.createQuery("SELECT e from Client e where e.email = :email");
        query.setParameter("email", email);

        try {
            return (Client) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return null;
        }
    }

    public static List<Client> obtenirClients() {
        EntityManager em = JpaUtil.obtenirEntityManager();
        Query query = em.createQuery("SELECT e from Client e");

        List<Client> list = query.getResultList();
        try {
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return null;
        }
    }
}
