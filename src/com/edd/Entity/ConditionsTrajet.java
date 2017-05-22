package com.edd.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ConditionsTrajet implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private boolean fumeur;
	private int nbCovoitureurs;
	@Temporal(TemporalType.DATE)
	private Date dateCovoiturage;
	private int rayon;

	public static final int RAYON = 10;
	private static final long serialVersionUID = 1L;

	public ConditionsTrajet(int nbCovoitureurs, boolean fumeur) {
		this.fumeur = fumeur;
		this.nbCovoitureurs = nbCovoitureurs;
		this.dateCovoiturage = new Date();
		this.rayon = RAYON;
	}
	public ConditionsTrajet() {
	}

	public void setFumeur(boolean fumeur) {
		this.fumeur = fumeur;
	}

	public void setNbCovoitureurs(int nbCovoitureurs) {
		this.nbCovoitureurs = nbCovoitureurs;
	}

	public void setDateCovoiturage(Date dateCovoiturage) {
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


	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
