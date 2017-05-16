package com.edd;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addUsersTrajet
 */
@WebServlet("/addUsersTrajet")
public class addUsersTrajet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    private final String URL_NAME = "Trajet.jsp";

	public static final String CHAMP_EMAIL = "emailUtilisateur";
	public static final String CHAMP_EMAILTOADD = "emailUserToAdd";
	private String emailtoadd;
	private String email;
	public static final String CHAMP_MSG_AJOUT = "ajoutUtilisateur";
	public static final String CHAMP_MSG_UTIL_AFFICHAGE = "msgHide";


	public static final String MSG_AFFICHAGE_VISIBLE = "bg-success col-sm-12";
	public static final String MSG_AFFICHAGE_HIDDEN = "hidden";
	
	HashMap<String, User> Users = new HashMap<String, User>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addUsersTrajet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Récupération des champs du formulaire. */
		this.Users = UsersDAO.fillHashMapWithListUsers("");
		request.setAttribute("users", this.Users);
		System.out.println("remplissage");
		PrintWriter out = response.getWriter();
		// Ouverture de la page ListUsers
		request.getRequestDispatcher(this.URL_NAME).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Récupération des champs du formulaire. */
		System.out.println("test post");
		
		this.emailtoadd = request.getParameter(CHAMP_EMAILTOADD);
		request.setAttribute(CHAMP_EMAILTOADD, this.emailtoadd);
		UsersDAO.deleteUser(this.emailtoadd);
		System.out.println("liste a supprimer :" + this.emailtoadd);
		this.Users = UsersDAO.fillHashMapWithListUsers("");

		request.setAttribute("users", this.Users);
		System.out.println("post list :" + this.Users);
		PrintWriter out = response.getWriter();
		// Ouverture de la page ListUsers
		request.getRequestDispatcher(this.URL_NAME).forward(request, response);
	}

}
