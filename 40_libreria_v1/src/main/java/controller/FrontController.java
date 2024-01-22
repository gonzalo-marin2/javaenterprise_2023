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
		case "doTemas":
			request.getRequestDispatcher("TemasController").include(request, response);
			urlView="visor.jsp";
			break;
		case "doLibrosPorTema":
			request.getRequestDispatcher("LibrosPorTemaController").forward(request, response);
			//en peticiones ajax es forward, la respuesta la hace el servlet controlador
			return;
		}
		request.getRequestDispatcher(urlView).forward(request, response);
	}

}
