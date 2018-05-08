package es.upm.dit.isst.gesProy.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.gesProy.dao.ProyectoDAOImplementation;

import es.upm.dit.isst.gesProy.dao.model.Proyecto;

/**
 * Servlet implementation class SeleccionarProyecto
 */
@WebServlet("/SeleccionarProyecto")
public class SeleccionarProyecto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String proyecto_nombre = req.getParameter("nombre_proy");
		
		List<Proyecto> proyectos = ProyectoDAOImplementation.getInstance().readAllProyecto();
		Proyecto proyectoEscogido = null;
		for(Proyecto proyecto : proyectos) {
			if(proyecto_nombre.equals(proyecto.getNombre())) {
				proyectoEscogido = proyecto;
			}	
		}
		
		req.getSession().setAttribute("proyecto_seleccionado", proyectoEscogido.getNombre());	
		req.getSession().setAttribute("trabajadores_proyecto", proyectoEscogido.getTrabajadoresProyecto());
		req.getSession().setAttribute("proyecto_gestor", proyectoEscogido.getGestor());
		resp.sendRedirect(req.getContextPath() + "/AreaGestor.jsp");
		
	}
}
