<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Registro de Usuario</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
h2 {
	color: purple;
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
.is-invalid {
    border-color: purple !important; 
    background: rgba(235, 215, 255, 0.5) !important; 
}

.invalid-feedback {
    color: rgba(235, 215, 255, 0.5) !important; 
}
</style>
</head>
<body>


	<jsp:include page="/Proyecto/recursos/cabecera.jsp"></jsp:include>

	<div class="container mt-5">
		<h2>Registro de Usuario</h2>
	</div>


	<jsp:include page="/Proyecto/recursos/piepagina.html"></jsp:include>
	<script src="./recursos/validaciones.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
</body>
</html>