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
import model.Producto;
import service.ProductosService;


@WebServlet("/BuscarCategoriaController")
public class BuscarCategoriaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductosService service=new ProductosService();
		List<Producto> productos=service.buscarPorCategoria(request.getParameter("categoria"));
		//request.setAttribute("productos", productos);
		//instanciamos la librería json y mandamos una lista json al cliente
		PrintWriter out=response.getWriter();
		response.setContentType("application/json");
		Gson gson=new Gson();
		out.println(gson.toJson(productos));
	}

}
