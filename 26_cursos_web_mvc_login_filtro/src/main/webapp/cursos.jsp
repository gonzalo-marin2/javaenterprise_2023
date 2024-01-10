<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList,model.Curso"%>
<%@taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="ISO-8859-1">
<meta http-equiv="Expires" content="0">
<meta http-equiv="Last-Modified" content="0">
<meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
<meta http-equiv="Pragma" content="no-cache">
<title>Gestor de cursos con jstl, maven y mvc</title>
</head>
<body>

<h2>Cursos cuyo precio máximo es ${param.precio} </h2>
<br>	
		<c:if test="${!empty requestScope.cursos}">
			<table border="1">
				<tr>
					<th>Nombre</th>
					<th>Duracion</th>
					<th>Precio</th>
				</tr>
				<%--recuperamos el arraylist de cursos que está en un atributo de petición,
			lo recorremos y mostramos una fila por cada curso --%>
				<c:forEach var="c" items="${requestScope.cursos}">
					<tr>
						<td>${c.nombre}</td>
						<td>${c.duracion}</td>
						<td>${c.precio}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<c:if test="${empty requestScope.cursos}">
			<h3>No hay cursos con ese criterio</h3>
		</c:if>
		<br>
		<a href="FrontController?operation=toMenu">Volver</a>
</body>
</html>