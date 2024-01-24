package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;

import dtos.LibroDto;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.LibrosService;

@WebServlet("/LibrosPorTemaController")
public class LibrosPorTemaController extends HttpServlet {
	
	@Inject
	@Named(value="impl1")
	LibrosService service;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idTema=Integer.parseInt(request.getParameter("idTema"));
		List<LibroDto> libros=service.getLibrosPorTema(idTema);
		Gson gson=new Gson();
		PrintWriter out=response.getWriter();
		response.setContentType("application/json");
		out.println(gson.toJson(libros));
	}

}
