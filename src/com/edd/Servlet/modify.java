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

	private final String URL_NAME = "WEB-INF/ModifyUser.jsp";
	private final String URL_NAME_Acueil = "Index.jsp";

	private Cookie[] allCookies;

	String teString;
	Long idUser = 0L;
	User userSearched;

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
		String idUserStr = request.getParameter(Constantes.CHAMP_IDUSERCONNECTED);
		System.out.println("Identifiant lu :" + this.idUser );
		if (idUserStr != null){
			this.idUser = new Long(request.getParameter(Constantes.CHAMP_IDUSERCONNECTED));

		}
		else{
			this.idUser = 2L;
			this.userSearched = UsersDAO.getUserById(this.idUser);
		}

		System.out.println("Identifiant lu :" + this.idUser );
		request.setAttribute(Constantes.CHAMP_ERRORCONNECT_STATUS,false);
		request.setAttribute("newUser", this.userSearched);
		/* Récupération des champs du formulaire. */
		request.setAttribute(Constantes.CHAMP_MSG_UTIL_AFFICHAGE, Constantes.MSG_AFFICHAGE_HIDDEN);
		// On remplit le dom avec les nouveaux attributs !!!
		request.setAttribute(Constantes.CHAMP_ERROR_EMAIL_AFFICHAGE, Constantes.MSG_AFFICHAGE_HIDDEN);
		request.setAttribute(Constantes.CHAMP_ERROR_PWD_AFFICHAGE, Constantes.MSG_AFFICHAGE_HIDDEN);
		request.setAttribute(Constantes.CHAMP_ERROR_STATUS, true);
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
		request.setAttribute("newUser", this.userSearched);

		// Remplissage du hashmap  form
		this.form.put(Constantes.CHAMP_EMAIL, this.userSearched.getEmail());
		this.form.put(Constantes.CHAMP_NOM, this.userSearched.getName());
		this.form.put(Constantes.CHAMP_NOM, this.userSearched.getName());
		request.setAttribute(Constantes.CHAMP_ERRORCONNECT_STATUS,false);

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
		boolean userDeleted = true;
		request.setAttribute(Constantes.CHAMP_MSG_UTIL, "");
		request.setAttribute(Constantes.CHAMP_MSG_UTIL_AFFICHAGE, Constantes.MSG_AFFICHAGE_HIDDEN);
		// On remplit le dom avec les nouveaux attributs !!!
		request.setAttribute(Constantes.CHAMP_FORM, this.form);
		request.setAttribute(Constantes.CHAMP_ERRORS, this.errors);

		try {
			userDeleted = UsersDAO.deleteUser(this.userSearched.getName());
		} catch (Exception e) {
			this.errors.put(Constantes.CHAMP_PASS1, e.getMessage());
			request.setAttribute(Constantes.CHAMP_ERROR_PWD_AFFICHAGE, Constantes.MSG_AFFICHAGE_VISIBLE);
			request.setAttribute(Constantes.CHAMP_ERROR_STATUS, true);
			msString =e.getMessage();
			request.getRequestDispatcher(this.URL_NAME).forward(request, response);
			userDeleted = false;
		}

		if (userDeleted) {
			msString = "Votre compte vient d'être supprimé.";
			request.setAttribute(Constantes.CHAMP_ERRORCONNECT_STATUS,true);
			// Création d'un nouveau Cookie date
			String currentDate=(new Date()).toString();
			Cookie myCookie=new Cookie(Constantes.DATE_COOKIE_KEY+"_" + this.nom, URLEncoder.encode(currentDate, "UTF-8"));
			response.addCookie(myCookie);
			// Création d'un nouveau Cookie nombre de visite
			compteur = compteur + 1 ;
			myCookie = new Cookie(Constantes.COUNT_COOKIE_KEY+"_" + this.nom , "" + compteur);
			response.addCookie(myCookie);
			request.setAttribute(Constantes.CHAMP_ERROR_STATUS, false);
			System.out.println(msString);
			request.setAttribute(Constantes.CHAMP_MSG_UTIL, msString);
			request.setAttribute(Constantes.CHAMP_MSG_UTIL_AFFICHAGE, Constantes.MSG_AFFICHAGE_VISIBLE);
			// Ouverture de la page Welcome
			request.getRequestDispatcher(this.URL_NAME).forward(request, response);

		} else {
			msString = "Impossible de supprimer le compte";
			System.out.println(msString);
			request.setAttribute(Constantes.CHAMP_MSG_UTIL, msString);
			request.setAttribute(Constantes.CHAMP_MSG_UTIL_AFFICHAGE, Constantes.MSG_AFFICHAGE_VISIBLE);
			//		request.setAttribute("pwdValidated", pwdValidated);

			// Ouverture de la page Welcome
			request.getRequestDispatcher(this.URL_NAME).forward(request, response);
		}

	}

}
