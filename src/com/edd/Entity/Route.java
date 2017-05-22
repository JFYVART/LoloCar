package com.edd.Entity;

import java.io.Serializable;

public class Route implements Serializable {
	private Long id;
	private int nbParticpant;
	//	@ElementCollection
	//	@CollectionTable(name="MARKER_PARTICIPANT")
	//	@MapKeyJoinColumn(name="NAME")
	//	@Column(name="PARTICIPANT")
	//	private Map<String, Marker> listeParticipant;
	//	@ElementCollection
	//	@CollectionTable(name="MARKER_COVOITURAGE")
	//	@MapKeyJoinColumn(name="POSITION")
	//	@Column(name="POSITIONROUTE")
	//	private Map<Integer, Marker> routeCovoiturage;
	private ConditionsTrajet conditionsCovoiturage;
	private User conducteur;
	private Marker depart;
	private Marker arrivee = Marker.travail;

	private static final long serialVersionUID = 1L;

	public Route(int nbParticpant, ConditionsTrajet conditionsCovoiturage, User conducteur, Marker depart) {
		this.conditionsCovoiturage = conditionsCovoiturage;
		this.conducteur = conducteur;
		this.nbParticpant = nbParticpant;
		this.depart = depart;
		//		this.listeParticipant = new HashMap<String, Marker>();
		//		this.routeCovoiturage = new HashMap<Integer, Marker>();
		//		// On ajoute le conducteur comme point de départ
		//		this.listeParticipant.put(conducteur.getName(), depart);
		//		this.routeCovoiturage.put(0,depart);
		//		// On ajoute également l'arrivée.
		//		this.routeCovoiturage.put(nbParticpant+1,this.arrivee);

	}

	public Route(){

	}

	public int getNbParticpant() {
		return this.nbParticpant;
	}

	public void setNbParticpant(int nbParticpant) {
		this.nbParticpant = nbParticpant;
	}

	//	public Map<String, Marker> getListeParticipant() {
	//		return this.listeParticipant;
	//	}
	//
	//	public void setListeParticipant(Map<String, Marker> listeParticipant) {
	//		this.listeParticipant = listeParticipant;
	//	}
	//
	//	public Map<Integer, Marker> getRouteCovoiturage() {
	//		return this.routeCovoiturage;
	//	}
	//
	//	public void setRouteCovoiturage(Map<Integer, Marker> routeCovoiturage) {
	//		this.routeCovoiturage = routeCovoiturage;
	//	}

	public ConditionsTrajet getConditionsCovoiturage() {
		return this.conditionsCovoiturage;
	}

	public void setConditionsCovoiturage(ConditionsTrajet conditionsCovoiturage) {
		this.conditionsCovoiturage = conditionsCovoiturage;
	}

	public User getConducteur() {
		return this.conducteur;
	}

	public void setConducteur(User conducteur) {
		this.conducteur = conducteur;
	}

	public Marker getDepart() {
		return this.depart;
	}

	public void setDepart(Marker depart) {
		this.depart = depart;
	}

	public Marker getArrivee() {
		return this.arrivee;
	}

	public void setArrivee(Marker arrivee) {
		this.arrivee = arrivee;
	}


	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


}
