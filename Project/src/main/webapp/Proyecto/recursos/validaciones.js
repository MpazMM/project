function mostrarCamposAdicionales() {
    var seleccion = document.getElementById("tipoUsuario").value;
    document.getElementById("camposAdicionales").style.display = seleccion === "ADMIN" ? "block" : "none";
}

function validarFormulario(event) {
    event.preventDefault(); 
    var valido = true; 

   
    var telefono = document.getElementById("telefono");
    if (telefono.value.length !== 9 || isNaN(telefono.value)) {
        mostrarError(telefono, "El teléfono debe contener 9 dígitos.");
        valido = false;
    } else {
        limpiarError(telefono);
    }

    var fechaNacimiento = new Date(document.getElementById("fechaNacimiento").value);
    var edad = calcularEdad(fechaNacimiento);
    if (edad < 18) {
        mostrarError(document.getElementById("fechaNacimiento"), "Debe tener al menos 18 años para registrarse.");
        valido = false;
    } else {
        limpiarError(document.getElementById("fechaNacimiento"));
    }


    var dni = document.getElementById("dniUsuario");
    var dniRegex = /^[0-9]{8}[A-Za-z]$/;
    if (!dniRegex.test(dni.value)) {
        mostrarError(dni, "El DNI debe tener 8 dígitos seguidos de una letra.");
        valido = false;
    } else {
        limpiarError(dni);
    }

 
    var email = document.getElementById("emailUsuario");
    if (!validarEmail(email.value)) {
        mostrarError(email, "Por favor, ingrese un email válido.");
        valido = false;
    } else {
        limpiarError(email);
    }

 
    if (valido) {
        event.target.submit();
    }
}

function validarEmail(email) {
    var re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return re.test(email);
}

function mostrarError(elemento, mensaje) {
    elemento.classList.add('is-invalid');
    let feedback = elemento.nextElementSibling;
    if (!feedback || !feedback.classList.contains('invalid-feedback')) {
        feedback = document.createElement('div');
        feedback.classList.add('invalid-feedback');
        elemento.parentNode.insertBefore(feedback, elemento.nextSibling);
    }
    feedback.innerText = mensaje;
}

function limpiarError(elemento) {
    elemento.classList.remove('is-invalid');
    var feedback = elemento.nextElementSibling;
    if (feedback && feedback.classList.contains('invalid-feedback')) {
        feedback.remove();
    }
}

function calcularEdad(fechaNacimiento) {
    var edadDifMs = Date.now() - fechaNacimiento.getTime();
    var edadFecha = new Date(edadDifMs);
    return Math.abs(edadFecha.getUTCFullYear() - 1970);
}
