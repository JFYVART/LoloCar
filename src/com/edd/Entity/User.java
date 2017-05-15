package com.edd.Entity;

public class User {


	private String name;
	private String password;
	private String email;
	private ConditionsTrajet conditionsTrajet;
	private Adresse adresseUser;
	private Route covoituragePropose;
	private boolean isConducteur;


	public User() {

	}

	public User(String nom, String pwd, String email, boolean fumeur, int nbCovoitureurs, String voie, String cp, String ville, double longitude, double lattitude, String nomMarker, int index, boolean isConducteur, boolean estSelectionne) {
		this.name = nom;
		this.password = pwd;
		this.email = email;
		this.conditionsTrajet = new ConditionsTrajet(nbCovoitureurs, fumeur);
		this.isConducteur = isConducteur;
		//  Création de l'adresse et du marker associé
		if ("".equalsIgnoreCase(nomMarker)){
			this.adresseUser = new Adresse(voie, cp, ville,longitude, lattitude, nom,index, isConducteur, estSelectionne) {
			};
		} else {
			this.adresseUser = new Adresse(voie, cp, ville,longitude, lattitude, nomMarker,index, isConducteur, estSelectionne);
		}

		// création si besoin de la route (covoiturage)
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

	protected void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	protected void setEmail(String email) {
		this.email = email;
	}

	public ConditionsTrajet getConditionsTrajet() {
		return this.conditionsTrajet;
	}

	protected void setConditionsTrajet(ConditionsTrajet conditionsTrajet) {
		this.conditionsTrajet = conditionsTrajet;
	}

	public Adresse getAdresseUser() {
		return this.adresseUser;
	}

	protected void setAdresseUser(Adresse adresseUser) {
		this.adresseUser = adresseUser;
	}

	public Route getCovoituragePropose() {
		return this.covoituragePropose;
	}

	public void setCovoituragePropose(Route covoituragePropose) {
		this.covoituragePropose = covoituragePropose;
	}

	public boolean isConducteur() {
		return this.isConducteur;
	}

	public void setConducteur(boolean isConducteur) {
		this.isConducteur = isConducteur;
	}

	@Override
	public String toString(){
		String response = "Nom :" + this.name + ", eMail :" + this.email + ", fumeur :" + this.conditionsTrajet.isFumeur() + ", nb passagers : " + this.conditionsTrajet.getNbCovoitureurs() + ", conducteur :" + this.isConducteur;
		return response;
	}

}
