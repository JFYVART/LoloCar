package com.edd.Entity;

import java.util.Date;

public class ConditionsTrajet {

	private boolean fumeur;
	private int nbCovoitureurs;
	private Date dateCovoiturage;
	private int rayon;

	public static final int RAYON = 10;

	public ConditionsTrajet(int nbCovoitureurs, boolean fumeur) {
		this.fumeur = fumeur;
		this.nbCovoitureurs = nbCovoitureurs;
		this.dateCovoiturage = new Date();
		this.rayon = RAYON;
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

	public int getRayon() {
		return this.rayon;
	}

	public void setRayon(int rayon) {
		this.rayon = rayon;
	}

}
