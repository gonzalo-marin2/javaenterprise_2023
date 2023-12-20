package servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Producto;
import service.ProductosService;


public class EliminarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductosService service=new ProductosService();
		service.eliminarProducto(request.getParameter("nombre"));
		request.getRequestDispatcher("eliminar.html").forward(request, response);
		
	}

}
