<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<center>
		<!--<h1>Has entrado <%=session.getAttribute("contador")%> veces</h1>-->
		 <h1>Has entrado ${sessionScope.contador} veces</h1>
		 <!-- <h2>N�mero total de visitas a mi p�gina: <%=application.getAttribute("global")%> veces</h2> -->
		<h2>N�mero total de visitas a mi p�gina: ${applicationScope.global} veces</h2>
		<br>
		<a href="inicio.html">Volver</a>
	</center>

</body>
</html>