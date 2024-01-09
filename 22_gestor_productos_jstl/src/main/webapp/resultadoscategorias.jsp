<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,model.Producto"%>
<%@taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestor de productos con jstl</title>
</head>
<body>
	<h2>Productos de ${param.categoria} </h2>
	<table border="1">
		<tr>
			<th>Nombre</th>
			<th>Precio</th>
		</tr>
		<c:forEach var="pr" items="${requestScope.productos}">
			<tr>
				<td>${pr.nombre}</td>
				<td>${pr.precio}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="inicio.html">Volver a home</a>
</body>
</html>