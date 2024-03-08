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
	
	<%

String nombre 	 = request.getParameter("nombreUsuario")!=null?request.getParameter("nombreUsuario"):"";
String apellidos = request.getParameter("apellidosUsuario")!=null?request.getParameter("apellidosUsuario"):"";
String dni = request.getParameter("dniUsuario")!=null?request.getParameter("dniUsuario"):"";
String sexo = request.getParameter("sexoUsuario")!=null?request.getParameter("sexoUsuario"):"";
String fechaNacimiento = request.getParameter("fechaNacimiento")!=null?request.getParameter("fechaNacimiento"):"";
String email = request.getParameter("emailUsuario")!=null?request.getParameter("emailUsuario"):"";
String telefono = request.getParameter("telefono")!=null?request.getParameter("telefono"):"";
String nameUsuario = request.getParameter("nameUsuario")!=null?request.getParameter("nameUsuario"):"";
String contrasena = request.getParameter("contrasena")!=null?request.getParameter("contrasena"):"";
String roles = request.getParameter("roles")!=null?request.getParameter("roles"):"";

String accion = request.getParameter("accion").equals("modificar")?"modificar":"insertar";


%>

	<div class="container mt-5">
		<h2>Registro de Usuario</h2>
		<form action="/Project/UsuarioServlet?accion=<%=accion %>" method="post"
			onsubmit="return validarFormulario(event)">
			<div class="row">
				<div class="col-md-6 mb-3">
					<label for="nombreUsuario" class="form-label">Nombre</label> <input
						type="text" class="form-control" id="nombreUsuario"
						name="nombreUsuario" required>
				</div>
				<div class="col-md-6 mb-3">
					<label for="apellidosUsuario" class="form-label">Apellidos</label>
					<input type="text" class="form-control" id="apellidosUsuario"
						name="apellidosUsuario" required>
				</div>
				<div class="col-md-6 mb-3">
					<label for="dniUsuario" class="form-label">DNI</label> <input
						type="text" class="form-control" id="dniUsuario" name="dniUsuario"
						required>
				</div>
				<div class="col-md-6 mb-3">
					<label for="sexoUsuario" class="form-label">Sexo</label> <select
						class="form-select" id="sexoUsuario" name="sexoUsuario" required>
						<option value="">Seleccione su sexo</option>
						<option value="Masculino">Masculino</option>
						<option value="Femenino">Femenino</option>
						<option value="Otro">Otro</option>
					</select>
				</div>
				<div class="col-md-6 mb-3">
					<label for="fechaNacimiento" class="form-label">Fecha de
						nacimiento</label> <input type="date" class="form-control"
						id="fechaNacimiento" name="fechaNacimiento" required>
				</div>
				<div class="col-md-6 mb-3">
					<label for="emailUsuario" class="form-label">Email</label> <input
						type="email" class="form-control" id="emailUsuario"
						name="emailUsuario" required>
				</div>
				<div class="col-md-6 mb-3">
					<label for="telefono" class="form-label">Teléfono</label> <input
						type="text" class="form-control" id="telefono" name="telefono"
						required>
				</div>
				<div class="col-md-6 mb-3">
					<label for="nameUsuario" class="form-label">Usuario</label> <input
						type="text" class="form-control" id="nameUsuario"
						name="nameUsuario" required>
				</div>
				<div class="col-md-6 mb-3">
					<label for="contrasena" class="form-label">Contraseña</label> <input
						type="password" class="form-control" id="contrasena"
						name="contrasena" required>
				</div>
				<div class="col-12 mb-3">
					<label class="form-label">Roles</label><br> <input
						type="checkbox" id="rolAdmin" name="roles[]" value="ADMIN">
					<label for="rolAdmin">Administrador</label><br> <input
						type="checkbox" id="rolUser" name="roles[]" value="USER">
					<label for="rolUser">Usuario</label><br> <input
						type="checkbox" id="rolGuest" name="roles[]" value="GUEST">
					<label for="rolGuest">Guest</label>
				</div>
				<div class="col-12 mb-5">
					<button type="submit" class="btn btn-morado fw-bold">Registrar</button>
					<br />
				</div>
			</div>
		</form>
	</div>


	<jsp:include page="./recursos/piepagina.html"></jsp:include>
	<script src="./recursos/validaciones.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
</body>
</html>
