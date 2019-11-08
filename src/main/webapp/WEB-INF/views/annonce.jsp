<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags/util" prefix="util"%>

<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="UTF-8">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Annonces à Gogo</title>

</head>
<body>
	<div class="container">
		<nav class="navbar navbar-light bg-light">
			<span class="navbar-brand mb-0 h1">Annonces à Gogo</span>
			<span class="text-right">${ username } - Id : ${ id }</span>
			<form method="post" action="">
				<input type=text name="search" placeholder="Rechercher une annonce">
				<input type="submit" value="OK">
			</form>


		</nav>
		<div class="row">
		<div class="col-lg-12">
			<h2>${annonce.title}</h2>
			<small>${annonce.dateParution}</small>
			<p>${annonce.description}</p>
		</div>
		</div>
	</div>

</body>