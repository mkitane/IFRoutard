/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import dao.ClientDAO;
import dao.JpaUtil;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import metier.modele.Circuit;
import metier.modele.Client;
import metier.modele.Sejour;
import metier.service.Service;

/**
 *
 * @author Mehdi
 */
public class Main {
    public static void main(String[] args) {

       Date d = new Date();
       
       Client e = new Client(); 
       Client a = new Client( "mr","escure", "thomas", d, "france","06","monmail",true); 
       Client c = new Client( "mr","kitane", "mehdi", d, "france","06","monmail",true); 

       
       Service.ajouterClient(e);
       Service.ajouterClient(a);
       Service.ajouterClient(c);

       System.out.println(Service.rechercherClientParID(2));
   
        List<Client> l = Service.obtenirClients();
        for(int i=0; i < l.size(); i++){
            System.out.println(l.get(i));
        }
        
        
        
        Sejour s = new Sejour("1","2","3","4","5","6");
        Circuit s1 = new Circuit("7",8,"9","10","11","12","13");
        
        Service.ajouterSejour(s);
        Service.ajouterCircuit(s1);

    }
}
