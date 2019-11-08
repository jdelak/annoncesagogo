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
		<spring:message code="list_size" var="list_size"
			text="Annonces par page" htmlEscape="false" />
		<c:out value="${list_size} " />
		<c:forEach var="i" begin="6" end="12" step="6">
			<c:choose>
				<c:when test="${size == i}">
					<c:out value="${i}" />
				</c:when>
				<c:otherwise>
					<spring:url value="" var="sizeUrl">
						<spring:param name="page" value="0" />
						<spring:param name="size" value="${i}" />
						<spring:param name="sort" value="${sortDesc}" />
					</spring:url>
					<a href="${sizeUrl}">${i}</a>
				</c:otherwise>
			</c:choose>
			<c:out value=" " />
		</c:forEach>
		<div class="row">
			<c:forEach items="${ annonces.content }" var="annonce">
				<div class="col-lg-6">
					<small><fmt:formatDate value="${annonce.dateParution}" pattern="yyyy-MM-dd" /></small>
					<a href="/annonces/${annonce.id }">
					<h3>
						<c:out value="${ annonce.title }" />
					</h3>
					</a>
					<p># ${annonce.categoryAnnonce.title}</p>
					<p>
						<c:out value="${ annonce.description }" />
					</p>
				</div>

			</c:forEach>
		</div>
		<div class="row-fluid">
			<util:pagination thispage="${annonces}"></util:pagination>
		</div>
	</div>

</body>