/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.modele;

import dao.ClientDAO;
import dao.JpaUtil;
import javax.persistence.EntityManager;

/**
 *
 * @author Mehdi
 */
public class Main {
    public static void main(String[] args) {


       Client e = new Client(); 
       Client r = new Client(); 
       Client t = new Client(); 

       ClientDAO.Persist(e);

   }
}
