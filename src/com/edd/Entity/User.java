package com.edd.Entity;

import java.io.Serializable;

public class User implements Serializable {
	private Long id;
	private String name;
	private String password;
	private String email;
	private ConditionsTrajet conditionsTrajet;
	private Adresse adresseUser;
	private Route covoituragePropose;
	private boolean isConducteur;

	private static final long serialVersionUID = 1L;


	public User() {

	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		System.out.println("name" + name);
		System.out.println("othername" + other.name);
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	public User(String nom, String pwd, String email, boolean fumeur, int nbCovoitureurs, String voie, String cp, String ville, double longitude, double lattitude, String nomMarker, int index, boolean isConducteur, boolean estSelectionne) {
		this.id = 0L;
		this.name = nom;
		this.password = pwd;
		this.email = email;
		this.conditionsTrajet = new ConditionsTrajet(nbCovoitureurs, fumeur);
		this.isConducteur = isConducteur;
		//  Cr�ation de l'adresse et du marker associ�
		if ("".equalsIgnoreCase(nomMarker)){
			this.adresseUser = new Adresse(voie, cp, ville,longitude, lattitude, nom,index, isConducteur, estSelectionne) {
			};
		} else {
			this.adresseUser = new Adresse(voie, cp, ville,longitude, lattitude, nomMarker,index, isConducteur, estSelectionne);
		}

		// cr�ation si besoin de la route (covoiturage)
		if (isConducteur) {
			this.covoituragePropose = new Route(nbCovoitureurs, this.conditionsTrajet, this, this.adresseUser.getMarkerAdresse());
		}

	}

	public User(String nom, String pwd, String email) {
		this.name = nom;
		this.password = pwd;
		this.email = email;
	}


	public String getName() {
		return this.name;
	}

	public String getPassword() {
		return this.password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public ConditionsTrajet getConditionsTrajet() {
		return this.conditionsTrajet;
	}

	public void setConditionsTrajet(ConditionsTrajet conditionsTrajet) {
		this.conditionsTrajet = conditionsTrajet;
	}

	public Adresse getAdresseUser() {
		return this.adresseUser;
	}

	public void setAdresseUser(Adresse adresseUser) {
		this.adresseUser = adresseUser;
	}

	public Route getCovoituragePropose() {
		return this.covoituragePropose;
	}

	public void setCovoituragePropose(Route covoituragePropose) {
		this.covoituragePropose = covoituragePropose;
	}

	public boolean getIsConducteur() {
		return this.isConducteur;
	}

	public void setIsConducteur(boolean isConducteur) {
		this.isConducteur = isConducteur;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString(){
		String response = "Nom :" + this.name + ", eMail :" + this.email + ", fumeur :" + this.conditionsTrajet.isFumeur() + ", nb passagers : " + this.conditionsTrajet.getNbCovoitureurs() + ", conducteur :" + this.isConducteur;
		return response;
	}

}
