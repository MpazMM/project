function mostrarCamposAdicionales() {
    var seleccion = document.getElementById("tipoUsuario").value;
    document.getElementById("camposAdicionales").style.display = seleccion === "ADMIN" ? "block" : "none";
}


function validarFormulario(event) {
    var telefono = document.getElementById("telefono").value;
    if (telefono.length !== 9 || isNaN(telefono)) {
        alert("El teléfono debe contener 9 dígitos.");
        event.preventDefault(); 
        return false;
    }

 
    var fechaNacimiento = new Date(document.getElementById("fechaNacimiento").value);
    var edadDifMs = Date.now() - fechaNacimiento.getTime();
    var edadFecha = new Date(edadDifMs); 
    var edad = Math.abs(edadFecha.getUTCFullYear() - 1970);
    if (edad < 18) {
        alert("Debe tener al menos 18 años para registrarse.");
        event.preventDefault();
        return false;
    }

    
    var dni = document.getElementById("dniUsuario").value;
    var dniRegex = /^[0-9]{8}[A-Za-z]$/;
    if (!dniRegex.test(dni)) {
        alert("El DNI debe tener 8 dígitos seguidos de una letra.");
        event.preventDefault();
        return false;
    }


    return true;
}
