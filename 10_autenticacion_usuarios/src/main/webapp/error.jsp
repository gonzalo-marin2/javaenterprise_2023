<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error de autenticación</title>
</head>
<body>
	<center>
		<h3>El usuario <%=request.getParameter("usuario")%> con contraseña <%=request.getParameter("password")%> no existe</h3>
		<br><br>
		<a href="login.html">Volver</a>
	</center>

</body>
</html>