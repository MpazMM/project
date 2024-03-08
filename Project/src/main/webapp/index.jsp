<!DOCTYPE html>
<html lang="es" style="height: 100%;">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Bienvenido a esta página</title>

<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<style>
html, body {
	height: 100%;
	margin: 0;
	padding: 0;
	background-image: url('Proyecto/img/fondo.jpg');
	background-size: cover;
	background-attachment: fixed;
	background-color: rgba(0, 0, 0, 0.5);
	background-blend-mode: darken;
}

.welcome-container {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	height: 100%;
	color: white;
}

.btn-custom {
	margin: 5px;
	border: 2px solid black !important;
	background-color: white !important;
	color: black !important;
	transition: color 0.3s, background-color 0.3s !important;
}

.btn-custom:hover {
	color: purple !important;
	background-color: white !important;
}

#loginPopup {
	display: none;
	position: fixed;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	background-color: black;
	color: white;
	padding: 20px;
	border: 1px solid #ddd;
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.5);
}

.btn-morado {
	background-color: white !important;
	border-color: purple !important;
	color: purple !important;
}

.btn-morado:hover {
	background-color: purple !important;
	border-color: white !important;
	color: white !important;
}

.close {
	cursor: pointer;
	float: right;
	color: white;
}

h2 {
	color: purple;
}
</style>

</head>
<body>
	<jsp:include page="/Proyecto/recursos/cabecera.jsp"></jsp:include>
	<div class="welcome-container text-center">
		<h1 class="fw-bold">Bienvenido a esta página</h1>
		<div>
			<button class="btn btn-custom" id="loginBtn">Log In</button>
			<a href="./Proyecto/signup.jsp" class="btn btn-custom">Sign Up</a>
		</div>
	</div>

	<div id="loginPopup">
		<span class="close" onclick="toggleLoginPopup()">&times;</span>
		<h2>Login</h2>
		<form action="/Project/LogInServlet" method="post">
			<div class="form-group">
				<label for="usuario">Usuario:</label> <input type="text"
					class="form-control" name="usuario" id="usuario">
			</div>
			<div class="form-group">
				<label for="contrasena">Contraseña</label> <input type="password"
					class="form-control" name="contrasena" id="contrasena">
			</div>
			<button type="submit" class="btn btn-morado fw-bold">Acceder</button>
		</form>
	</div>

	<script>
		function toggleLoginPopup() {
			var popup = document.getElementById("loginPopup");
			popup.style.display = popup.style.display === "none" ? "block"
					: "none";
		}

		document.getElementById("loginBtn").addEventListener("click",
				toggleLoginPopup);
	</script>
	
	<script>
    window.onload = function() {
        const mensaje = "<%=request.getAttribute("mensaje")%>";
        if (mensaje !== "null" && mensaje !== "") {
            alert(mensaje);
        }
    };
</script>
</body>
<jsp:include page="/Proyecto/recursos/piepagina.html"></jsp:include>
</html>