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
import com.edd.Entity.User;


@WebServlet("/connect")

/**
 * Servlet implementation class ConnectUserServlet
 */
public class connect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Champs USER
	private String motDePasse1;
	private String email;
	private User monUser;
	private Long idUser = 0L;

	private final String URL_NAME = "WEB-INF/ConnectUser.jsp";

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
		request.setAttribute(Constantes.CHAMP_IDUSERCONNECTED,0);
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
		this.email = request.getParameter(Constantes.CHAMP_EMAIL);
		boolean reponseOk = UsersDAO.isUserConnected(this.email, this.motDePasse1);

		// Remplissage du hashmap  form
		this.form.put(Constantes.CHAMP_EMAIL, this.email);
		// Réinit des erreurs.
		this.errors = new HashMap<String, String>();

		// On remplit le dom avec les nouveaux attributs !!!
		request.setAttribute(Constantes.CHAMP_ERROR_EMAIL_AFFICHAGE, Constantes.MSG_AFFICHAGE_HIDDEN);
		request.setAttribute(Constantes.CHAMP_ERROR_PWD_AFFICHAGE, Constantes.MSG_AFFICHAGE_HIDDEN);

		String msString = "Bienvenue !!!";
		PrintWriter out = response.getWriter();

		request.setAttribute(Constantes.CHAMP_MSG_UTIL, "");
		request.setAttribute(Constantes.CHAMP_MSG_UTIL_AFFICHAGE, Constantes.MSG_AFFICHAGE_HIDDEN);
		// On remplit le dom avec les nouveaux attributs !!!
		request.setAttribute(Constantes.CHAMP_FORM, this.form);
		request.setAttribute(Constantes.CHAMP_ERRORS, this.errors);
		request.setAttribute(Constantes.CHAMP_IDUSERCONNECTED, 0);


		if (reponseOk){
			this.idUser = UsersDAO.getIdUserConnected(this.email, this.motDePasse1);
			System.out.println("idUser connecté :" + this.idUser);
			request.setAttribute(Constantes.CHAMP_IDUSERCONNECTED,this.idUser );
			request.setAttribute(Constantes.CHAMP_ERRORCONNECT_STATUS, false);
		} else {
			request.setAttribute(Constantes.CHAMP_ERROR_PWD_AFFICHAGE, Constantes.MSG_AFFICHAGE_VISIBLE);
			msString = "Login ou mot de passe non reconnu !!!";
			request.setAttribute(Constantes.CHAMP_ERRORCONNECT_STATUS, true);
		}
		System.out.println(msString);
		request.setAttribute(Constantes.CHAMP_MSG_UTIL, msString);
		request.setAttribute(Constantes.CHAMP_MSG_UTIL_AFFICHAGE, Constantes.MSG_AFFICHAGE_VISIBLE);
		//		request.setAttribute("pwdValidated", pwdValidated);

		// Ouverture de la page Welcome
		request.getRequestDispatcher(this.URL_NAME + "?" + Constantes.CHAMP_IDUSERCONNECTED + this.idUser ).forward(request, response);

	}


}
