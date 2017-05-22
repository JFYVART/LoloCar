package com.edd.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Adresse implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String voie;
	private String cp;
	private String ville;
	private PAYS pays;
	private Marker markerAdresse;

	private static final long serialVersionUID = 1L;

	@OneToOne
	public Marker getMarkerAdresse() {
		return this.markerAdresse;
	}

	public void setMarkerAdresse(Marker markerAdresse) {
		this.markerAdresse = markerAdresse;
	}

	public static enum PAYS{
		FRANCE, ALLEMAGNE, ITALIE, ESPAGNE
	}

	public Adresse(String voie, String cp, String ville, double longitude, double lattitude, String nomMarker, int index, boolean isConducteur, boolean estSelectionne) {
		this.voie = voie;
		this.cp  =cp;
		this.ville = ville;
		this.pays = PAYS.FRANCE;
		this.markerAdresse = new Marker(longitude, lattitude, nomMarker,index, estSelectionne, isConducteur);
	}
	public Adresse() {
	}


	public String getVoie() {
		return this.voie;
	}

	public String getCp() {
		return this.cp;
	}

	public String getVille() {
		return this.ville;
	}

	@Enumerated(EnumType.ORDINAL)
	public PAYS getPays() {
		return this.pays;
	}

	public void setVoie(String voie) {
		this.voie = voie;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}


	public void setPays(PAYS pays) {
		this.pays = pays;
	}


	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
