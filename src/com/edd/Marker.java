package com.edd;

public class Marker {
	private double longitude;
	private double lattitude;
	private String nomBalise;
	private int index;
	private boolean faitPartieCovoiturage;
	private boolean estConducteur;

	public static final Marker travail = new Marker(43.533329, 1.53333, "Berger-Levrault", 99, false, false);

	public Marker() {
		this.longitude = 0f;
		this.lattitude = 0f;
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

	protected void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	protected void setLattitude(double lattitude) {
		this.lattitude = lattitude;
	}

	public String getNomBalise() {
		return this.nomBalise;
	}

	protected void setNomBalise(String nomBalise) {
		this.nomBalise = nomBalise;
	}

	public int getIndex() {
		return this.index;
	}

	protected void setIndex(int index) {
		this.index = index;
	}

	public boolean isFaitPartieCovoiturage() {
		return this.faitPartieCovoiturage;
	}

	protected void setFaitPartieCovoiturage(boolean faitPartieCovoiturage) {
		this.faitPartieCovoiturage = faitPartieCovoiturage;
	}

	public boolean isEstConducteur() {
		return this.estConducteur;
	}

	protected void setEstConducteur(boolean estConducteur) {
		this.estConducteur = estConducteur;
	}



}
