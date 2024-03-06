<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.Locale" %>
<%
    ResourceBundle rb = ResourceBundle.getBundle("cabecera", Locale.getDefault(), Thread.currentThread().getContextClassLoader());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><%= rb.getString("title") %></title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<style>

  .navbar-nav .nav-link:hover {
    color: purple !important; 
  }
    .navbar-brand {
    color: purple !important; 
  }

  .navbar-brand:hover {
    color: white !important; 
  }
</style>

</head>
<body class="bg-dark text-white">

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand fw-bold" href="#"><%= rb.getString("title") %></a>
    
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active fw-bold" aria-current="page" href="/Project/"><%= rb.getString("nav.home") %></a>
        </li>
        <li class="nav-item">
          <a class="nav-link fw-bold" href="/Project/Proyecto/informacion.jsp"><%= rb.getString("nav.info") %></a>
        </li>
      </ul>
    </div>
  </div>
</nav>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoHLaGc6P8RxiURtFbL0fPc/8Y9JkoAsb+VvOLKGYUcK4J6VpG" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0TbF0JvI1kR" crossorigin="anonymous"></script>

</body>
</html>
