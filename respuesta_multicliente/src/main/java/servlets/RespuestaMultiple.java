package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class RespuestaMultiple extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private int llamada=0;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		llamada++;
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body><center>");
		out.println("<h1>Llamada número "+llamada+"</h1>");
		
		out.println("</center></body></html>");
		out.close();
	}

}
