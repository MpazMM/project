<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Introducción a Lenguajes de Programación Orientados a Objetos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">
     <style>
        .imagen-oop-container {
            width: 500px; 
            height: 300px; 
            display: flex;
            justify-content: center; 
            align-items: center; 
            overflow: hidden; 
        }

        .imagen-oop {
            height: 100%; 
            width: auto; 
            object-fit: cover; 
        }
    </style>
</head>
<body>
 <jsp:include page="/Proyecto/recursos/cabecera.jsp"></jsp:include>
<div class="container mt-4">
    <h1>Lenguajes de Programación Orientados a Objetos</h1>
    <p>Los lenguajes de programación orientados a objetos (OOP) son un paradigma de programación que utiliza "objetos" para diseñar aplicaciones y programas informáticos. La OOP se centra en utilizar clases y objetos para estructurar el software de una manera más clara, reutilizable y fácil de mantener.</p>

<div class="row">
    <div class="col-md-6">
        <div class="imagen-oop-container">
            <img src="./img/imagen_java1.jpg" class="imagen-oop" alt="Programación">
        </div>
    </div>
    <div class="col-md-6">
        <div class="imagen-oop-container">
            <img src="./img/imagen_java2.jpg" class="imagen-oop" alt="Programación">
        </div>
    </div>
</div>

    <h2 class="mt-4">Comparativa de Lenguajes de Programación</h2>
    <div class="table-responsive">
        <table class="table">
            <thead class="text-white bg-dark"> <!-- Aquí se han añadido las clases para el fondo oscuro y texto blanco -->
                <tr>
                    <th scope="col" class="fw-bold">Lenguaje</th>
                    <th scope="col" class="fw-bold">Ventajas</th>
                    <th scope="col" class="fw-bold">Desventajas</th>
                </tr>
            </thead>
            <tbody class="text-white bg-secondary"> <!-- Se mantiene el texto blanco para el cuerpo de la tabla -->
                <tr>
                    <td>Java</td>
                    <td>Ampliamente utilizado, multiplataforma, robusto.</td>
                    <td>Puede ser más lento que lenguajes compilados como C++.</td>
                </tr>
                <tr>
                    <td>Python</td>
                    <td>Sintaxis simple, ideal para principiantes, versátil.</td>
                    <td>No es el mejor para aplicaciones móviles de alto rendimiento.</td>
                </tr>
                <tr>
                    <td>C++</td>
                    <td>Poderoso para sistemas y aplicaciones de alto rendimiento.</td>
                    <td>Curva de aprendizaje más empinada, manejo manual de memoria.</td>
                </tr>
            </tbody>
        </table>
    </div>
</div>
 <jsp:include page="/Proyecto/recursos/piepagina.html"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
