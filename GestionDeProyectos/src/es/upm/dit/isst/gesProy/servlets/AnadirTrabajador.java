package es.upm.dit.isst.gesProy.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.gesProy.dao.TrabajadorDAOImplementation;
import es.upm.dit.isst.gesProy.dao.model.Trabajador;

/**
 * Servlet implementation class AnadirTrabajador
 */
@WebServlet("/AnadirTrabajador")
public class AnadirTrabajador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String nombreTrabajadorEscogido = req.getParameter("trabajadorEscogido");
	Trabajador trabajadorEscogido = null;
	List<Trabajador> trabajadores = TrabajadorDAOImplementation.getInstance().readAllTrabajador();
	for(Trabajador trabajador : trabajadores) {
		String nombreCompleto = trabajador.getNombre() + " " + trabajador.getApellidos();
		if(nombreCompleto.equals(nombreTrabajadorEscogido)) {
			trabajadorEscogido = trabajador;
		}
			
	}
	System.out.println(trabajadorEscogido.getNombre());
	
	
	
	System.out.println(trabajadorEscogido);
	resp.sendRedirect(req.getContextPath() + "/AreaGestor.jsp");
	}

	

}
