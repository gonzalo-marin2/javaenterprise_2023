package servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UsuariosService;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuariosService service=new UsuariosService();
		if(service.autenticar(request.getParameter("usuario"),request.getParameter("password"))) {
			//redireccionamos petición a correcto.jsp
			response.sendRedirect("correcto.jsp?usuario="+request.getParameter("usuario"));//enviamos el parámetro
			//?usuario="+request.getParameter("usuario") este es el envío de los parámetros
		}else {
			//redireccionamos petición a error.jsp
			response.sendRedirect("error.jsp?usuario="+request.getParameter("usuario")+//enviamos los parámetros 
					"&password="+request.getParameter("password"));
			//?usuario="+request.getParameter("usuario") && "&password="+request.getParameter("password") este es el envío de los parámetros
		}
		
	}

}
