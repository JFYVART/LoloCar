package com.edd.Entity;

public class Adresse {
	private String voie;
	private String cp;
	private String ville;
	private PAYS pays;
	private Marker markerAdresse;

	public Marker getMarkerAdresse() {
		return this.markerAdresse;
	}

	protected void setMarkerAdresse(Marker markerAdresse) {
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

	public String getVoie() {
		return this.voie;
	}

	public String getCp() {
		return this.cp;
	}

	public String getVille() {
		return this.ville;
	}

	public PAYS getPays() {
		return this.pays;
	}

	protected void setVoie(String voie) {
		this.voie = voie;
	}

	protected void setCp(String cp) {
		this.cp = cp;
	}

	protected void setVille(String ville) {
		this.ville = ville;
	}

	protected void setPays(PAYS pays) {
		this.pays = pays;
	}


}
