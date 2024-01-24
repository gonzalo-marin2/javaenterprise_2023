package controller;

import java.io.IOException;

import dtos.ClienteDto;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.interfaces.ClientesService;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	
	@Inject
	ClientesService service;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recogemos el resultado en una variable para poder preguntar después
		ClienteDto dto=service.autenticarCliente(request.getParameter("usuario"), request.getParameter("password"));
		//el resultado de la autenticación lo guardamos en un atributo de petición
		//para que lo pueda utilizar el front controller
		request.setAttribute("autenticado", dto!=null);
		
		//si el usuario está autenticado, lo guardamos en un atributo de sesión
		/*if(dto!=null) {
			request.getSession().setAttribute("usuario", request.getParameter("usuario"));
		}*/	
	}

}
