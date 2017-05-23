package com.edd.DAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import com.edd.Entity.User;

public class UserTrajetDAO {
	static private ArrayList<User> listeUtilisateurTrajetHaut = new ArrayList<User>();
	static private ArrayList<User> listeUtilisateurTrajetBas = new ArrayList<User>();

	public static ArrayList<User> getListeUtilisateurTrajetHaut() {
		return listeUtilisateurTrajetHaut;
	}

	public static ArrayList<User> getListeUtilisateurTrajetBas() {
		return listeUtilisateurTrajetBas;
	}

	public UserTrajetDAO() {
	}

	static private boolean ajouteUtilisateurHaut(User newUtil) throws Exception {
		boolean ajoutPossible = true;
		String msgString = "";
		listeUtilisateurTrajetHaut.add(newUtil);
		System.out.println("Ajout du nouvel utilisateur : " + newUtil.getName() + " / " + newUtil.getPassword() + " / "
				+ newUtil.getEmail());
		return true;
	}

	static public boolean ajouteUtilisateurBas(User newUtil) throws Exception {
		boolean ajoutPossible = true;
		String msgString = "";
		listeUtilisateurTrajetBas.add(newUtil);
		System.out.println("Ajout du nouvel utilisateur : " + newUtil.getName() + " / " + newUtil.getPassword() + " / "
				+ newUtil.getEmail());
		return true;
	}

	public static void initListeUserHaut() {
		if (listeUtilisateurTrajetHaut.isEmpty()) {
			try {
				User newUser1 = new User("Laurent Palmier", "", "Laurent.Palmier@Magnus.fr", true, 1,
						"Place de la mairie", "31470", "Fonsorbes", 43.533329, 1.23333, "Laurent Palmier", 0, false,
						false);				
				if (listeUtilisateurTrajetBas.contains(newUser1)) {
					
				} else {				
					ajouteUtilisateurHaut(newUser1);
				}				

				User newUser2 = new User("JF Yvart", "", "JF.Yvart@Magnus.fr", true, 1, "8 impasse du Cinsault",
						"31470", "Saint Lys", 43.51667, 1.2, "", 1, true, false);
				
				if (listeUtilisateurTrajetBas.contains(newUser2)) {					
				} else {				
					ajouteUtilisateurHaut(newUser2);
				}
				
				User newUser3 = new User("Sybille Cazaux", "", "Sybille.Cazaux@Magnus.fr", false, 1,
						"Place de la mairie", "31000", "Toulouse", 43.6042600, 1.4436700, "", 2, false, false);
				if (listeUtilisateurTrajetBas.contains(newUser3)) {					
				} else {	
					ajouteUtilisateurHaut(newUser3);
				}
				

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void initListeUserBas() {
		if (listeUtilisateurTrajetBas.isEmpty()) {
			try {
				User newUser1 = new User("Laurent Palmier", "", "Laurent.Palmier@Magnus.fr", true, 1,
						"Place de la mairie", "31470", "Fonsorbes", 43.533329, 1.23333, "Laurent Palmier", 0, false,
						false);

				ajouteUtilisateurBas(newUser1);
				System.out.println("user1 bas :" + newUser1);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void fillHashMapWithListUsersHaut(String nameSearched) {
		if (listeUtilisateurTrajetHaut.isEmpty()) {
			initListeUserHaut();
		}
		for (User utilisateur : listeUtilisateurTrajetHaut) {
			if (!"".equals(nameSearched)) {
				if (utilisateur.getName().equalsIgnoreCase(nameSearched)) {
					if (listeUtilisateurTrajetHaut.contains(nameSearched)) {
					} else {
						listeUtilisateurTrajetHaut.add(utilisateur);
					}
				}
				// } else {
				// listeUtilisateurTrajetHaut.add(utilisateur);
			}

		}
	}

	public static void addToUserBas(String nameSearched) {

		for (User utilisateur : listeUtilisateurTrajetHaut) {

			if (utilisateur.getEmail().equalsIgnoreCase(nameSearched)) {				
				listeUtilisateurTrajetBas.add(utilisateur);
			}
		}
	}

	public static void addToUserHaut(String nameSearched) {
		for (User utilisateur : listeUtilisateurTrajetBas) {
			if (utilisateur.getEmail().equalsIgnoreCase(nameSearched)) {
				listeUtilisateurTrajetHaut.add(utilisateur);
			}

		}
	}

	public static void deleteUserHaut(String nameSearched) {
		if (!listeUtilisateurTrajetHaut.isEmpty()) {
			for (User utilisateur : listeUtilisateurTrajetHaut) {
				if (nameSearched.length() != 0) {
					if (utilisateur.getEmail().equalsIgnoreCase(nameSearched)) {
						listeUtilisateurTrajetHaut.remove(utilisateur);
						break;
					}
				}
			}
		}
	}

	public static void deleteUserBas(String nameSearched) {
		if (!listeUtilisateurTrajetBas.isEmpty()) {
			for (User utilisateur : listeUtilisateurTrajetBas) {
				System.out.println("parcours liste des utilisateurs pour suppression de :" + nameSearched);
				if (nameSearched.length() != 0) {
					if (utilisateur.getEmail().equalsIgnoreCase(nameSearched)) {
						listeUtilisateurTrajetBas.remove(utilisateur);
						System.out.println("suppression de :" + utilisateur);
						break;
					}
				}
			}
		}
	}

}
