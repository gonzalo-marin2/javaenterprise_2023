package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation=request.getParameter("operation");
		String urlView="";
		switch(operation) {
		case "doLogin":
			request.getRequestDispatcher("LoginController").include(request, response);
			boolean autenticado=(boolean)request.getAttribute("autenticado");
			if(!autenticado) {
				urlView="login.html";
				break;
			}
			//si está autenticado, debe hacer lo que se indica en el caso doTemas
			//por lo que no necesitamos el break, entra directamente en doTemas
			//nos ahorramos código
		case "doTemas":
			request.getRequestDispatcher("TemasController").include(request, response);
			urlView="visor.jsp";
			break;
		case "doLibrosPorTema":
			request.getRequestDispatcher("LibrosPorTemaController").forward(request, response);
			//en peticiones ajax es forward, la respuesta la hace el servlet controlador
			return;
		case "doAgregar":
			request.getRequestDispatcher("AgregarController").forward(request, response);
			return;
		case "doEliminar":
			request.getRequestDispatcher("EliminarController").forward(request, response);
			return;
		case "doAlta":
			request.getRequestDispatcher("AltaClienteController").include(request, response);
			urlView="login.html";
			break;
		case "toNuevo":
			urlView="nuevo.html";
			break;
			
		}
		request.getRequestDispatcher(urlView).forward(request, response);
	}

}
