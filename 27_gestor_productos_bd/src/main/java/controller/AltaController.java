package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ProductosService;

@WebServlet("/AltaController")
public class AltaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductosService service=new ProductosService();
		/*String nombre=request.getParameter("nombre");
		double precio=Double.parseDouble(request.getParameter("precio"));
		String categoria=request.getParameter("categoria");*/
		//service.agregarProducto("nombre", precio, "categoria");
		service.agregarProducto(request.getParameter("nombre"),
				request.getParameter("categoria"),
				Double.parseDouble(request.getParameter("precio")));
	}

}
