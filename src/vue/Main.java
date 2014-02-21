/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import dao.ClientDAO;
import dao.JpaUtil;
import java.util.List;
import javax.persistence.EntityManager;
import metier.modele.Client;
import metier.service.Service;

/**
 *
 * @author Mehdi
 */
public class Main {
    public static void main(String[] args) {


       Client e = new Client(); 
       Client a = new Client("Thomas" , "Escure"); 
       Client c = new Client("Mehdi", "Kitane");

       
       Service.ajouterClient(e);
       Service.ajouterClient(a);
       Service.ajouterClient(c);

       System.out.println(Service.rechercherClientParID(2));
   
        List<Client> l = Service.obtenirClients();
        for(int i=0; i < l.size(); i++){
            System.out.println(l.get(i));
        }
    }
}
