package fr.epsi.network.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import fr.epsi.network.beans.Message;
import fr.epsi.network.service.MessageService;

/**
 * Servlet implementation class supprimerMessage
 */
@WebServlet("/supprimerMessage")
public class supprimerMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MessageService messageService = new MessageService();
	
	private static Logger logger = LogManager.getLogger(supprimerMessage.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public supprimerMessage() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = (String) request.getParameter("id");
		logger.info(id);
		Message m = messageService.getMessage(Long.valueOf(id));
		
		logger.info(m);
		messageService.deleteMessage(m);
		
		request.getRequestDispatcher("/messages").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
