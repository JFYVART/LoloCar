package com.edd.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edd.DAO.UsersDAO;


@WebServlet("/connect")

/**
 * Servlet implementation class ConnectUserServlet
 */
public class connect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Champs USER
	private String motDePasse1;
	private String email;
	public static final String CHAMP_PASS1 = "pwd1Utilisateur";
	public static final String CHAMP_EMAIL = "emailUtilisateur";

	private final String URL_NAME = "WEB-INF/ConnectUser.jsp";


	public static final String CHAMP_FORM = "form";
	public static final String CHAMP_ERRORS = "errors";
	public static final String CHAMP_ERROR_STATUS = "errorStatus";

	public static final String CHAMP_ERRORCONNECT_STATUS = "errorConnected";

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
	public connect() {
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
		request.setAttribute(CHAMP_ERRORCONNECT_STATUS, true);
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
		this.email = request.getParameter(CHAMP_EMAIL);
		boolean reponseOk = UsersDAO.isUserConnected(this.email, this.motDePasse1);

		// Remplissage du hashmap  form
		this.form.put(CHAMP_EMAIL, this.email);
		// Réinit des erreurs.
		this.errors = new HashMap<String, String>();

		// On remplit le dom avec les nouveaux attributs !!!
		request.setAttribute(CHAMP_ERROR_EMAIL_AFFICHAGE, MSG_AFFICHAGE_HIDDEN);
		request.setAttribute(CHAMP_ERROR_PWD_AFFICHAGE, MSG_AFFICHAGE_HIDDEN);

		String msString = "Bienvenue !!!";
		PrintWriter out = response.getWriter();

		request.setAttribute(CHAMP_MSG_UTIL, "");
		request.setAttribute(CHAMP_MSG_UTIL_AFFICHAGE, MSG_AFFICHAGE_HIDDEN);
		// On remplit le dom avec les nouveaux attributs !!!
		request.setAttribute(CHAMP_FORM, this.form);
		request.setAttribute(CHAMP_ERRORS, this.errors);


		if (!reponseOk){
			this.errors.put(CHAMP_PASS1, "couple (Login / password) inconnu");
			request.setAttribute(CHAMP_ERROR_PWD_AFFICHAGE, MSG_AFFICHAGE_VISIBLE);
			request.setAttribute(CHAMP_ERROR_EMAIL_AFFICHAGE, MSG_AFFICHAGE_VISIBLE);
			request.setAttribute(CHAMP_ERROR_STATUS, true);
			request.setAttribute(CHAMP_ERRORCONNECT_STATUS, true);
			msString ="couple (Login / password) inconnu";
			request.getRequestDispatcher(this.URL_NAME).forward(request, response);
		} else {
			request.setAttribute(CHAMP_ERRORCONNECT_STATUS, false);
		}

		System.out.println(msString);
		request.setAttribute(CHAMP_MSG_UTIL, msString);
		request.setAttribute(CHAMP_MSG_UTIL_AFFICHAGE, MSG_AFFICHAGE_VISIBLE);
		//		request.setAttribute("pwdValidated", pwdValidated);

		// Ouverture de la page Welcome
		request.getRequestDispatcher(this.URL_NAME).forward(request, response);

	}


}
