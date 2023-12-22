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
<%List<Producto> carrito=(List<Producto>)session.getAttribute("carrito");
	if(carrito!=null){%>
		<table border="1">
			<tr>
				<th>Nombre</th>
				<th>Precio</th>
				<th>Categoria</th>
				<th></th>
			</tr>
			<%for(Producto p:carrito){ %>
			<tr>
				<td><%=p.getNombre()%></td>
				<td><%=p.getPrecio()%></td>
				<td><%=p.getCategoria()%></td>
				<td><a href="EliminarServlet?nombre=<%=p.getNombre()%>">Eliminar</a></td>
			</tr>	
		
		<%}%>
	<%}%>
		</table>
	<br><br>
	<a href="menu.html">Volver</a>
</body>
</html>