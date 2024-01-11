package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/FrontController")
public class FrontController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=request.getParameter("operation");
		String urlView="";
		switch(op) {
			case "doAlta":
				request.getRequestDispatcher("AltaController").include(request, response);
				//con include vuelve el control al frontcontroller
				urlView="inicio.html";
				break;
			case "doBuscarProducto":
				request.getRequestDispatcher("BuscarProductoController").include(request, response);
				urlView="producto.jsp";
				break;
			case "doEliminar":
				request.getRequestDispatcher("EliminarController").include(request, response);
				urlView="inicio.html";
				break;
			case "doBuscarProductoCategoria":
				request.getRequestDispatcher("BuscarCategoriaController").include(request, response);
				urlView="resultadoscategorias.jsp";
				break;
			case "toAlta":
				urlView="alta.html";
				break;
			case "toInicio":
				urlView="inicio.html";
				break;
			case "toBuscarProducto":
				urlView="buscarProducto.html";
				break;
			case "toBuscarProductoCategoria":
				urlView="buscarProductoCategoria.html";
				break;
			case "toEliminar":
				urlView="eliminar.html";
				break;
		}
		//nos vamos a la página de la opción seleccionada
		request.getRequestDispatcher(urlView).forward(request, response);
	}

}
