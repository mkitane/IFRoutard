/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.service;

import dao.ClientDAO;
import dao.ConseillerDAO;
import dao.DepartDAO;
import dao.DevisDAO;
import dao.JpaUtil;
import dao.PartenaireCommercialDAO;
import dao.PaysDAO;
import dao.VoyageDAO;
import java.util.List;
import metier.modele.Client;
import metier.modele.Conseiller;
import metier.modele.Depart;
import metier.modele.Devis;
import metier.modele.PartenaireCommercial;
import metier.modele.Pays;
import metier.modele.Voyage;
import util.Aleatoire;

/**
 *
 * @author Mehdi
 */
public class Service {
    //-----------------------------Methodes Relatives aux Clients-------------------------------//

    /**
     *
     * Methode statique qui fait persister un client dans la base de donnée
     *
     * @param c Client a creer
     *
     */
    public static void creerClient(Client c) {

        try {
            JpaUtil.creerEntityManager();

            try {
                JpaUtil.ouvrirTransaction();

                ClientDAO.persist(c);

                JpaUtil.validerTransaction();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                JpaUtil.annulerTransaction();

            } finally {
                JpaUtil.fermerEntityManager();

            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    /**
     *
     * Methode statique qui met à jour un client dans la base de donnée
     *
     * @param c Client a mettre a jour
     *
     */
    public static void updateClient(Client c) {

        try {
            JpaUtil.creerEntityManager();

            try {
                JpaUtil.ouvrirTransaction();

                ClientDAO.merge(c);


                JpaUtil.validerTransaction();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                JpaUtil.annulerTransaction();

            } finally {
                JpaUtil.fermerEntityManager();

            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    /**
     *
     * Methode statique qui supprime un client dans la base de donnée
     *
     * @param c Client a supprimer
     *
     */
    public static void supprimerClient(Client c) {
        try {
            JpaUtil.creerEntityManager();

            try {
                JpaUtil.ouvrirTransaction();

                ClientDAO.remove(c);


                JpaUtil.validerTransaction();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                JpaUtil.annulerTransaction();

            } finally {
                JpaUtil.fermerEntityManager();

            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    /**
     * Methode statique qui recherche un Client grace a son identifiant
     *
     * @param ID Identifiant dans la base de donnée
     * @return Client trouvé
     */
    public static Client rechercherClientParID(int ID) {
        Client c = null;
        try {
            JpaUtil.creerEntityManager();

            try {
                JpaUtil.ouvrirTransaction();

                c = ClientDAO.rechercherParID(ID);


                JpaUtil.validerTransaction();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                JpaUtil.annulerTransaction();

            } finally {
                JpaUtil.fermerEntityManager();

            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }



        return c;
    }

    /**
     * Methode statique qui recherche un Client grace a son adresse email
     *
     * @param email adresse email
     * @return Client trouvé
     */
    public static Client rechercherClientParEmail(String email) {
        Client c = null;
        try {
            JpaUtil.creerEntityManager();

            try {
                JpaUtil.ouvrirTransaction();

                c = ClientDAO.rechercherParEmail(email);


                JpaUtil.validerTransaction();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                JpaUtil.annulerTransaction();

            } finally {
                JpaUtil.fermerEntityManager();

            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }


        return c;
    }

    /**
     * Methode statique qui renvoie tous les clients contenus dans la base de donnée
     *
     * @return Liste des clients
     */
    public static List<Client> obtenirClients() {
        List<Client> l = null;
        try {
            JpaUtil.creerEntityManager();

            try {
                JpaUtil.ouvrirTransaction();


                l = ClientDAO.obtenirClients();


                JpaUtil.validerTransaction();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                JpaUtil.annulerTransaction();

            } finally {
                JpaUtil.fermerEntityManager();

            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }


        return l;
    }

    /**
     * Methode qui permet de savoir si le mot de passe entré est bien le bon pour ce client
     *
     * @param c Client
     * @param mdp mot de passe supposé
     * @return vrai si bon mot de passe, faux sinon
     */
    public static boolean verifierMdpClient(Client c, String mdp) {
        if (mdp.equals(c.getMotDePasse())) {
            return true;
        }
        return false;
    }
    //-----------------------------Methodes Relatives aux Sejours et circuit-------------------------------//

    /**
     *
     * Methode statique qui fait persister un voyage dans la base de donnée
     *
     * @param s Voyage a creer
     *
     */
    public static void creerVoyage(Voyage s) {
        try {
            JpaUtil.creerEntityManager();

            try {
                JpaUtil.ouvrirTransaction();

                VoyageDAO.persist(s);
                //ajouter depart


                JpaUtil.validerTransaction();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                JpaUtil.annulerTransaction();

            } finally {
                JpaUtil.fermerEntityManager();

            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

    }

    /**
     *
     * Methode statique qui met à jour un Voyage dans la base de donnée
     *
     * @param c Voyage a mettre a jour
     *
     */
    public static void updateVoyage(Voyage v) {
        try {
            JpaUtil.creerEntityManager();

            try {
                JpaUtil.ouvrirTransaction();

                VoyageDAO.merge(v);
                //ajouter depart


                JpaUtil.validerTransaction();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                JpaUtil.annulerTransaction();

            } finally {
                JpaUtil.fermerEntityManager();

            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    /**
     *
     * Methode statique qui supprime un Voyage dans la base de donnée
     *
     * @param c Voyage a supprimer
     *
     */
    public static void supprimerVoyage(Voyage v) {
        try {
            JpaUtil.creerEntityManager();

            try {
                JpaUtil.ouvrirTransaction();

                VoyageDAO.remove(v);
                //ajouter depart


                JpaUtil.validerTransaction();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                JpaUtil.annulerTransaction();

            } finally {
                JpaUtil.fermerEntityManager();

            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    /**
     * Methode statique qui recherche un Voyage grace a son identifiant
     *
     * @param ID Identifiant dans la base de donnée
     * @return Voyage trouvé
     */
    public static Voyage rechercherVoyage(int ID) {
        Voyage v = null;
        try {
            JpaUtil.creerEntityManager();

            try {
                JpaUtil.ouvrirTransaction();

                v = VoyageDAO.rechercherParCode(ID);


                JpaUtil.validerTransaction();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                JpaUtil.annulerTransaction();

            } finally {
                JpaUtil.fermerEntityManager();

            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }


        return v;
    }

    /**
     * Methode statique qui renvoie un Voyage en fonction du codeVoyage correspondant
     *
     * @param codeVoyage Code voyage correspondant au Voyage recherché
     * @return Voyage trouvé
     */
    public static Voyage rechercherVoyage(String codeVoyage) {
        Voyage v = null;
        try {
            JpaUtil.creerEntityManager();

            try {
                JpaUtil.ouvrirTransaction();

                v = VoyageDAO.rechercherVoyageParCodeVoyage(codeVoyage);


                JpaUtil.validerTransaction();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                JpaUtil.annulerTransaction();

            } finally {
                JpaUtil.fermerEntityManager();

            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return v;
    }

    /**
     * Methode statique qui renvoie la liste de tous les voyages
     *
     * @return Liste de tous les voyages trouvés
     */
    public static List<Voyage> obtenirVoyages() {
        List<Voyage> l = null;
        try {
            JpaUtil.creerEntityManager();

            try {
                JpaUtil.ouvrirTransaction();

                l = VoyageDAO.obtenirVoyages();


                JpaUtil.validerTransaction();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                JpaUtil.annulerTransaction();

            } finally {
                JpaUtil.fermerEntityManager();

            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return l;
    }

    /**
     * Methode statique qui renvoie tous les circuits ou tous les sejours
     *
     * @param circuit Boolean qui permet de savoir si on renvoie les circuits ou les sejours
     * @return Liste des circuits si circuit = true et Liste des sejours si circuit = false
     */
    public static List<Voyage> obtenirVoyages(boolean circuit) {
        List<Voyage> l = null;



        try {
            JpaUtil.creerEntityManager();

            try {
                JpaUtil.ouvrirTransaction();



                if (circuit) {
                    l = VoyageDAO.obtenirCircuits();
                } else {
                    l = VoyageDAO.obtenirSejours();
                }



                JpaUtil.validerTransaction();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                JpaUtil.annulerTransaction();

            } finally {
                JpaUtil.fermerEntityManager();

            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return l;
    }

    /**
     * Methode statique qui renvoie la liste de tous les voyages dans le pays recherché (Pratique pour l'IHM et la recherche par pays)
     *
     * @param p Pays dont on veux obtenir les voyages correspondants
     * @return Voyages renvoyes
     */
    public static List<Voyage> obtenirVoyages(Pays p) {

        List<Voyage> v = null;
        try {
            JpaUtil.creerEntityManager();

            try {
                JpaUtil.ouvrirTransaction();

                v = VoyageDAO.rechercherVoyageParPays(p);


                JpaUtil.validerTransaction();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                JpaUtil.annulerTransaction();

            } finally {
                JpaUtil.fermerEntityManager();

            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return v;
    }
    //-----------------------------Methodes Relatives aux Pays-------------------------------//

    /**
     *
     * Methode statique qui fait persister un pays dans la base de donnée
     *
     * @param p Pays a creer
     *
     */
    public static void creerPays(Pays p) {

        try {
            JpaUtil.creerEntityManager();

            try {
                JpaUtil.ouvrirTransaction();

                PaysDAO.persist(p);


                JpaUtil.validerTransaction();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                JpaUtil.annulerTransaction();

            } finally {
                JpaUtil.fermerEntityManager();

            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    /**
     *
     * Methode statique qui met à jour un Pays dans la base de donnée
     *
     * @param c Pays a mettre a jour
     *
     */
    public static void updatePays(Pays p) {

        try {
            JpaUtil.creerEntityManager();

            try {
                JpaUtil.ouvrirTransaction();

                PaysDAO.merge(p);


                JpaUtil.validerTransaction();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                JpaUtil.annulerTransaction();

            } finally {
                JpaUtil.fermerEntityManager();

            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    /**
     *
     * Methode statique qui supprime un Pays dans la base de donnée
     *
     * @param c Pays a supprimer
     *
     */
    public static void supprimerPays(Pays p) {

        try {
            JpaUtil.creerEntityManager();

            try {
                JpaUtil.ouvrirTransaction();

                PaysDAO.remove(p);


                JpaUtil.validerTransaction();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                JpaUtil.annulerTransaction();

            } finally {
                JpaUtil.fermerEntityManager();

            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    /**
     * Methode statique qui recherche un Pays par son nom
     *
     * @param nom nom du pays recherché
     * @return pays trouvé
     */
    public static Pays rechercherPaysParNom(String nom) {
        Pays p = null;
        try {
            JpaUtil.creerEntityManager();

            try {
                JpaUtil.ouvrirTransaction();

                p = PaysDAO.rechercherParNom(nom);


                JpaUtil.validerTransaction();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                JpaUtil.annulerTransaction();

            } finally {
                JpaUtil.fermerEntityManager();

            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return p;
    }

    /**
     * Methode statique qui recherche un Pays par son code Pays
     *
     * @param nom code (3lettres) du pays recherché
     * @return pays trouvé
     */
    public static Pays rechercherPaysParCode(String codePays) {

        Pays p = null;
        try {
            JpaUtil.creerEntityManager();

            try {
                JpaUtil.ouvrirTransaction();

                p = PaysDAO.rechercherParCode(codePays);


                JpaUtil.validerTransaction();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                JpaUtil.annulerTransaction();

            } finally {
                JpaUtil.fermerEntityManager();

            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return p;
    }

    /**
     * Methode statique qui renvoie tous les pays contenus dans la base de donnée
     *
     * @return Liste de tous les pays
     */
    public static List<Pays> obtenirPays() {
        List<Pays> l = null;
        try {
            JpaUtil.creerEntityManager();

            try {
                JpaUtil.ouvrirTransaction();

                l = PaysDAO.obtenirPays();


                JpaUtil.validerTransaction();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                JpaUtil.annulerTransaction();

            } finally {
                JpaUtil.fermerEntityManager();

            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return l;
    }

    //-----------------------------Methodes Relatives aux Departs-------------------------------//
    /**
     *
     * Methode statique qui fait persister un Depart dans la base de donnée
     *
     * @param c Depart a creer
     *
     */
    public static void creerDepart(Depart c) {
        try {
            JpaUtil.creerEntityManager();

            try {
                JpaUtil.ouvrirTransaction();

                DepartDAO.persist(c);


                JpaUtil.validerTransaction();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                JpaUtil.annulerTransaction();

            } finally {
                JpaUtil.fermerEntityManager();

            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    /**
     *
     * Methode statique qui met à jour un Depart dans la base de donnée
     *
     * @param c Depart a mettre a jour
     *
     */
    public static void updateDepart(Depart c) {
        try {
            JpaUtil.creerEntityManager();

            try {
                JpaUtil.ouvrirTransaction();

                DepartDAO.merge(c);


                JpaUtil.validerTransaction();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                JpaUtil.annulerTransaction();

            } finally {
                JpaUtil.fermerEntityManager();

            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    /**
     *
     * Methode statique qui supprime un Depart dans la base de donnée
     *
     * @param c Depart a supprimer
     *
     */
    public static void supprimerDepart(Depart c) {
        try {
            JpaUtil.creerEntityManager();

            try {
                JpaUtil.ouvrirTransaction();

                DepartDAO.remove(c);


                JpaUtil.validerTransaction();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                JpaUtil.annulerTransaction();

            } finally {
                JpaUtil.fermerEntityManager();

            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    /**
     * Methode statique qui recherche les départs relatifs a un voyage
     *
     * @param codeVoyage code du voyage a rechercher
     * @return Liste des départs qui correspondent a ce voyage
     */
    public static List<Depart> obtenirDeparts(String codeVoyage) {

        List<Depart> l = null;
        try {
            JpaUtil.creerEntityManager();

            try {
                JpaUtil.ouvrirTransaction();

                l = DepartDAO.rechercherParCode(codeVoyage);



                JpaUtil.validerTransaction();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                JpaUtil.annulerTransaction();

            } finally {
                JpaUtil.fermerEntityManager();

            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return l;
    }

    /**
     * Methode statique qui recherche le Depart ayant le plus petit prix parmis les départs d'un voyage
     *
     * @param codeVoyage code voyage du pays
     * @return Depart ayant le plus petit prix
     */
    public static Depart rechercherDepartPetitPrix(String codeVoyage) {
        Depart departMin = null;

        try {
            JpaUtil.creerEntityManager();

            try {
                JpaUtil.ouvrirTransaction();

                departMin = DepartDAO.rechercherDepartPetitPrix(codeVoyage);

                JpaUtil.validerTransaction();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                JpaUtil.annulerTransaction();

            } finally {
                JpaUtil.fermerEntityManager();

            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

        return departMin;
    }

    /**
     * Methode statique qui renvoit tous les départs contenus dans la base de donnée
     *
     * @return Liste de tous les départs contenus dans la base de donnée
     */
    public static List<Depart> obtenirDeparts() {
        List<Depart> l = null;

        try {
            JpaUtil.creerEntityManager();

            try {
                JpaUtil.ouvrirTransaction();

                l = DepartDAO.obtenirDeparts();


                JpaUtil.validerTransaction();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                JpaUtil.annulerTransaction();

            } finally {
                JpaUtil.fermerEntityManager();

            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return l;
    }
    ////-----------------------------Methodes Relatives aux Conseillers-------------------------------//

    /**
     *
     * Methode statique qui fait persister un conseiller dans la base de donnée
     *
     * @param c Conseiller a creer
     *
     */
    public static void creerConseiller(Conseiller c) {
        try {
            JpaUtil.creerEntityManager();

            try {
                JpaUtil.ouvrirTransaction();

                //ajouter pays et ajouter 
                ConseillerDAO.persist(c);


                JpaUtil.validerTransaction();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                JpaUtil.annulerTransaction();

            } finally {
                JpaUtil.fermerEntityManager();

            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

    }

    /**
     *
     * Methode statique qui supprime un Conseiller dans la base de donnée
     *
     * @param c Conseiller a supprimer
     *
     */
    public static void supprimerConseiller(Conseiller c) {
        try {
            JpaUtil.creerEntityManager();

            try {
                JpaUtil.ouvrirTransaction();

                //ajouter pays et ajouter 
                ConseillerDAO.remove(c);


                JpaUtil.validerTransaction();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                JpaUtil.annulerTransaction();

            } finally {
                JpaUtil.fermerEntityManager();

            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

    }

    /**
     * Methode statique qui met a jour un conseiller dans la base de donnée
     *
     * @param c Conseiller à mettre a jour
     */
    public static void updateConseiller(Conseiller c) {
        try {
            JpaUtil.creerEntityManager();

            try {
                JpaUtil.ouvrirTransaction();

                ConseillerDAO.merge(c);


                JpaUtil.validerTransaction();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                JpaUtil.annulerTransaction();

            } finally {
                JpaUtil.fermerEntityManager();

            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    /**
     * Methode statique qui recherche un Conseiller grace a son identifiant
     *
     * @param ID Identifiant dans la base de donnée
     * @return Conseiller trouvé
     */
    public static Conseiller rechercherConseiller(int ID) {
        Conseiller c = null;
        try {
            JpaUtil.creerEntityManager();

            try {
                JpaUtil.ouvrirTransaction();

                c = ConseillerDAO.rechercherParID(ID);


                JpaUtil.validerTransaction();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                JpaUtil.annulerTransaction();

            } finally {
                JpaUtil.fermerEntityManager();

            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return c;
    }

    /**
     * Methode qui recherche les conseillers affectés à un pays particulier
     *
     * @param p Pays dont on cherche les conseillers
     * @return Liste des conseillers affectés à un pays particulier
     */
    public static List<Conseiller> obtenirConseillers(Pays p) {
        List<Conseiller> c = null;
        try {
            JpaUtil.creerEntityManager();

            try {
                JpaUtil.ouvrirTransaction();

                c = ConseillerDAO.rechercherParPays(p);


                JpaUtil.validerTransaction();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                JpaUtil.annulerTransaction();

            } finally {
                JpaUtil.fermerEntityManager();

            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return c;
    }

    /**
     * Methode statique qui renvoie tous les conseillers contenus dans la base de donnée
     *
     * @return Liste des conseillers
     */
    public static List<Conseiller> obtenirConseillers() {
        List<Conseiller> l = null;

        try {
            JpaUtil.creerEntityManager();

            try {
                JpaUtil.ouvrirTransaction();

                l = ConseillerDAO.obtenirConseillers();

                JpaUtil.validerTransaction();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                JpaUtil.annulerTransaction();

            } finally {
                JpaUtil.fermerEntityManager();

            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return l;
    }

    /**
     * Methode statique qui permet de rechercher le conseiller le mieux adapté pour un client a partir du voyage qu'il veut faire On choisit toujours le conseiller le moins surbooké pour répartir au
     * mieux les clients.
     *
     * @param c Client
     * @param v Voyage pour lequel on recherche le conseiller
     * @return Conseiller adapté
     */
    public static Conseiller rechercherBonConseillerPourVoyage(Voyage v) {
        Conseiller conseiller;

        String codeVoyage = v.getCodeVoyage();


        //on regarde un conseiller qui peut le conseiller sur ce pays
        List<Conseiller> l = Service.obtenirConseillers(v.getPaysVoyage());


        //Sinon on en prend aléatoirement, Si il n'y a pas de conseiller pour ce pays
        if (l.isEmpty()) {
            List<Conseiller> listeConseillersTotaux = Service.obtenirConseillers();
            int conseillerID = Aleatoire.random(listeConseillersTotaux.size());
            conseiller = listeConseillersTotaux.get(conseillerID);
            return conseiller;
        }

        conseiller = l.get(0);
        for (Conseiller conseillerListe : l) {
            if (conseillerListe.getListeClients().size() < conseiller.getListeClients().size()) {
                conseiller = conseillerListe;
            }
        }


        return conseiller;
    }

    /**
     * Methode qui permet de savoir si le mot de passe entré est bien le bon pour ce conseiller
     *
     * @param c Conseiller
     * @param mdp mot de passe supposé
     * @return vrai si bon mot de passe, faux sinon
     */
    public static boolean verifierMdpConseiller(Conseiller c, String mdp) {
        if (mdp.equals(c.getMdp())) {
            return true;
        }
        return false;
    }
    ////----------------------Methodes Relatives aux Partenaires Commerciaux---------------------//

    /**
     *
     * Methode statique qui fait persister un PartenaireCommercial dans la base de donnée
     *
     * @param d PartenaireCommercial a creer
     *
     */
    public static void creerPartenaireCommercial(PartenaireCommercial d) {
        try {
            JpaUtil.creerEntityManager();

            try {
                JpaUtil.ouvrirTransaction();

                PartenaireCommercialDAO.persist(d);

                JpaUtil.validerTransaction();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                JpaUtil.annulerTransaction();

            } finally {
                JpaUtil.fermerEntityManager();

            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    /**
     *
     * Methode statique qui met à jour un Partenaire Commercial dans la base de donnée
     *
     * @param c PartenaireCommercial a mettre a jour
     *
     */
    public static void updatePartenaireCommercial(PartenaireCommercial d) {
        try {
            JpaUtil.creerEntityManager();

            try {
                JpaUtil.ouvrirTransaction();

                PartenaireCommercialDAO.merge(d);

                JpaUtil.validerTransaction();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                JpaUtil.annulerTransaction();

            } finally {
                JpaUtil.fermerEntityManager();

            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    /**
     *
     * Methode statique qui supprime un Partenaire Commercial dans la base de donnée
     *
     * @param c Partenaire Commercial a supprimer
     *
     */
    public static void supprimerPartenaireCommercial(PartenaireCommercial d) {
        try {
            JpaUtil.creerEntityManager();

            try {
                JpaUtil.ouvrirTransaction();

                PartenaireCommercialDAO.remove(d);

                JpaUtil.validerTransaction();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                JpaUtil.annulerTransaction();

            } finally {
                JpaUtil.fermerEntityManager();

            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    /**
     * Methode statique qui renvoie la liste de tous les partenaires commerciaux enregistrés (utile si le client accepte d’être alerté).
     *
     * @return Liste des partenaires commerciaux
     */
    public static List<PartenaireCommercial> obtenirPartenaireCommerciaux() {

        List<PartenaireCommercial> l = null;
        try {
            JpaUtil.creerEntityManager();

            try {
                JpaUtil.ouvrirTransaction();

                l = PartenaireCommercialDAO.obtenirPartenaireCommerciaux();


                JpaUtil.validerTransaction();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                JpaUtil.annulerTransaction();

            } finally {
                JpaUtil.fermerEntityManager();

            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

        return l;
    }

    ////-----------------------------Methodes Relatives aux Devis-------------------------------//
    /**
     *
     * Methode statique qui fait persister un devis dans la base de donnée
     *
     * @param d Devis a creer
     *
     */
    public static void creerDevis(Devis d) {
        try {
            JpaUtil.creerEntityManager();

            try {
                JpaUtil.ouvrirTransaction();


                DevisDAO.persist(d);
                JpaUtil.validerTransaction();
                JpaUtil.fermerEntityManager();

                d.getClient().ajoutConseiller(d.getConseiller());
                d.getConseiller().ajouterClient(d.getClient());
                Service.updateClient(d.getClient());
                Service.updateConseiller(d.getConseiller());

            } catch (Exception e) {
                e.printStackTrace(System.err);
                JpaUtil.annulerTransaction();
                JpaUtil.fermerEntityManager();

            } finally {
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }


    }

    /**
     *
     * Methode statique qui met à jour un Devis dans la base de donnée
     *
     * @param c Devis a mettre a jour
     *
     */
    public static void updateDevis(Devis d) {
        try {
            JpaUtil.creerEntityManager();

            try {
                JpaUtil.ouvrirTransaction();


                DevisDAO.merge(d);

                JpaUtil.validerTransaction();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                JpaUtil.annulerTransaction();

            } finally {
                JpaUtil.fermerEntityManager();

            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    /**
     *
     * Methode statique qui supprime un Devis dans la base de donnée
     *
     * @param c Devis a supprimer
     *
     */
    public static void supprimerDevis(Devis d) {
        try {
            JpaUtil.creerEntityManager();

            try {
                JpaUtil.ouvrirTransaction();


                DevisDAO.remove(d);

                JpaUtil.validerTransaction();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                JpaUtil.annulerTransaction();

            } finally {
                JpaUtil.fermerEntityManager();

            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    /**
     * Methode qui permet d'obtenir tous les devis contenus dans la base de donnée
     *
     * @return Liste des devis
     */
    public static List<Devis> obtenirDevis() {
        List<Devis> l = null;
        try {
            JpaUtil.creerEntityManager();

            try {
                JpaUtil.ouvrirTransaction();

                l = DevisDAO.obtenirDevis();


                JpaUtil.validerTransaction();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                JpaUtil.annulerTransaction();

            } finally {
                JpaUtil.fermerEntityManager();

            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return l;
    }

    /**
     * Methode qui permet de rechercher les devis relatifs a un client
     *
     * @param c Client dont on recherche les Devis
     * @return Liste des devis
     */
    public static List<Devis> obtenirDevis(Client c) {
        List<Devis> l = null;
        try {
            JpaUtil.creerEntityManager();

            try {
                JpaUtil.ouvrirTransaction();

                l = DevisDAO.rechercherDevis(c);


                JpaUtil.validerTransaction();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                JpaUtil.annulerTransaction();

            } finally {
                JpaUtil.fermerEntityManager();

            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

        return l;
    }

    /**
     * Methode statique qui permet de calculer le prix d'un devis
     *
     * @param d Devis dont on veux calculer le prix
     * @return prix du devis
     */
    public static int calculPrixDevis(Devis d) {
        return d.getPrix();
    }

    /**
     * Methode qui simule l'envoi d'un mail a un client
     *
     * @param c Client a qui envoyer le mail
     */
    public static void envoyerMail(Client c) {
        for (PartenaireCommercial pC : Service.obtenirPartenaireCommerciaux()) {
            String s = "Expediteur : ifroutard@ifroutard.com \n";
            s += "Pour : " + pC.getEmail() + "\n";
            s += "Sujet : nouveau client \n";
            s += "Corps : \n";
            s += "nom : " + c.getNom().toUpperCase() + "\n";
            s += "prenom : " + c.getPrenom() + "\n";
            s += "adresse mail : " + c.getEmail() + "\n";

            System.out.println(s);
        }
    }
}
