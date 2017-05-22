package fr.epsi.network.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import fr.epsi.network.beans.User;
import fr.epsi.network.service.UserService;

/**
 * Servlet implementation class Connexion
 */
@WebServlet("/pages/connexion")
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = LogManager.getLogger(Connexion.class);
	
	UserService userService = new UserService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("content", "connexion");
		request.getRequestDispatcher("/index").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = userService.getUserById(request.getParameter("id"));
		
		if(user.getPassword().equals(request.getParameter("password"))){
			logger.info("go");
			request.getSession().setAttribute("user", user);
			request.setAttribute("content", "messages");
			request.getRequestDispatcher("/index").forward(request, response);
			
		}else{
			logger.info("pasgo");
			request.setAttribute("content", "connexion");
			request.getRequestDispatcher("/index").forward(request, response);
		}
	}

}
