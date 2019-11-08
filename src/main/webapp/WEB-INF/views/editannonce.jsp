<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">

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
 
     <a href="/">Retour</a>

</body>