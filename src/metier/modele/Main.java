/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.modele;

import dao.ClientDAO;
import dao.JpaUtil;
import javax.persistence.EntityManager;
import metier.service.ClientService;

/**
 *
 * @author Mehdi
 */
public class Main {
    public static void main(String[] args) {


       Client e = new Client(); 
       Client a = new Client("Thomas" , "Escure"); 
       Client c = new Client("Mehdi", "Kitane");

       
       ClientService.ajouterClient(e);
       ClientService.ajouterClient(a);
       ClientService.ajouterClient(c);

       ClientService.rechercherClientParID(1);
   }
}
