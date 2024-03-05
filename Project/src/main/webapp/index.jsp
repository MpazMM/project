<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bienvenido a esta página</title>
   <style>
    header, footer {
        text-align: center;
        padding: 1rem;
        background-color: #f3f3f3;
    }
    .btn, .btn-link {
        padding: 10px;
        margin: 5px;
        cursor: pointer;
        text-decoration: none !important; /* Elimina el subrayado */
        color: black !important; /* Establece el color del texto en negro */
        background-color: lightgray;
        border-radius: 10px;
        border: 1px solid black; /* Añade un borde negro a los botones */
        transition: color 0.3s; /* Añade una transición suave para el cambio de color */
    }
    .btn:hover, .btn-link:hover {
        color: red !important; /* Cambia el color del texto a rojo cuando se pasa el mouse por encima */
    }
    #loginPopup {
        display: none;
        position: fixed;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        background-color: white;
        padding: 20px;
        border: 1px solid #ddd;
        box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
    }
    .close {
        cursor: pointer;
        float: right;
    }
</style>

</head>
<body>
<jsp:include page="/Proyecto/recursos/cabecera.html"></jsp:include>
<header>
    <h1>Bienvenido a esta página</h1>
    <button class="btn-link" id="loginBtn">Log In</button>
    <a href="/Project/Proyecto/signup.jsp" class="btn-link">Sign Up</a>
</header>

<div id="loginPopup">
    <span class="close" onclick="toggleLoginPopup()">&times;</span>
    <h2>Login</h2>
    <form action="" method="post">
        <fieldset>
            <legend>Acceso</legend>
                <label id="label1">Usuario: <input type="text" name="usuario"></label> <br><br>
                <label id="label2" for="contrasena">Contraseña:</label><input type="contrasena" name="contrasena" id="contrasena"><br><br>
                <br>
                <button type="submit" value="Enviar datos">Acceder</button>
        </fieldset>
	</form>
</div>

	<jsp:include page="/Proyecto/recursos/piepagina.html"></jsp:include>

<script>
    function toggleLoginPopup() {
        var popup = document.getElementById("loginPopup");
        popup.style.display = popup.style.display === "none" ? "block" : "none";
    }
    
    document.getElementById("loginBtn").addEventListener("click", toggleLoginPopup);
</script>

</body>
</html>
