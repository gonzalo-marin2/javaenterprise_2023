package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import dtos.LibroDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.LibrosService;

@WebServlet("/AgregarController")
public class AgregarController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int isbn=Integer.parseInt(request.getParameter("isbn"));
		HttpSession session=request.getSession();
		LibrosService service=new LibrosService();
		//recogemos el libro cuyo isbn se recibe como parámetro
		LibroDto libro=service.getLibro(isbn);
		List<LibroDto> carrito=new ArrayList<>();
		if(session.getAttribute("carrito")!=null) {
			carrito=(List<LibroDto>)session.getAttribute("carrito");
		}
		carrito.add(libro);
		session.setAttribute("carrito", carrito);
		//envía como respuesta un json con los datos del carrito
		Gson gson=new Gson();
		PrintWriter out=response.getWriter();
		response.setContentType("application/json");
		out.println(gson.toJson(carrito));
		//donde estás
	}

}
