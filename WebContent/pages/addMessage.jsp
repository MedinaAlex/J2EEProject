<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajout d'un message</title>
</head>
<body>

<form method="post" action="addMessage">
    <fieldset>
        <legend>Message</legend>
        <p>Saisissez votre message</p>

        <label for="title">Titre <span class="requis">*</span></label>
        <input type="text" id="title" name="title" size="20" maxlength="60" />
        <br />

        <label for="content">Article <span class="requis">*</span></label>
        <input type="text" id="content" name="content" value="" size="200" maxlength="255" />
        <br />
        
        <select id="status" name="status">
        	<option value="1">Public</option>
        	<option value="2">Privé</option>
        	<option value="3">Archivé</option>
        </select>

        <input type="submit" value="Envoyer" class="sansLabel" />
        <br />
        
    </fieldset>
</form>

</body>
</html>