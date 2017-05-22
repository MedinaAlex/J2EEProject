package fr.epsi.network.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.network.beans.Message;
import fr.epsi.network.beans.User;
import fr.epsi.network.service.MessageService;

/**
 * Servlet implementation class Messages
 */
@WebServlet("/messages")
public class MessagesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MessageService messageService = new MessageService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessagesServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Message> messages = new ArrayList<>();
		User user = (User) request.getSession().getAttribute("user");
		
		String id = request.getParameter("idMessage");
		if(id == null){
			messages = messageService.getListOfMessages(user);
		}else {
			messages.add(messageService.getMessage(Long.valueOf(id)));
		}
		request.getSession().setAttribute("messages", messages);
		request.getRequestDispatcher("/pages/messages.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
