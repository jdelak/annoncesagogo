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
	<h1>Editer Annonce</h1>
    <form method="post" action="">
   		<label for="category_annonce">Catégorie</label>
   		<select name="category_annonce" id="category_annonce">
   		 <c:forEach items="${ categories }" var="category">
   		 <option value="<c:out value="${ category.id }"/>"><c:out value="${ category.title }"/></option> 
   		 </c:forEach>
   		</select>
         <label for="title">Titre : </label>
         <input type="text" name="title" id="title" value="${annonce.title }"/>
         <label for="description">Description : </label>
         <textarea name="description" id="description">${annonce.description}</textarea>
         <label for="dateParution">Date Parution : </label>
		 <input type="date" name="dateParution" id="dateParution" value="2019-11-08" />
		 <label for="title">Activer l'annonce : </label>
		 <select name="active" id="active">
		 	<option value="true">Oui</option>
		 	<option value="false">Non</option>
		 </select>
		 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
         <input type="submit" />
     </form>
 	<p>
 		<a class="btn btn-danger" href="/annonces/delete/${annonce.id }">Supprimer l'Annonce</a>
 	</p>
     <a href="/">Retour</a>

</body>