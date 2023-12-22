package servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UsuariosService;

@WebServlet("/EntradaServlet")
public class EntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//comprobar si llega la cookie "user"
		//si llega se envía a correcto.jsp
		String usuario=null;//declaramos esta variable, si se queda a null, no había nada
		Cookie[] cookies=request.getCookies();
		if(cookies!=null) {
			for(Cookie ck:cookies) {
				if(ck.getName().equals("usuario")) {
					usuario=ck.getValue();
					break;
				}
			}	
		}
		////CON PROGRAMACION FUNCIONAL
		/*
		  String usuario=Arrays.stream(request.getCookies()!=null?request.getCookies():new Cookie[0]))
		  	.filter(c->c.getName().equals("user"))
		  	.findFirst()
		  	.orElse(new Cookie("usuario", null))
		  	.getValue();
		  */
			
		if(usuario==null) {
			request.getRequestDispatcher("login.html").forward(request, response);
		}else {
			request.getRequestDispatcher("correcto.jsp?usuario="+usuario).forward(request, response);
		}

	}
	
	
	
	

}
