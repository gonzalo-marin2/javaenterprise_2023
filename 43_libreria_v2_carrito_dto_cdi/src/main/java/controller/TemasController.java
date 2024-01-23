package controller;

import java.io.IOException;
import java.util.List;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Tema;
import service.LibrosService;

@WebServlet("/TemasController")
public class TemasController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	@Named(value="impl1")
	LibrosService service;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("temas",service.getTemas());		
	}

}
