<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,model.Producto"%>
<%@taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Carrito de la compra</title>
</head>
<body>
	<h1>Productos que hay en el carrito</h1>
	<a href="CerrarSesionServlet">Cerrar sesión</a>
	<c:if test="${!empty sessionScope.carrito}">
		<table border="1">
			<tr>
				<th>Nombre</th>
				<th>Precio</th>
				<th>Categoria</th>
				<th></th>
			</tr>

			<c:forEach var="pr" items="${sessionScope.carrito}">
				<tr>
					<td>${pr.nombre}</td>
					<td>${pr.precio}</td>
					<td>${pr.categoria}</td>
					<td><a href="EliminarServlet?nombre=${pr.nombre}">Eliminar</a></td>
				</tr>	
			</c:forEach>
	
		</table>
	</c:if>
	<br><br>
	<a href="menu.html">Volver</a>
	
</body>
</html>