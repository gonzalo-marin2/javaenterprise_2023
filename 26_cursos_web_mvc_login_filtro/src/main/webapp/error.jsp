<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="ISO-8859-1">
<meta http-equiv="Expires" content="0">
<meta http-equiv="Last-Modified" content="0">
<meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
<meta http-equiv="Pragma" content="no-cache">
<title>Error de autenticación</title>
</head>
<body>
	<center>
	  <!--
		<h3>El usuario <%=request.getParameter("usuario")%> con contraseña <%=request.getParameter("password")%> no existe</h3>
		-->
		
		<h3>El usuario ${param.usuario} con contraseña ${param.password} no existe</h3>
		<br><br>
		<a href="FrontController?operation=toLogin">Volver</a>
	</center>

</body>
</html>