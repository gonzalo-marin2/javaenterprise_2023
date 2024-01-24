package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import jakarta.servlet.http.HttpSession;
import model.Libro;
import service.interfaces.LibrosService;

@WebServlet("/EliminarController")
public class EliminarController extends HttpServlet {
	
	@Inject
	@Named(value="impl1")
	LibrosService service;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pos=Integer.parseInt(request.getParameter("pos"));
		HttpSession session=request.getSession();
		
		List<LibroDto> carrito=new ArrayList<>();
		if(session.getAttribute("carrito")!=null) {
			carrito=(List<LibroDto>)session.getAttribute("carrito");
			carrito.remove(pos);
		}
		
		session.setAttribute("carrito", carrito);
		Gson gson=new Gson();
		PrintWriter out=response.getWriter();
		response.setContentType("application/json");
		out.println(gson.toJson(carrito));
	}

}
