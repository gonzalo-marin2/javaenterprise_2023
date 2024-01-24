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

@WebServlet("/AltaClienteController")
public class AltaClienteController extends HttpServlet {
	
	@Inject
	ClientesService service;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service.altaCliente(new ClienteDto(request.getParameter("usuario").toLowerCase(),
				request.getParameter("password"),
				request.getParameter("email").toLowerCase(),
				Integer.parseInt(request.getParameter("telefono"))));
	}

}
