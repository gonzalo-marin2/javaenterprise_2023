<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="model.Ficha"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Autenticacion correcta</title>
</head>
<body>
	<%--Recuperamos la ficha, para ello hay que importar el model, que lo hemos hecho arriba en las directivas --%>
	<%--Necesitamos convertir los datos a un objeto de tipo Ficha, por eso el casting --%>
	<% Ficha f=(Ficha)request.getAttribute("ficha");%>
	<h1>Ficha de <%=request.getParameter("usuario")%></h1>
	<h3>Nombre: <%=f.getUsuario()%></h3>
	<h3>Edad: <%=f.getEdad()%></h3>
	<h3>Email: <%=f.getEmail()%></h3>
	<br>
	<br>
	<a href="login.html">Volver</a>
</body>
</html>