package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Producto;

@WebServlet("/AltaServlet")
public class AltaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		List<Producto> productos=new ArrayList<>();
		if(session.getAttribute("carrito")!=null) {
			productos=(List<Producto>)session.getAttribute("carrito");
		}
		productos.add(new Producto(request.getParameter("nombre"),
				Double.parseDouble(request.getParameter("precio")),
				request.getParameter("categoria")));
		session.setAttribute("carrito", productos);
		//transferimos la petición a la jsp
		request.getRequestDispatcher("menu.html").forward(request, response);
	}

}
