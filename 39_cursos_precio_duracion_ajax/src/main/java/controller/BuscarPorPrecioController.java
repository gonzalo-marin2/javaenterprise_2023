package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Curso;
import service.CursosService;

@WebServlet("/BuscarPorPrecioController")
public class BuscarPorPrecioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CursosService service=new CursosService();
		List<Curso> cursos=service.preciosCursoMax(Double.parseDouble(request.getParameter("precio")));
		PrintWriter out=response.getWriter();
		response.setContentType("application/json");
		Gson gson=new Gson();
		out.println(gson.toJson(cursos));
	}
}
