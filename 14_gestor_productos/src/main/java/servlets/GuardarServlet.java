package servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ProductosService;


public class GuardarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre=request.getParameter("nombre");
		double precio=Double.parseDouble(request.getParameter("precio"));
		String categoria=request.getParameter("categoria");
		ProductosService service=new ProductosService();
		service.agregarProducto("nombre", precio, "categoria");
		request.getRequestDispatcher("guardar.html").forward(request, response);
	}

}
