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
<title>Tem�ticas</title>
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
	<div id="tbLibros"></div><br>
	
	<h2>Carrito</h2>
	<div id="tbCarrito">
	</div>
	
	<script type="text/javascript">
	/*$("#btnVerLibros").click(function(){
		var url="FrontController";
		var params={"operation":"doLibrosPorTema","idTema":$("#temaSel").val()};
		$.get(url,params,function(data){
			var tabla="<table border='1'><tr><th>T�tulo</th><th>ISBN</th><th>Precio</th></tr>";
			$.each(data, function(i,l){
				tabla+="<tr><td>"+l.titulo+"</td><td>"+l.isbn+"</td><td>"+l.precio+"</td></tr>";
			});
			tabla+="</table>";
			$("#tbLibros").html(tabla);
		});
	});*/
	
	//para hacerlo sin bot�n, al cambio de selecci�n del select
	$("#temaSel").change(function(){
		var url="FrontController";
		var params={"operation":"doLibrosPorTema","idTema":$("#temaSel").val()};
		gestionarPeticion(url,params);
	});
	
	function gestionarPeticion(url,params){
		$.get(url,params,function(data){
			var tabla="<table border='1'><tr><th>T�tulo</th><th>ISBN</th><th>Precio</th><th>P�ginas</th><th>Tema</th><th></th></tr>";
			$.each(data, function(i,l){
				tabla+="<tr><td>"+l.titulo+"</td><td>"+l.isbn+"</td><td>"+l.precio+"</td><td>"
				+l.paginas+"</td><td>"+l.temaDto.tema+"</td><td><a href='#' onclick='agregarCarrito("+l.isbn+")'>Agregar</a></td></tr>";
			});
			tabla+="</table>";
			$("#tbLibros").html(tabla);
		});
	}
	
	function agregarCarrito(isbn){
		var params={"operation":"doAgregar","isbn":isbn};
		pintarCarrito(params);
	}
	
	function EliminarCarrito(pos){
		var params={"operation":"doEliminar","pos":pos};
		pintarCarrito(params);
	}
	
	function pintarCarrito(params){
		var url="FrontController";
		$.get(url,params,function(data){
			var tabla="<table border='1'><tr><th>T�tulo</th><th>ISBN</th><th>Precio</th><th>P�ginas</th><th>Tema</th></tr>";
			$.each(data, function(i,l){
				tabla+="<tr><td>"+l.titulo+"</td><td>"+l.isbn+"</td><td>"+l.precio+"</td><td>"
				+l.paginas+"</td><td>"+l.temaDto.tema+"</td><td><a href='#' onclick='EliminarCarrito("+i+")'>Eliminar</a></td></tr>";
			});
			tabla+="</table>";
			$("#tbCarrito").html(tabla);
		});
	}
	
	</script>
	
</body>
</html>