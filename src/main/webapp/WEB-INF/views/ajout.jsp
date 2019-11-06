<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
    </head>
    <body>
        <h3>Ajouter une annonce</h3>
        <form:form method="POST"
          action="/add" modelAttribute="annonce">
             <table>
                <tr>
                    <td><form:label path="title">Titre</form:label></td>
                    <td><form:input path="title"/></td>
                </tr>
                <tr>
                    <td><form:label path="description">Description</form:label></td>
                    <td><form:textarea path="description"/></td>
                </tr>
                <tr>
                    <td><form:label path="dateParution">
                      Date de Parution</form:label></td>
                    <td><form:input type="date" value="2019-10-30" path="dateParution"/></td>
                </tr>
                <tr>
                    <td><form:label path="categoryAnnonce">
                      Catégorie</form:label></td>
                    <td><form:select path="categoryAnnonce">
                    	<form:option value="-" label="--Choisir Catégorie--"/>
					    <form:options items="${categories}" />
					</form:select>
					</td>
                </tr>
                <tr>
                    <td><input type="submit" value="Envoyer"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>