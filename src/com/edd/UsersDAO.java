package com.edd;

import java.util.ArrayList;
import java.util.HashMap;

public class UsersDAO {
	static private ArrayList<User> listeUtilisateur = new ArrayList<User>();

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
			// A t'on d�j� un utilisateur ayant le m�me nom ?
			if (utilisateur.getEmail().equalsIgnoreCase(newUtil.getEmail())) {
				System.out.println("Email utilisateurs d�j� connu : " + utilisateur.getEmail());
				// Si c'est le m�me password : On refuse l'ajout.
				if (utilisateur.getPassword().equalsIgnoreCase(newUtil.getPassword())) {
					msgString = "Ajout refus� car il existe un utilisateur ayant le m�me email et le m�me pwd";
					System.out.println(msgString);
					ajoutPossible = false;
					throw new Exception(msgString);

				} else {
					// M�me nom mais pas m�me password : on mets � jour le mot
					// de passe
					if (utilisateur.getName().equalsIgnoreCase(newUtil.getName())) {
						utilisateur.setPassword(newUtil.getPassword());
						msgString = "Ajout refus� car il existe un utilisateur ayant les m�mes email et nom mais avec un pwd diff�rent => mise � jour pwd de l'utilisateur existant";
						System.out.println(msgString);
						ajoutPossible = false;
						throw new Exception(msgString);
					}
				}
			}
		}
		// Si les controles se sont bien pass�s : On ajoute l'utilisateur
		if (ajoutPossible) {
			listeUtilisateur.add(newUtil);
			System.out.println("Ajout du nouvel utilisateur : " + newUtil.getName() + " / " + newUtil.getPassword() + " / " + newUtil.getEmail());
		}

		return ajoutPossible;
	}

	public static void initListeUser() {
		if(listeUtilisateur.isEmpty()){
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

	public static void deleteUser(String loginSearched) {
		if(!listeUtilisateur.isEmpty()){
			for (User utilisateur : listeUtilisateur) {
				System.out.println("parcours liste des utilisateurs pour suppression de :" + loginSearched);
				if (!"".equals(loginSearched)){
					if (utilisateur.getEmail().equalsIgnoreCase(loginSearched)) {
						listeUtilisateur.remove(utilisateur);
						System.out.println("suppression de :" + utilisateur);
						break;
					}
				}
			}
		}

	}
}
