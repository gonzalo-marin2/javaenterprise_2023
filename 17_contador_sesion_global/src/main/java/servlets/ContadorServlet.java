package servlets;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ContadorServlet")
public class ContadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//pedimos el objeto HttpSession y ServletContext
		HttpSession session=request.getSession();
		ServletContext context=request.getServletContext();
		//declaramos e inicializamos el contador, lo recuperamos, le sumamos 1 y lo volvemos a guardar
		//comprobando que sea distinto de null, ya que sino, da error
		int actual=0;
		//declaramos una variable de contador global
		int global=0;
		if(session.getAttribute("contador")!=null) {
			actual=(Integer)session.getAttribute("contador");//como devuelve un String lo podemos castear a Integer
		}
		if(context.getAttribute("global")!=null) {
			global=(Integer)context.getAttribute("global");
		}
		actual++;//aumentamos el contador
		session.setAttribute("contador", actual);//actualizamos el contador
		//session.setAttribute("contador", ++actual); ==> en una línea
		context.setAttribute("global", ++global);
		
		//transferimos la petición a la jsp
		request.getRequestDispatcher("resultado.jsp").forward(request, response);
	}

}
