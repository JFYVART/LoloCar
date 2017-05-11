package com.edd;

import java.util.Date;

public class User {

	private String name;
	private String password;
	private String email;
	private boolean fumeur;
	private int nbCovoitureurs;
	private Date dateCovoiturage;


	public User() {

	}

	public User(String nom, String pwd, String email, boolean fumeur, int nbCovoitureurs) {
		this.name = nom;
		this.password = pwd;
		this.email = email;
		this.fumeur = fumeur;
		this.nbCovoitureurs = nbCovoitureurs;
		this.dateCovoiturage = new Date();
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


	protected void setFumeur(boolean fumeur) {
		this.fumeur = fumeur;
	}

	protected void setNbCovoitureurs(int nbCovoitureurs) {
		this.nbCovoitureurs = nbCovoitureurs;
	}

	protected void setDateCovoiturage(Date dateCovoiturage) {
		this.dateCovoiturage = dateCovoiturage;
	}

	public boolean isFumeur() {
		return this.fumeur;
	}

	public int getNbCovoitureurs() {
		return this.nbCovoitureurs;
	}

	public Date getDateCovoiturage() {
		return this.dateCovoiturage;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected void setPassword(String password) {
		this.password = password;
	}
	protected void setEmail(String email) {
		this.email = email;
	}

}
