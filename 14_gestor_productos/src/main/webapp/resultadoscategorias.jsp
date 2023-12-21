<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,model.Producto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Productos de <%=request.getParameter("categoria") %> </h2>
<%List<Producto> productos=(List<Producto>)request.getAttribute("productos");
	if(productos!=null){
		for(Producto p:productos){%>
			<table>
				<tr>
					<th>Nombre</th>
					<th>Precio</th>
				</tr>
				<tr>
					<td><%=p.getNombre()%></td>
					<td><%=p.getPrecio()%></td>
				</tr>
			</table>
		<%}%>
	<%}%>
	
	<a href="buscar.html">Volver</a>
	
</body>
</html>