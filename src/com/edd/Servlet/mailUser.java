package com.edd.Servlet;

import java.awt.Desktop;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edd.DAO.UsersDAO;
import com.edd.Entity.User;


@WebServlet("/mailUser")

/**
 * Servlet implementation class ConnectUserServlet
 */
public class mailUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final String URL_NAME = "ListUser.jsp";

	public static final String CHAMP_EMAIL = "emailUtilisateur";
	public static final String CHAMP_EMAILTODELETE = "emailUserToDel";
	private String email;
	private String emailToDelete;
	public static final String CHAMP_MSG_UTIL = "msgUtilisateur";
	public static final String CHAMP_MSG_UTIL_AFFICHAGE = "msgHide";



	HashMap<String, User> Users = new HashMap<String, User>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public mailUser() {
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
		this.email = request.getParameter(CHAMP_EMAIL);
		request.setAttribute(CHAMP_EMAIL, this.email);
		this.emailToDelete = request.getParameter(CHAMP_EMAILTODELETE);
		System.out.println("Email to dleete : " + this.emailToDelete);
		if (!"".equals(this.emailToDelete)){
			this.generateMailUser();
		}
		this.Users = UsersDAO.fillHashMapWithListUsers(this.email);

		request.setAttribute("users", this.Users);
		System.out.println("user list :" + this.Users);
		PrintWriter out = response.getWriter();
		// Ouverture de la page ListUsers
		request.getRequestDispatcher(this.URL_NAME).forward(request, response);
	}


	private void generateMailUser(){
		String mailTo = "";
		URI uriMailTo = null;

		//Assembler l'url
		mailTo = "user@gmail.com";
		mailTo += "?subject=Test avec Java";
		mailTo += "&body=Envoyer un email avec Java";

		//Ouvrir le logiciel de messagerie par défaut
		if (Desktop.isDesktopSupported()) {
			if (Desktop.getDesktop().isSupported(Desktop.Action.MAIL)) {
				try {
					uriMailTo = new URI("mailto", mailTo, null);
					Desktop.getDesktop().mail(uriMailTo);
				} catch (IOException ex) {
					System.err.println("pb");
				} catch (URISyntaxException ex) {
					System.err.println("pb");
				}
			}
		}
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
