package com.edd;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/listeUsers")

/**
 * Servlet implementation class ConnectUserServlet
 */
public class listeUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final String URL_NAME = "ListUser.jsp";

	public static final String CHAMP_EMAIL = "emailUtilisateur";
	private String email;
	public static final String CHAMP_MSG_UTIL = "msgUtilisateur";
	public static final String CHAMP_MSG_UTIL_AFFICHAGE = "msgHide";


	public static final String MSG_AFFICHAGE_VISIBLE = "bg-success col-sm-12";
	public static final String MSG_AFFICHAGE_HIDDEN = "hidden";

	HashMap<String, User> Users = new HashMap<String, User>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public listeUsers() {
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
		// Ouverture de la page Welcome
		request.getRequestDispatcher(this.URL_NAME).forward(request, response);
		System.out.println("do get listeUsers");
		UsersDAO.initListeUser();
	}




	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* Récupération des champs du formulaire. */
		this.email = request.getParameter(CHAMP_EMAIL);
		request.setAttribute(CHAMP_EMAIL, this.email);

		this.Users = UsersDAO.fillHashMapWithListUsers(this.email);

		request.setAttribute("users", this.Users);
		System.out.println("user list :" + this.Users);
		PrintWriter out = response.getWriter();
		// Ouverture de la page ListUsers
		request.getRequestDispatcher(this.URL_NAME).forward(request, response);

	}

}
