package es.upm.dit.isst.gesProy.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SeleccionarProyecto
 */
@WebServlet("/SeleccionarProyecto")
public class SeleccionarProyecto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

		String proyecto_nombre = (String)request.getSession().getAttribute("proyecto_selec");
		request.getSession().setAttribute("proyecto_seleccionado", proyecto_nombre);
		
		
		System.out.println(proyecto_nombre);
		resp.sendRedirect(request.getContextPath() + "/AreaGestor.jsp");
		
		
	}
}
