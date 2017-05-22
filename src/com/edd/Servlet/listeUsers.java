package com.edd.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edd.DAO.UsersDAO;
import com.edd.Entity.User;


@WebServlet("/listeUsers")

/**
 * Servlet implementation class ConnectUserServlet
 */
public class listeUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final String URL_NAME = "ListUser.jsp";

	private String email;

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
		request.setAttribute(Constantes.CHAMP_MSG_UTIL_AFFICHAGE, Constantes.MSG_AFFICHAGE_HIDDEN);
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
		this.email = request.getParameter(Constantes.CHAMP_EMAIL);
		request.setAttribute(Constantes.CHAMP_EMAIL, this.email);

		this.Users = UsersDAO.fillHashMapWithListUsers(this.email);

		request.setAttribute("users", this.Users);
		System.out.println("user list :" + this.Users);
		PrintWriter out = response.getWriter();
		// Ouverture de la page ListUsers
		request.getRequestDispatcher(this.URL_NAME).forward(request, response);

	}

}
