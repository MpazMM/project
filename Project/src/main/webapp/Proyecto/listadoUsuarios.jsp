<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List, usuario.entities.*, java.net.URLEncoder"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado usuarios</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
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
</style>
</head>
<body>

<jsp:include page="/Proyecto/recursos/cabecera.jsp"></jsp:include>
	<%
	List<Usuario> usuarios = (List<Usuario>) request.getAttribute("listadoUsuarios");
	%>

	<table>
		<tr>
			<th></th>
			<th>Nombre</th>
			<th>Apellidos</th>
			<th>Sexo</th>
			<th>Fecha Nacimiento</th>
			<th>Email</th>
			<th>Teléfono</th>
			<th>Usuario</th>
		</tr>
		<%
		for (Usuario usuario : usuarios) {
		%>
		<tr>
<%-- 			<td><a href="/Project/Proyecto/signup.jsp?nombre=<%= URLEncoder.encode(usuario.getNombre(), "UTF-8") %> --%>
<%--         &apellidos=<%= URLEncoder.encode(usuario.getApellidos(), "UTF-8") %> --%>
<%--         &dni=<%= usuario.getDni() %> --%>
<%--         &sexo=<%= URLEncoder.encode(usuario.getSexo(), "UTF-8") %> --%>
<%--         &fechaNacimiento=<%= usuario.getFechaNacimiento() %>  --%>
<%--         &email=<%= URLEncoder.encode(usuario.getEmail(), "UTF-8") %> --%>
<%--         &telefono=<%= usuario.getTelefono() %> --%>
<%--         &nameUsuario=<%= URLEncoder.encode(usuario.getNameUsuario(), "UTF-8") %> --%>
<%--         &contraseña=<%= URLEncoder.encode(usuario.getContrasena(), "UTF-8") %> --%>
<%--         &roles=<%= URLEncoder.encode(usuario.getRoles().toString()), "UTF-8") %>">Modificar</a></td> --%>

			<td><%=usuario.getNombre()%></td>
			<td><%=usuario.getApellidos()%></td>
			<td><%=usuario.getSexo()%></td>
			<td><%=usuario.getFechaNacimiento()%></td> 
			<td><%=usuario.getEmail()%></td>
			<td><%=usuario.getTelefono()%></td>
			<td><%=usuario.getNameUsuario()%></td>
		</tr>
		<%
		}
		%>

	</table>
	<a href="./Proyecto/signup.jsp" class="btn btn-morado">Nuevo Usuario</a>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>