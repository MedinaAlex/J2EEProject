<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, fr.epsi.network.beans.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
</head>
<body>
<%
	List<User> users = (List<User>) request.getSession().getAttribute("users");
	

	for(User user : users){
		out.println("<br><br>");
		
		out.println("id = " + user.getId());
		out.println("<br>");
		if(!user.getAdministrator()){
			out.println("<a href='/myEpsi/supprimerUser?id=" + user.getId() +"'>Supprimer l'utilisateur</a>") ;
		}
	}

%>

</body>
</html>