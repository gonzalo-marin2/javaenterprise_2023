<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,model.Producto"%>
<%@taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Expires" content="0">
<meta http-equiv="Last-Modified" content="0">
<meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
<meta http-equiv="Pragma" content="no-cache"> 
<title>Productos por categoría</title>
</head>
<body>
	<h2>Productos de ${param.categoria} </h2>
	<table border="1">
		<tr>
			<th>Nombre</th>
			<th>Categoria</th>
			<th>Precio</th>
		</tr>
		<c:forEach var="pr" items="${requestScope.productos}">
			<tr>
				<td>${pr.nombre}</td>
				<td>${pr.categoria}</td>
				<td>${pr.precio}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="FrontController?operation=toInicio">Volver a home</a>
</body>
</html>