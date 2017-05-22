package com.edd.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.edd.Entity.Adresse;
import com.edd.Entity.ConditionsTrajet;
import com.edd.Entity.Route;
import com.edd.Entity.User;

public class UsersDAO {
	static private ArrayList<User> listeUtilisateur = new ArrayList<User>();
	static private EntityManagerFactory emf = Persistence.createEntityManagerFactory("LoloCar");
	static private EntityManager em = emf.createEntityManager();
	static private EntityTransaction transaction = em.getTransaction() ;

	public UsersDAO() {

	}

	static public boolean ajouteUtilisateur(String nomUtil, String pwdUtil, String email, boolean fumeur, int nbCovoitureurs, String voie, String cp, String ville, double longitude, double lattitude, String nomMarker, int index, boolean isConducteur, boolean estSelectionne)  throws Exception{
		if ((nomUtil != null) && (pwdUtil != null)) {
			// TODO (inserted by : JFYVART / [11 mai 2017, 13:55:22] Modif new champs
			User newUtil = new User(nomUtil, pwdUtil, email, true, 1, nomMarker, nomMarker, nomMarker, lattitude, lattitude, nomMarker, index, estSelectionne, estSelectionne);
			if (ajouteUtilisateur(newUtil)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	static public boolean ajouteUtilisateur(User newUtil) throws Exception {
		boolean ajoutPossible = true;
		String msgString = "";
		for (User utilisateur : listeUtilisateur) {
			System.out.println("parcours liste des utilisateurs pour ajout");
			// A t'on déjà un utilisateur ayant le même nom ?
			if (utilisateur.getEmail().equalsIgnoreCase(newUtil.getEmail())) {
				System.out.println("Email utilisateurs déjà connu : " + utilisateur.getEmail());
				// Si c'est le même password : On refuse l'ajout.
				if (utilisateur.getPassword().equalsIgnoreCase(newUtil.getPassword())) {
					msgString = "Ajout refusé car il existe un utilisateur ayant le même email et le même pwd";
					System.out.println(msgString);
					ajoutPossible = false;
					throw new Exception(msgString);

				} else {
					// Même nom mais pas même password : on mets à jour le mot
					// de passe
					if (utilisateur.getName().equalsIgnoreCase(newUtil.getName())) {
						utilisateur.setPassword(newUtil.getPassword());
						msgString = "Ajout refusé car il existe un utilisateur ayant les mêmes email et nom mais avec un pwd différent => mise à jour pwd de l'utilisateur existant";
						System.out.println(msgString);
						ajoutPossible = false;
						throw new Exception(msgString);
					}
				}
			}
		}
		// Si les controles se sont bien passés : On ajoute l'utilisateur
		if (ajoutPossible) {
			listeUtilisateur.add(newUtil);
			System.out.println("Ajout du nouvel utilisateur : " + newUtil.getName() + " / " + newUtil.getPassword() + " / " + newUtil.getEmail());
		}

		return ajoutPossible;
	}

	public static void initListeUser() {
		// Si aucun utilisateur n'est en base : On la remplit manuellement.
		if(listeUtilisateur.isEmpty()){
			try {
				User newUser1 =new User("Laurent Palmier","123456789", "Laurent.Palmier@Magnus.fr", true, 1,"Place de la mairie", "31470", "Fonsorbes", 43.533329, 1.23333,"Laurent Palmier", 0, false, false);

				ajouteUtilisateur(newUser1);
				System.out.println("user1 :" + newUser1);

				User newUser2 =new User("JF Yvart","123456789", "JF.Yvart@Magnus.fr", true, 1,"8 impasse du Cinsault", "31470", "Saint Lys", 43.51667, 1.2,"",1,true,false );
				ajouteUtilisateur(newUser2);
				System.out.println("user2 :" + newUser2);

				User newUser3 =new User("Sybille Cazaux","123456789", "Sybille.Cazaux@Magnus.fr", false, 1, "Place de la mairie", "31000", "Toulouse", 43.6042600, 1.4436700,"",2,false, false );
				ajouteUtilisateur(newUser3);
				System.out.println("user3 :" + newUser3);

				User newUser4 =new User("Berger - Levrault","123456789", "help.Covoiturage@Magnus.fr", false, 1, "64 av Edmond Rostand", "31000", "Toulouse", 43.533329, 1.53333,"",3,true, false );
				ajouteUtilisateur(newUser4);
				System.out.println("user4 :" + newUser4);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}


	private static void getUserFromBDD() {
		Query q=em.createQuery("SELECT * FROM USERS u ");
		User newUser;
		Adresse adresseUser;
		ConditionsTrajet conditionsTrajetUser;
		Route covoiturageProposeUser;

		transaction.begin();
		List<ResultSet> rs= q.getResultList();
		for (ResultSet resultSet : rs) {
			newUser = new User();
			newUser.setName(((User)resultSet).getName());
			newUser.setEmail(((User)resultSet).getEmail());
			newUser.setId(((User)resultSet).getId());
			newUser.setPassword(((User)resultSet).getPassword());
			newUser.setConducteur(((User)resultSet).isConducteur());
			newUser.setAdresseUser(((User)resultSet).getAdresseUser());
			newUser.setConditionsTrajet(((User)resultSet).getConditionsTrajet());
			newUser.setCovoituragePropose(((User)resultSet).getCovoituragePropose());

			try {
				ajouteUtilisateur(newUser);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("user1 :" + newUser);
		}
		transaction.commit();
	}

	public static HashMap<String, User> fillHashMapWithListUsers(String nameSearched){
		HashMap<String, User> Users = new HashMap<String, User>();
		if(listeUtilisateur.isEmpty()){
			initListeUser();
		}
		for (User utilisateur : listeUtilisateur) {
			System.out.println("parcours liste des utilisateurs pour remplissage HashMap");
			if (!"".equals(nameSearched)){
				if (utilisateur.getName().equalsIgnoreCase(nameSearched)) {
					Users.put(utilisateur.getEmail(), utilisateur);
				}
			} else {
				Users.put(utilisateur.getEmail(), utilisateur);
			}

		}
		return Users;
	}


	public static Boolean isUserConnected(String email, String pwd){
		boolean response = false;
		if(listeUtilisateur.isEmpty()){
			initListeUser();
		}
		for (User utilisateur : listeUtilisateur) {
			System.out.println("parcours liste des utilisateurs pour recherche utilisateur");
			if ((!"".equals(email))&&(!"".equals(pwd))){
				if (utilisateur.getEmail().equalsIgnoreCase(email)) {
					if (utilisateur.getPassword().equalsIgnoreCase(pwd)) {
						response = true;
					}
				}
			}

		}
		return response;
	}

	public static Long getIdUserConnected(String email, String pwd){
		Long idUser = 0L;
		if(listeUtilisateur.isEmpty()){
			initListeUser();
		}
		for (User utilisateur : listeUtilisateur) {
			System.out.println("parcours liste des utilisateurs pour recherche utilisateur");
			if ((!"".equals(email))&&(!"".equals(pwd))){
				if (utilisateur.getEmail().equalsIgnoreCase(email)) {
					if (utilisateur.getPassword().equalsIgnoreCase(pwd)) {
						idUser = utilisateur.getId();
					}
				}
			}

		}
		return idUser;
	}


	public static User getUserById(Long idUser){
		User userSearched = null;
		if(listeUtilisateur.isEmpty()){
			initListeUser();
		}
		for (User utilisateur : listeUtilisateur) {
			System.out.println("parcours liste des utilisateurs pour recherche utilisateur");
			if (utilisateur.getId() == (idUser)) {
				userSearched = utilisateur;
			}
		}
		return userSearched;
	}

	public static boolean deleteUser(String nameSearched) {
		boolean result = false;
		if(!listeUtilisateur.isEmpty()){
			for (User utilisateur : listeUtilisateur) {
				System.out.println("parcours liste des utilisateurs pour suppression de :" + nameSearched);
				if (!"".equals(nameSearched)){
					if (utilisateur.getName().equalsIgnoreCase(nameSearched)) {
						listeUtilisateur.remove(utilisateur);
						delUserFromBDD(utilisateur.getId());
						System.out.println("suppression de :" + utilisateur);
						result = true;
						break;
					}
				}
			}
		}

		return result;

	}

	private static void delUserFromBDD(Long id) {
		Query q=em.createQuery("DELETE FROM USERS u WHERE u.id = :idUser");
		q.setParameter("idUser", id);
		transaction.begin();
		q.executeUpdate();
		transaction.commit();
	}

	public static void modifyUser(User userModifie){
		for (User utilisateur : listeUtilisateur) {
			System.out.println("parcours liste des utilisateurs pour suppression de :" + userModifie.getName());
			if (!"".equals(userModifie.getName())){
				if (utilisateur.getName().equalsIgnoreCase(userModifie.getName())) {
					utilisateur = userModifie;
					System.out.println("suppression de :" + userModifie.getName());
					break;
				}
			}
		}
	}

}
