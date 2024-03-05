<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<form action="" method="post">
        <fieldset>
            <legend>Acceso</legend>
                <label id="label1">Usuario: <input type="text" name="usuario"></label> <br><br>
                <label id="label2" for="contrasena">Contraseña:</label><input type="contrasena" name="contrasena" id="contrasena"><br><br>
                <br>
                <button type="submit" value="Enviar datos">Acceder</button>
        </fieldset>
	</form>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>