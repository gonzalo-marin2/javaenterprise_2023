<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="ISO-8859-1">
<meta charset="ISO-8859-1">
<meta http-equiv="Expires" content="0">
<meta http-equiv="Last-Modified" content="0">
<meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
<meta http-equiv="Pragma" content="no-cache">
<title>Temáticas</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>

	Seleccione tema:
	
	<select name="temas" id="temaSel">
		<option value="0">-Todos-</option>
		<c:forEach var="t" items="${requestScope.temas}">
			<option value="${t.idTema}">${t.tema}</option>
		</c:forEach>
	</select>
	
	<!--  
	<input type="button" value="Ver Libros" id="btnVerLibros"><br><br>
	 -->
	<div id="tbLibros">
	</div>
	
	<script type="text/javascript">
	/*$("#btnVerLibros").click(function(){
		var url="FrontController";
		var params={"operation":"doLibrosPorTema","idTema":$("#temaSel").val()};
		$.get(url,params,function(data){
			var tabla="<table border='1'><tr><th>Título</th><th>ISBN</th><th>Precio</th></tr>";
			$.each(data, function(i,l){
				tabla+="<tr><td>"+l.titulo+"</td><td>"+l.isbn+"</td><td>"+l.precio+"</td></tr>";
			});
			tabla+="</table>";
			$("#tbLibros").html(tabla);
		});
	});*/
	
	//para hacerlo sin botón, al cambio de selección del select
	$("#temaSel").change(function(){
		var url="FrontController";
		var params={"operation":"doLibrosPorTema","idTema":$("#temaSel").val()};
		gestionarPeticion(url,params);
	});
	
	function gestionarPeticion(url,params){
		$.get(url,params,function(data){
			var tabla="<table border='1'><tr><th>Título</th><th>ISBN</th><th>Precio</th></tr>";
			$.each(data, function(i,l){
				tabla+="<tr><td>"+l.titulo+"</td><td>"+l.isbn+"</td><td>"+l.precio+"</td></tr>";
			});
			tabla+="</table>";
			$("#tbLibros").html(tabla);
		});
	}
	
	</script>
	
</body>
</html>