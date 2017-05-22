<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="lib/js/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="lib/css/bootstrap.min.css">
<link rel="stylesheet" href="lib/css/bootstrap-theme.min.css">
<script src="lib/js/bootstrap.min.js"></script>
<title>index.html</title>
</head>
<body>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<h1>myEpsi</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-4">Menu1</div>
		<div class="col-xs-4">Menu2</div>
		<div class="col-xs-4">Menu3</div>
	</div>
</div>



<div style="border:2px solid red">
${name}
</div>
<%@include file="pages/home.jsp" %>

</body>
</html>