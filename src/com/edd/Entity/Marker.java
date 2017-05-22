package com.edd.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Marker implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double longitude;
	private Double lattitude;
	private String nomBalise;
	private int index;
	private boolean faitPartieCovoiturage;
	private boolean estConducteur;

	private static final long serialVersionUID = 1L;

	public static final Marker travail = new Marker(43.533329, 1.53333, "Berger-Levrault", 99, false, false);

	public Marker() {
		this.longitude = 0d;
		this.lattitude = 0d;
		this.nomBalise = "";
		this.index = 0;
		this.faitPartieCovoiturage = false;
		this.estConducteur = false;
	}

	public Marker(double longitude, double lattitude, String name){
		this.longitude = longitude;
		this.lattitude = lattitude;
		this.nomBalise = name;
		this.index = 0;
		this.faitPartieCovoiturage = false;
		this.estConducteur = false;

	}

	public Marker(double longitude, double lattitude, String name, int index, boolean faitPartieCovoiturage, boolean estConducteur){
		this.longitude = longitude;
		this.lattitude = lattitude;
		this.nomBalise = name;
		this.index = index;
		this.faitPartieCovoiturage = faitPartieCovoiturage;
		this.estConducteur = estConducteur;

	}

	public double getLongitude() {
		return this.longitude;
	}

	public double getLattitude() {
		return this.lattitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public void setLattitude(double lattitude) {
		this.lattitude = lattitude;
	}

	public String getNomBalise() {
		return this.nomBalise;
	}

	public void setNomBalise(String nomBalise) {
		this.nomBalise = nomBalise;
	}

	public int getIndex() {
		return this.index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public boolean isFaitPartieCovoiturage() {
		return this.faitPartieCovoiturage;
	}

	public void setFaitPartieCovoiturage(boolean faitPartieCovoiturage) {
		this.faitPartieCovoiturage = faitPartieCovoiturage;
	}

	public boolean isEstConducteur() {
		return this.estConducteur;
	}

	public void setEstConducteur(boolean estConducteur) {
		this.estConducteur = estConducteur;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
