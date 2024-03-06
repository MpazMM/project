<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List, usuario.entities.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado usuarios</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet">
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
			<th>Dni</th>
			<th>Sexo</th>
			<th>Fecha Nacimiento</th>
			<th>Email</th>
			<th>Teléfono</th>
			<th>Usuario</th>
			<th>Contraseña</th>
			<th>Roles</th>
		</tr>
		<%
		for (Usuario usuario : usuarios) {
		%>
		<tr>
			<td><a
				href="/Project/Proyecto/
				signup.jsp?nombre=<%=usuario.getNombre()%>
				&apellidos=<%=usuario.getApellidos()%>
				&dni=<%=usuario.getDni()%>
				&sexo=<%=usuario.getSexo()%>
				&fechaNacimiento=<%=usuario.getFechaNacimiento()%>
				&email=<%=usuario.getEmail()%>
				&telefono=<%=usuario.getTelefono()%>
				&nameUsuario=<%=usuario.getNameUsuario()%>
	            &contraseña=<%=usuario.getContrasena()%>
	           &roles=<%for (RolUsuario rol : usuario.getRoles()) {
				out.print(rol.getRolEnum().name() + ",");
			}%>">Modificar</a></td>
			
			<td><%=usuario.getNombre()%></td>
			<td><%=usuario.getDni()%></td>
			<td><%=usuario.getSexo()%></td>
			<td><%=usuario.getFechaNacimiento()%></td>
			<td><%=usuario.getEmail()%></td>
			<td><%=usuario.getTelefono()%></td>
			<td><%=usuario.getNameUsuario()%></td>
			<td><%=usuario.getContrasena()%></td>
			<td><%=usuario.getRoles()%></td>
		</tr>
		<%
		}
		%>

	</table>
	<a href="./Proyecto/signup.jsp" class="btn btn-primary">Nuevo Usuario</a>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>