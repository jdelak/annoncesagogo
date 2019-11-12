<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Annonces à Gogo</title>

</head>
<body>
	<div class="container">
		<nav class="navbar navbar-light bg-light">
		  <span class="navbar-brand mb-0 h1">Annonces à Gogo</span>
		</nav>
		<div class="row">
			<c:forEach items="${ annonces }" var="annonce">
			<div class="col-lg-6">
				<div class="card">
				<img src="<img src="https://fakeimg.pl/250x100/">" class="card-img-top" alt="...">
				<small><c:out value="${ annonce.dateParution }"/></small>
				<h3><c:out value="${ annonce.title }"/></h3>
				<p><c:out value="${ annonce.description }"/></p>
				</div>
			</div>
   			
   		 	</c:forEach>
		</div>
	</div>

</body>