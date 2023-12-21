<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,model.Producto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Carrito de la compra</title>
</head>
<body>
	<h1>Productos que hay en el carrito</h1>
<%List<Producto> productos=(List<Producto>)session.getAttribute("carrito");
	if(productos!=null){
		for(Producto p:productos){%>
		<table>
			<tr>
				<th>Nombre</th>
				<th>Precio</th>
				<th>Categoria</th>
			</tr>
			<tr>
				<td><%=p.getNombre()%></td>
				<td><%=p.getPrecio()%></td>
				<td><%=p.getCategoria()%></td>
				<td><form input="submit" value="Eliminar">Eliminar</form></td>
			</tr>
			
			
		</table>
		<%}%>
	<%}%>
	<a href="menu.html">Volver</a>
</body>
</html>