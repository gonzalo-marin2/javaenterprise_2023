package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=request.getParameter("operation");
		String urlView="";
		switch(op) {
			case "doGuardar":
				request.getRequestDispatcher("GuardarController").include(request, response);
				//con include vuelve el control al frontcontroller
				urlView="menu.html";
				break;
			case "doBuscar":
				request.getRequestDispatcher("BuscarController").include(request, response);
				urlView="cursos.jsp";
				break;
			case "doEliminar":
				request.getRequestDispatcher("EliminarController").include(request, response);
				urlView="menu.html";
				break;
			case "toNuevo":
				urlView="nuevo.html";
				break;
			case "toBuscar":
				urlView="buscar.html";
				break;
			case "toEliminar":
				urlView="eliminar.html";
				break;
			case "toMenu":
				urlView="menu.html";
				break;
			case "doAutenticar":
				request.getRequestDispatcher("LoginController").include(request, response);
				urlView="login.html";
				break;
			case "toAutenticar":
				urlView="login.html";
				break;
			case "toError":
				urlView="error.html";
				break;
		}
		
		//nos vamos a la página de la opción seleccionada
		request.getRequestDispatcher(urlView).forward(request, response);
	}

}
