package com.edd.Entity;

import java.util.HashMap;

public class Route {

	private int nbParticpant;
	private HashMap<String, Marker> listeParticipant;
	private HashMap<Integer, Marker> routeCovoiturage;
	private ConditionsTrajet conditionsCovoiturage;
	private User conducteur;
	private Marker depart;
	private Marker arrivee = Marker.travail;

	public Route(int nbParticpant, ConditionsTrajet conditionsCovoiturage, User conducteur, Marker depart) {
		this.conditionsCovoiturage = conditionsCovoiturage;
		this.conducteur = conducteur;
		this.nbParticpant = nbParticpant;
		this.depart = depart;
		this.listeParticipant = new HashMap<String, Marker>();
		this.routeCovoiturage = new HashMap<Integer, Marker>();
		// On ajoute le conducteur comme point de départ
		this.listeParticipant.put(conducteur.getName(), depart);
		this.routeCovoiturage.put(0,depart);
		// On ajoute également l'arrivée.
		this.routeCovoiturage.put(nbParticpant+1,this.arrivee);

	}

	public int getNbParticpant() {
		return this.nbParticpant;
	}

	protected void setNbParticpant(int nbParticpant) {
		this.nbParticpant = nbParticpant;
	}

	public HashMap<String, Marker> getListeParticipant() {
		return this.listeParticipant;
	}

	protected void setListeParticipant(HashMap<String, Marker> listeParticipant) {
		this.listeParticipant = listeParticipant;
	}

	public HashMap<Integer, Marker> getRouteCovoiturage() {
		return this.routeCovoiturage;
	}

	protected void setRouteCovoiturage(HashMap<Integer, Marker> routeCovoiturage) {
		this.routeCovoiturage = routeCovoiturage;
	}

	public ConditionsTrajet getConditionsCovoiturage() {
		return this.conditionsCovoiturage;
	}

	protected void setConditionsCovoiturage(ConditionsTrajet conditionsCovoiturage) {
		this.conditionsCovoiturage = conditionsCovoiturage;
	}

	public User getConducteur() {
		return this.conducteur;
	}

	protected void setConducteur(User conducteur) {
		this.conducteur = conducteur;
	}

	public Marker getDepart() {
		return this.depart;
	}

	protected void setDepart(Marker depart) {
		this.depart = depart;
	}

	public Marker getArrivee() {
		return this.arrivee;
	}

	protected void setArrivee(Marker arrivee) {
		this.arrivee = arrivee;
	}




}
