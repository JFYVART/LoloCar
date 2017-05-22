package com.edd.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edd.DAO.UsersDAO;
import com.edd.Entity.User;


@WebServlet("/register")

/**
 * Servlet implementation class ConnectUserServlet
 */
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Champs USER
	private String motDePasse1;
	private String motDePasse2;
	private String nom;
	private String email;

	// Champs Conditions trajet
	private boolean fumeur;
	private int nbCovoitureurs;

	// Champs Adresse
	private String voie;
	private String cp;
	private String ville;
	//Champs Marker associé à l'adresse
	private double longitude;
	private double lattitude;
	private String nomMarker;
	private int index;
	private boolean isConducteur;
	private boolean estSelectionne;


	private Cookie[] allCookies;

	private final String URL_NAME = "WEB-INF/RegisterUser.jsp";

	String teString;

	Map<String, String> errors = new HashMap<String, String>();
	Map<String, String> form = new HashMap<String, String>();



	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* Récupération des champs du formulaire. */
		request.setAttribute(Constantes.CHAMP_MSG_UTIL_AFFICHAGE, Constantes.MSG_AFFICHAGE_HIDDEN);
		// On remplit le dom avec les nouveaux attributs !!!
		request.setAttribute(Constantes.CHAMP_ERROR_EMAIL_AFFICHAGE, Constantes.MSG_AFFICHAGE_HIDDEN);
		request.setAttribute(Constantes.CHAMP_ERROR_PWD_AFFICHAGE, Constantes.MSG_AFFICHAGE_HIDDEN);
		request.setAttribute(Constantes.CHAMP_ERROR_STATUS, true);
		request.setAttribute(Constantes.CHAMP_ERRORCONNECT_STATUS, true);
		// Ouverture de la page Welcome
		request.getRequestDispatcher(this.URL_NAME).forward(request, response);
	}




	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* Récupération des champs du formulaire. */
		this.motDePasse1 = request.getParameter(Constantes.CHAMP_PASS1);
		this.motDePasse2 = request.getParameter(Constantes.CHAMP_PASS2);
		this.nom = request.getParameter(Constantes.CHAMP_NOM);
		this.email = request.getParameter(Constantes.CHAMP_EMAIL);

		this.fumeur = new Boolean(request.getParameter(Constantes.CHAMP_FUMEUR)).booleanValue();
		this.nbCovoitureurs = new Integer(request.getParameter(Constantes.CHAMP_NBCOVOITURES)).intValue();

		// Champs Adresse
		this.voie = request.getParameter(Constantes.CHAMP_VOIE);
		this.cp = request.getParameter(Constantes.CHAMP_CP);
		this.ville = request.getParameter(Constantes.CHAMP_VILLE);

		//Champs Marker associé à l'adresse
		//this.longitude = new Double(request.getParameter(CHAMP_LONGITUDE)).doubleValue();
		//this.lattitude =  new Double(request.getParameter(CHAMP_LATTITUDE)).doubleValue();
		this.nomMarker = request.getParameter(Constantes.CHAMP_NOMMARKER);
		//this.index = new Integer(request.getParameter(CHAMP_INDEX)).intValue();
		this.isConducteur = new Boolean(request.getParameter(Constantes.CHAMP_ISCONDUCTEUR)).booleanValue();
		//this.estSelectionne = new Boolean(request.getParameter(CHAMP_ISSELECTIONNE)).booleanValue();


		// TODO (inserted by : JFYVART / [11 mai 2017, 13:54:45] Modifier les params fumeurs et nb covoiturerurs !!!!
		User newUser=new User(this.nom,this.motDePasse1, this.email, false, 1, this.nomMarker, this.nomMarker, this.nomMarker, this.lattitude, this.lattitude, this.nomMarker, this.index, this.estSelectionne, this.estSelectionne);
		request.setAttribute("newUser", newUser);
		System.out.println(newUser.toString());
		request.setAttribute(Constantes.CHAMP_ERRORCONNECT_STATUS, true);

		// Remplissage du hashmap  form
		this.form.put(Constantes.CHAMP_EMAIL, this.email);
		this.form.put(Constantes.CHAMP_NOM, this.nom);

		//		if (this.fumeur){
		//			this.form.put(CHAMP_FUMEUR, "Véhicule Fumeurs");
		//		}
		//
		//		if (this.isConducteur){
		//			this.form.put(CHAMP_ISCONDUCTEUR, "Vous proposez un covoiturage");
		//		} else {
		//			this.form.put(CHAMP_ISCONDUCTEUR, "Vous recherchez un covoiturage");
		//		}
		//
		//		this.form.put(CHAMP_VOIE,  this.voie);
		//		this.form.put(CHAMP_CP,  this.cp);
		//		this.form.put(CHAMP_VILLE, this.ville);


		// Réinit des erreurs.
		this.errors = new HashMap<String, String>();

		// On remplit le dom avec les nouveaux attributs !!!
		request.setAttribute(Constantes.CHAMP_ERROR_EMAIL_AFFICHAGE, Constantes.MSG_AFFICHAGE_HIDDEN);
		request.setAttribute(Constantes.CHAMP_ERROR_PWD_AFFICHAGE, Constantes.MSG_AFFICHAGE_HIDDEN);

		// récupération des cookies
		String lastDate = null;
		int compteur = 0;
		String msString = "";
		this.allCookies=request.getCookies();
		// parcours pour trouver la date sauvegardée.
		if (this.allCookies != null) {
			for (int i = 0; i < this.allCookies.length; i++) {
				Cookie cookie = this.allCookies[i];
				if(cookie.getName().equals(Constantes.DATE_COOKIE_KEY + "_" + this.nom )){
					lastDate=URLDecoder.decode(cookie.getValue(), "UTF-8");
				} else if(cookie.getName().equals(Constantes.COUNT_COOKIE_KEY+"_" + this.nom )){
					compteur=Integer.parseInt(URLDecoder.decode(cookie.getValue(), "UTF-8"));
				}
			}
		}

		PrintWriter out = response.getWriter();

		// Vérification des passmords
		boolean pwdValidated = true;
		request.setAttribute(Constantes.CHAMP_MSG_UTIL, "");
		request.setAttribute(Constantes.CHAMP_MSG_UTIL_AFFICHAGE, Constantes.MSG_AFFICHAGE_HIDDEN);
		// On remplit le dom avec les nouveaux attributs !!!
		request.setAttribute(Constantes.CHAMP_FORM, this.form);
		request.setAttribute(Constantes.CHAMP_ERRORS, this.errors);
		request.setAttribute(Constantes.CHAMP_IDUSERCONNECTED, 0);

		try {
			pwdValidated = this.validatePwd(this.motDePasse1, this.motDePasse2);
		} catch (Exception e) {
			this.errors.put(Constantes.CHAMP_PASS1, e.getMessage());
			request.setAttribute(Constantes.CHAMP_ERROR_PWD_AFFICHAGE, Constantes.MSG_AFFICHAGE_VISIBLE);
			request.setAttribute(Constantes.CHAMP_ERROR_STATUS, true);
			msString =e.getMessage();
			request.getRequestDispatcher(this.URL_NAME).forward(request, response);
			pwdValidated = false;
		}

		boolean userValidated = true;
		User userToCreate = new User(this.nom, this.motDePasse1, this.email, true, 1, this.nomMarker, this.nomMarker, this.nomMarker, this.lattitude, this.lattitude, this.nomMarker, this.index, this.estSelectionne, this.estSelectionne);
		try {
			if (pwdValidated) {
				userValidated = UsersDAO.ajouteUtilisateur(userToCreate);
			}
		} catch (Exception e) {
			this.errors.put(Constantes.CHAMP_PASS1, e.getMessage());
			request.setAttribute(Constantes.CHAMP_ERROR_PWD_AFFICHAGE, Constantes.MSG_AFFICHAGE_VISIBLE);
			request.setAttribute(Constantes.CHAMP_ERROR_EMAIL_AFFICHAGE, Constantes.MSG_AFFICHAGE_VISIBLE);
			request.setAttribute(Constantes.CHAMP_ERROR_STATUS, true);
			msString =e.getMessage();
			request.getRequestDispatcher(this.URL_NAME).forward(request, response);
			pwdValidated = false;
		}



		if ((pwdValidated)&&(userValidated)) {
			if (compteur > 0){
				msString = msString +" - Vous êtes déjà venu " + compteur + " fois";
			} else{
				msString = msString + "- Vous n'êtes jamais encore venu : Bienvenue !!! ";
			}
			if (lastDate != null){
				msString = msString + ", votre dernière visite était le : " + lastDate;
			}

			// Création d'un nouveau Cookie date
			String currentDate=(new Date()).toString();
			Cookie myCookie=new Cookie(Constantes.DATE_COOKIE_KEY+"_" + this.nom, URLEncoder.encode(currentDate, "UTF-8"));
			response.addCookie(myCookie);
			// Création d'un nouveau Cookie nombre de visite
			compteur = compteur + 1 ;
			myCookie = new Cookie(Constantes.COUNT_COOKIE_KEY+"_" + this.nom , "" + compteur);
			response.addCookie(myCookie);
			request.setAttribute(Constantes.CHAMP_ERROR_STATUS, false);
			request.setAttribute(Constantes.CHAMP_ERRORCONNECT_STATUS, false);
			request.setAttribute(Constantes.CHAMP_IDUSERCONNECTED, userToCreate.getId());

		}

		System.out.println(msString);
		request.setAttribute(Constantes.CHAMP_MSG_UTIL, msString);
		request.setAttribute(Constantes.CHAMP_MSG_UTIL_AFFICHAGE, Constantes.MSG_AFFICHAGE_VISIBLE);
		//		request.setAttribute("pwdValidated", pwdValidated);

		// Ouverture de la page Welcome
		request.getRequestDispatcher(this.URL_NAME).forward(request, response);

	}

	private boolean validatePwd(String motDePasse12, String motDePasse22) throws Exception{
		if (!motDePasse12.equals(motDePasse22)){
			throw new Exception("Le mot de passe et sa confirmation ne sont pas identiques !!!");
		}

		return true;

	}

}
