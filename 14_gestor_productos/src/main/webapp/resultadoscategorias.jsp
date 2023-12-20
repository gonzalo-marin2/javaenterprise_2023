<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,,model.Producto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%List<Producto> productos=(List<Producto>)request.getAttribute("productos");
	if(productos!=null){
		for(Producto p:productos){%>
			<table>
				
			</table>
		<%}%>
	<%}%>
	
</body>
</html>