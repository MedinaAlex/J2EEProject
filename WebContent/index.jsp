<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/myEpsi/lib/css/bootstrap.min.css">
<link rel="stylesheet" href="/myEpsi/lib/css/bootstrap-theme.min.css">
<script src="/myEpsi/lib/js/jquery-3.2.1.min.js"></script>
<script src="/myEpsi/lib/js/bootstrap.min.js"></script>
<title>index.html</title>
</head>
<body>

<%
boolean logged = (boolean)request.getAttribute("logged");
String content = (String)request.getAttribute("content");
%>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<a href="/myEpsi"><h1>myEpsi</h1></a>
		</div>
	</div>
	<div class="row">
	<% if (logged) { %>
		<div class="col-xs-4">Déconnexion</div>
	<% } else { %>
		<div class="col-xs-4"><a href="/myEpsi/pages/connexion">Connexion</a></div>
		<div class="col-xs-4"><a href="/myEpsi/pages/register">Inscription</a></div>
	<% } %>
	</div>
</div>



<div class="col-xs-4" style="border:2px solid red">
user : ${user}
</div>
<div class="col-xs-4" style="border:2px solid red">
content : ${content}
</div>

<br>

<div class="container">
	<% if (content == "connexion") { %>
		<%@include file="pages/connexion.jsp"%>
	<% } else { %>
		<%@include file="pages/home.jsp"%>
	<% } %>
</div>

</body>
</html>