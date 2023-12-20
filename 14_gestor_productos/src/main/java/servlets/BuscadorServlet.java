package servlets;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Producto;
import service.ProductosService;


public class BuscadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductosService service=new ProductosService();
		List<Producto> productos=service.buscarPorCategoria(request.getParameter("categoria"));
		request.setAttribute("productos", productos);
		request.getRequestDispatcher("categorias.html").forward(request, response);
	}

}
