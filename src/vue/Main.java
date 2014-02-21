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

       System.out.println(ClientService.rechercherClientParID(2));
   
        List<Client> l = ClientService.obtenirClients();
        for(int i=0; i < l.size(); i++){
            System.out.println(l.get(i));
        }
    }
}
