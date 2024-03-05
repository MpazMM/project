<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registro de Usuario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script>
        function mostrarCamposAdicionales() {
            var seleccion = document.getElementById("tipoUsuario").value;
            document.getElementById("camposAdicionales").style.display = seleccion === "ADMIN" ? "block" : "none";
        }
    </script>
</head>
<body>

    
    <jsp:include page="/Proyecto/recursos/cabecera.html"></jsp:include>

    <div class="container mt-5">
        <h2>Registro de Usuario</h2>
        <form action="/Project/UsuarioServlet" method="post">
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="nombreUsuario" class="form-label">Nombre</label>
                    <input type="text" class="form-control" id="nombreUsuario" name="nombreUsuario" required>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="apellidosUsuario" class="form-label">Apellidos</label>
                    <input type="text" class="form-control" id="apellidosUsuario" name="apellidosUsuario" required>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="dniUsuario" class="form-label">DNI</label>
                    <input type="text" class="form-control" id="dniUsuario" name="dniUsuario" required>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="sexoUsuario" class="form-label">Sexo</label>
                    <select class="form-select" id="sexoUsuario" name="sexoUsuario" required>
                        <option value="">Seleccione su sexo</option>
                        <option value="Masculino">Masculino</option>
                        <option value="Femenino">Femenino</option>
                        <option value="Otro">Otro</option>
                    </select>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="fechaNacimiento" class="form-label">Fecha de nacimiento</label>
                    <input type="date" class="form-control" id="fechaNacimiento" name="fechaNacimiento" required>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="emailUsuario" class="form-label">Email</label>
                    <input type="email" class="form-control" id="emailUsuario" name="emailUsuario" required>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="telefono" class="form-label">Tel�fono</label>
                    <input type="text" class="form-control" id="telefono" name="telefono" required>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="nameUsuario" class="form-label">Usuario</label>
                    <input type="text" class="form-control" id="nameUsuario" name="nameUsuario" required>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="contrasena" class="form-label">Contrase�a</label>
                    <input type="password" class="form-control" id="contrasena" name="contrasena" required>
                </div>
                <div class="col-12 mb-3">
                    <label class="form-label">Roles</label><br>
                    <input type="checkbox" id="rolAdmin" name="roles[]" value="ADMIN">
                    <label for="rolAdmin">Administrador</label><br>
                    <input type="checkbox" id="rolUser" name="roles[]" value="USER">
                    <label for="rolUser">Usuario</label><br>
                    <input type="checkbox" id="rolGuest" name="roles[]" value="GUEST">
                    <label for="rolGuest">Guest</label>
                </div>
                <div class="col-12 mb-5">
                    <button type="submit" class="btn btn-primary">Registrar</button><br/>
                </div>
            </div>
        </form>
    </div>

    
    <jsp:include page="./recursos/piepagina.html"></jsp:include>
    <script src="./recursos/validaciones.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
</body>
</html>
