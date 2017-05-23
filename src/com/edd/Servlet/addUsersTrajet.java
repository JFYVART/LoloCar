package com.edd.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edd.DAO.UserTrajetDAO;
import com.edd.Entity.User;

/**
 * Servlet implementation class addUsersTrajet
 */
@WebServlet("/addUsersTrajet")
public class addUsersTrajet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    private final String URL_NAME = "Trajet.jsp";

	public static final String CHAMP_EMAIL = "emailUtilisateur";
	public static final String CHAMP_EMAILTOADD = "emailUserToAdd";
	
	public static final String CHAMP_EMAILTODEL = "emailUserToDel";
	private String emailtoadd;
	private String emailtodel;
	private String email;

	
      
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
		UserTrajetDAO.initListeUserHaut();
		
		request.setAttribute("usershaut", UserTrajetDAO.getListeUtilisateurTrajetHaut());		
		
		request.setAttribute("usersbas",UserTrajetDAO.getListeUtilisateurTrajetBas());		
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
		
		this.emailtodel = request.getParameter(CHAMP_EMAILTODEL);
		request.setAttribute(CHAMP_EMAILTODEL, this.emailtodel);	
			
		
		UserTrajetDAO.addToUserBas(this.emailtoadd);
		UserTrajetDAO.deleteUserHaut(this.emailtoadd);	
		System.out.println("post mail à ajouter en haut par suppression :" + this.emailtodel);
		UserTrajetDAO.addToUserHaut(this.emailtodel);
		UserTrajetDAO.deleteUserBas(this.emailtodel);	
		
		request.setAttribute("usershaut", UserTrajetDAO.getListeUtilisateurTrajetHaut());
		request.setAttribute("usersbas", UserTrajetDAO.getListeUtilisateurTrajetBas());
		PrintWriter out = response.getWriter();
		// Ouverture de la page ListUsers
		request.getRequestDispatcher(this.URL_NAME).forward(request, response);
	}

}
