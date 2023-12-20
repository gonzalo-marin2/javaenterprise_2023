package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Resultado;
import service.BuscadorService;

//al cargarnos el archivo web.xml, hay que añadir la siguiente anotación
@WebServlet("/BuscadorServlet")
public class BuscadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BuscadorService buscadorService=new BuscadorService();
		List<Resultado> resultados=buscadorService.buscar(request.getParameter("tematica"));
		request.setAttribute("paginas", resultados);
		//transferir petición a la JSP
		request.getRequestDispatcher("resultados.jsp").forward(request, response);
	}
}
