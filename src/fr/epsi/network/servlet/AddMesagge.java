package fr.epsi.network.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.network.beans.Message;
import fr.epsi.network.beans.User;
import fr.epsi.network.service.MessageService;
import fr.epsi.network.service.UserService;

/**
 * Servlet implementation class AddMesagge
 */
@WebServlet("/pages/addMessage")
public class AddMesagge extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MessageService messageService = new MessageService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMesagge() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int status = Integer.parseInt(request.getParameter("status"));
		User user = (User) request.getSession().getAttribute("user");
		
		Timestamp timestamp = new Timestamp(new Date().getTime());
		
		Message message = new Message(null, title, content, user,timestamp, timestamp, status);
		messageService.addMessage(message);
		
		request.getRequestDispatcher("/messages").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
