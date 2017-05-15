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


@WebServlet("/modify")

/**
 * Servlet implementation class ConnectUserServlet
 */
public class modify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Champs USER
	private String motDePasse1;
	private String motDePasse2;
	private String nom;
	private String email;
	public static final String CHAMP_PASS1 = "pwd1Utilisateur";
	public static final String CHAMP_PASS2 = "pwd2Utilisateur";
	public static final String CHAMP_NOM = "nameUtilisateur";
	public static final String CHAMP_EMAIL = "emailUtilisateur";

	// Champs Conditions trajet
	private boolean fumeur;
	private int nbCovoitureurs;
	public static final String CHAMP_FUMEUR = "fumeurUtilisateur";
	public static final String CHAMP_NBCOVOITURES = "nbCovoituresUtilisateur";

	// Champs Adresse
	private String voie;
	private String cp;
	private String ville;
	public static final String CHAMP_VOIE = "voieUtilisateur";
	public static final String CHAMP_CP = "cpUtilisateur";
	public static final String CHAMP_VILLE = "villeUtilisateur";
	//Champs Marker associé à l'adresse
	private double longitude;
	private double lattitude;
	private String nomMarker;
	private int index;
	private boolean isConducteur;
	private boolean estSelectionne;
	public static final String CHAMP_LONGITUDE = "longitudeUtilisateur";
	public static final String CHAMP_LATTITUDE = "lattitudeUtilisateur";
	public static final String CHAMP_NOMMARKER = "nomMarkerUtilisateur";
	public static final String CHAMP_INDEX = "indexUtilisateur";
	public static final String CHAMP_ISCONDUCTEUR = "isConducteurUtilisateur";
	public static final String CHAMP_ISSELECTIONNE = "isSelectionneUtilisateur";


	private Cookie[] allCookies;
	private final String DATE_COOKIE_KEY = "DATE_COOKIE_KEY";
	private final String COUNT_COOKIE_KEY = "COUNT_COOKIE_KEY";

	private final String URL_NAME = "WEB-INF/ModifyUser.jsp";


	public static final String CHAMP_FORM = "form";
	public static final String CHAMP_ERRORS = "errors";
	public static final String CHAMP_ERROR_STATUS = "errorStatus";

	public static final String CHAMP_ERROR_PWD_AFFICHAGE = "errorPwdHide";
	public static final String CHAMP_ERROR_EMAIL_AFFICHAGE = "errorEmailHide";

	public static final String CHAMP_MSG_UTIL = "msgUtilisateur";
	public static final String CHAMP_MSG_UTIL_AFFICHAGE = "msgHide";


	public static final String ERROR_AFFICHAGE_VISIBLE = "alert alert-danger alert-dismissable col-sm-9";
	public static final String ERROR_AFFICHAGE_HIDDEN = "hidden";

	public static final String MSG_AFFICHAGE_VISIBLE = "bg-success col-sm-12";
	public static final String MSG_AFFICHAGE_HIDDEN = "hidden";
	String teString;

	Map<String, String> errors = new HashMap<String, String>();
	Map<String, String> form = new HashMap<String, String>();



	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public modify() {
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
		request.setAttribute(CHAMP_MSG_UTIL_AFFICHAGE, MSG_AFFICHAGE_HIDDEN);
		// On remplit le dom avec les nouveaux attributs !!!
		request.setAttribute(CHAMP_ERROR_EMAIL_AFFICHAGE, MSG_AFFICHAGE_HIDDEN);
		request.setAttribute(CHAMP_ERROR_PWD_AFFICHAGE, MSG_AFFICHAGE_HIDDEN);
		request.setAttribute(CHAMP_ERROR_STATUS, true);
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
		this.motDePasse1 = request.getParameter(CHAMP_PASS1);
		this.motDePasse2 = request.getParameter(CHAMP_PASS2);
		this.nom = request.getParameter(CHAMP_NOM);
		this.email = request.getParameter(CHAMP_EMAIL);

		this.fumeur = new Boolean(request.getParameter(CHAMP_FUMEUR)).booleanValue();
		this.nbCovoitureurs = new Integer(request.getParameter(CHAMP_NBCOVOITURES)).intValue();

		// Champs Adresse
		this.voie = request.getParameter(CHAMP_VOIE);
		this.cp = request.getParameter(CHAMP_CP);
		this.ville = request.getParameter(CHAMP_VILLE);

		//Champs Marker associé à l'adresse
		this.longitude = new Double(request.getParameter(CHAMP_LONGITUDE)).doubleValue();
		this.lattitude =  new Double(request.getParameter(CHAMP_LATTITUDE)).doubleValue();
		this.nomMarker = request.getParameter(CHAMP_NOMMARKER);
		this.index = new Integer(request.getParameter(CHAMP_INDEX)).intValue();
		this.isConducteur = new Boolean(request.getParameter(CHAMP_ISCONDUCTEUR)).booleanValue();
		this.estSelectionne = new Boolean(request.getParameter(CHAMP_ISSELECTIONNE)).booleanValue();


		// TODO (inserted by : JFYVART / [11 mai 2017, 13:54:45] Modifier les params fumeurs et nb covoiturerurs !!!!
		User newUser=new User(this.nom,this.motDePasse1, this.email, false, 1, this.nomMarker, this.nomMarker, this.nomMarker, this.lattitude, this.lattitude, this.nomMarker, this.index, this.estSelectionne, this.estSelectionne);
		request.setAttribute("newUser", newUser);

		// Remplissage du hashmap  form
		this.form.put(CHAMP_EMAIL, this.email);
		this.form.put(CHAMP_NOM, this.nom);
		// Réinit des erreurs.
		this.errors = new HashMap<String, String>();

		// On remplit le dom avec les nouveaux attributs !!!
		request.setAttribute(CHAMP_ERROR_EMAIL_AFFICHAGE, MSG_AFFICHAGE_HIDDEN);
		request.setAttribute(CHAMP_ERROR_PWD_AFFICHAGE, MSG_AFFICHAGE_HIDDEN);

		// récupération des cookies
		String lastDate = null;
		int compteur = 0;
		String msString = "";
		this.allCookies=request.getCookies();
		// parcours pour trouver la date sauvegardée.
		if (this.allCookies != null) {
			for (int i = 0; i < this.allCookies.length; i++) {
				Cookie cookie = this.allCookies[i];
				if(cookie.getName().equals(this.DATE_COOKIE_KEY + "_" + this.nom )){
					lastDate=URLDecoder.decode(cookie.getValue(), "UTF-8");
				} else if(cookie.getName().equals(this.COUNT_COOKIE_KEY+"_" + this.nom )){
					compteur=Integer.parseInt(URLDecoder.decode(cookie.getValue(), "UTF-8"));
				}
			}
		}

		PrintWriter out = response.getWriter();

		// Vérification des passmords
		boolean pwdValidated = true;
		request.setAttribute(CHAMP_MSG_UTIL, "");
		request.setAttribute(CHAMP_MSG_UTIL_AFFICHAGE, MSG_AFFICHAGE_HIDDEN);
		// On remplit le dom avec les nouveaux attributs !!!
		request.setAttribute(CHAMP_FORM, this.form);
		request.setAttribute(CHAMP_ERRORS, this.errors);

		try {
			pwdValidated = this.validatePwd(this.motDePasse1, this.motDePasse2);
		} catch (Exception e) {
			this.errors.put(CHAMP_PASS1, e.getMessage());
			request.setAttribute(CHAMP_ERROR_PWD_AFFICHAGE, MSG_AFFICHAGE_VISIBLE);
			request.setAttribute(CHAMP_ERROR_STATUS, true);
			msString =e.getMessage();
			request.getRequestDispatcher(this.URL_NAME).forward(request, response);
			pwdValidated = false;
		}

		boolean userValidated = true;
		try {
			if (pwdValidated) {
				userValidated = UsersDAO.ajouteUtilisateur(this.nom, this.motDePasse1, this.email, true, 1, this.nomMarker, this.nomMarker, this.nomMarker, this.lattitude, this.lattitude, this.nomMarker, this.index, this.estSelectionne, this.estSelectionne);
			}
		} catch (Exception e) {
			this.errors.put(CHAMP_PASS1, e.getMessage());
			request.setAttribute(CHAMP_ERROR_PWD_AFFICHAGE, MSG_AFFICHAGE_VISIBLE);
			request.setAttribute(CHAMP_ERROR_EMAIL_AFFICHAGE, MSG_AFFICHAGE_VISIBLE);
			request.setAttribute(CHAMP_ERROR_STATUS, true);
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
			Cookie myCookie=new Cookie(this.DATE_COOKIE_KEY+"_" + this.nom, URLEncoder.encode(currentDate, "UTF-8"));
			response.addCookie(myCookie);
			// Création d'un nouveau Cookie nombre de visite
			compteur = compteur + 1 ;
			myCookie = new Cookie(this.COUNT_COOKIE_KEY+"_" + this.nom , "" + compteur);
			response.addCookie(myCookie);
			request.setAttribute(CHAMP_ERROR_STATUS, false);

		}

		System.out.println(msString);
		request.setAttribute(CHAMP_MSG_UTIL, msString);
		request.setAttribute(CHAMP_MSG_UTIL_AFFICHAGE, MSG_AFFICHAGE_VISIBLE);
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
