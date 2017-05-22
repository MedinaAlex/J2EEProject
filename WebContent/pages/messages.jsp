<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="java.util.List, fr.epsi.network.beans.Message, fr.epsi.network.beans.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajout d'un message</title>
</head>
<body>
<% 
	User user = (User) request.getSession().getAttribute("user");
	if(user.getAdministrator()){
		out.println("<a href='/myEpsi/Admin'>Administrer</a>") ;
	}
%>
<a href="/myEpsi/pages/addMessage.jsp">Ajouter un message</a>
<br>
Voici la liste des messages :
<%
	List<Message> messages = (List<Message>) request.getSession().getAttribute("messages");
	

	for(Message message : messages){
		out.println("<br><br>");
		
		out.println("titre = " + message.getTitle());
		out.println("<br>");
		out.println("message = " + message.getContent());
		out.println("<br>");
		if (user.getId() == message.getAuthor().getId()){
			out.println("<a href='/myEpsi/supprimerMessage?id=" + message.getId() +"'>Supprimer le message</a>") ;
		}
		
		
		
	}

%>


</body>
</html>