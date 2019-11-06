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
			<table class="table">
				<thead>
				 <tr>
			      <th scope="col">#</th>
			      <th scope="col">Titre</th>
			      <th scope="col">Contenu</th>
			      <th scope="col">Date Ajout</th>
			      <th scope="col">Activer</th>
			    </tr>
				</thead>
				<tbody>
				
					<c:forEach items="${ annonces }" var="annonce">
					<tr>
					<th scope="row"><c:out value="${ annonce.id }"/></th>
					<td><c:out value="${ annonce.title }"/></td>
					<td><c:out value="${ annonce.description }"/></td>
					<td><c:out value="${ annonce.dateParution }"/></td>
					<td><a class="btn btn-success" href="/annonces/activate/${annonce.id}">Activer</a><td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
	

</body>