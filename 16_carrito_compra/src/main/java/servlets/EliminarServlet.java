package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Producto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/EliminarServlet")
public class EliminarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		List<Producto> productos=(List<Producto>)session.getAttribute("carrito");
		productos.removeIf(p->p.getNombre().equals(request.getParameter("nombre")));
		//productos y session apuntan al mismo objeto
		//por lo tanto no es necesario hacer un setAttribute de productos.
		//Si la lista se modifica a través de la variable productos, ya queda modificada en la sesión
		//session.setAttribute("carrito", productos);//no es necesario pq está apuntando al mismo objeto, pero no pasa nada si se queda
		request.getRequestDispatcher("carrito.jsp").forward(request, response);
	}

}
