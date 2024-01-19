package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Libro;
import service.LibrosService;

@WebServlet("/LibrosPorTemaController")
public class LibrosPorTemaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LibrosService service=new LibrosService();
		List<Libro> libros=service.getLibrosPorTema(request.getParameter("tema"));
		request.setAttribute("libros", libros);
		
	}

}
