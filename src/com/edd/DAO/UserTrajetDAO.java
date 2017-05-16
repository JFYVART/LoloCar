package com.edd.DAO;

import java.util.ArrayList;
import java.util.HashMap;

import com.edd.Entity.User;

public class UserTrajetDAO {
	static private ArrayList<User> listeUtilisateurTrajetComplete = new ArrayList<User>();
	static private ArrayList<User> listeUtilisateurTrajetModifie = new ArrayList<User>();
	public UserTrajetDAO() {		
	}
	
	static public boolean ajouteUtilisateur(String nomUtil, String pwdUtil, String email, boolean fumeur, int nbCovoitureurs, String voie, String cp, String ville, double longitude, double lattitude, String nomMarker, int index, boolean isConducteur, boolean estSelectionne)  throws Exception{
		if ((nomUtil != null) && (pwdUtil != null)) {
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
		for (User utilisateur : listeUtilisateurTrajetComplete) {
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
			listeUtilisateurTrajetComplete.add(newUtil);
			System.out.println("Ajout du nouvel utilisateur : " + newUtil.getName() + " / " + newUtil.getPassword() + " / " + newUtil.getEmail());
		}

		return ajoutPossible;
	}

	public static void initListeUser() {
		if(listeUtilisateurTrajetComplete.isEmpty()){
			try {
				User newUser1 =new User("Laurent Palmier","", "Laurent.Palmier@Magnus.fr", true, 1,"Place de la mairie", "31470", "Fonsorbes", 43.533329, 1.23333,"Laurent Palmier", 0, false, false);

				ajouteUtilisateur(newUser1);
				System.out.println("user1 :" + newUser1);

				User newUser2 =new User("JF Yvart","", "JF.Yvart@Magnus.fr", true, 1,"8 impasse du Cinsault", "31470", "Saint Lys", 43.51667, 1.2,"",1,true,false );
				ajouteUtilisateur(newUser2);
				System.out.println("user2 :" + newUser2);

				User newUser3 =new User("Sybille Cazaux","", "Sybille.Cazaux@Magnus.fr", false, 1, "Place de la mairie", "31000", "Toulouse", 43.6042600, 1.4436700,"",2,false, false );
				ajouteUtilisateur(newUser3);
				System.out.println("user3 :" + newUser3);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static HashMap<String, User> fillHashMapWithListUsers(String nameSearched){
		HashMap<String, User> Users = new HashMap<String, User>();
		if(listeUtilisateurTrajetComplete.isEmpty()){
			initListeUser();
		}
		for (User utilisateur : listeUtilisateurTrajetComplete) {
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

	public static void deleteUserTrajet(String nameSearched) {
		if(!listeUtilisateurTrajetComplete.isEmpty()){
			for (User utilisateur : listeUtilisateurTrajetComplete) {
				System.out.println("parcours liste des utilisateurs pour suppression de :" + nameSearched);
				//if (!"".equals(nameSearched)){
				if (nameSearched.length()!=0){					
					if (utilisateur.getEmail().equalsIgnoreCase(nameSearched)) {
						listeUtilisateurTrajetComplete.remove(utilisateur);
						System.out.println("suppression de :" + utilisateur);
						break;
					}
				}
			}
		}
	}

	public static void modifyUser(User userModifie){
		for (User utilisateur : listeUtilisateurTrajetComplete) {
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
