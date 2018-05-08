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
 * Servlet implementation class EliminarProyecto
 */
@WebServlet("/EliminarProyecto")
public class EliminarProyecto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
				//Obtenemos el proyecto a Eliminar
				String proyecto_nombre = (String) req.getSession().getAttribute("proyecto_seleccionado");
				List<Proyecto> proyectos = ProyectoDAOImplementation.getInstance().readAllProyecto();
				Proyecto proyectoEscogido = null;
				for(Proyecto proyecto : proyectos) {
					if(proyecto_nombre.equals(proyecto.getNombre())) {
						proyectoEscogido = proyecto;
					}	
				}

				//Lo eliminamos, actualizamos y redirigmos
				if(proyectoEscogido!=null) {
					ProyectoDAOImplementation.getInstance().deleteProyecto(proyectoEscogido);
					List<Proyecto> proyectosGestor = ProyectoDAOImplementation.getInstance().readAllProyectosdeGestor(proyectoEscogido.getGestor());
					req.getSession().setAttribute("proyectos_list", proyectosGestor);
					if(proyectosGestor!=null && !proyectosGestor.isEmpty()){
						req.getSession().setAttribute("proyecto_seleccionado", proyectosGestor.get(0).getNombre());	
						req.getSession().setAttribute("trabajadores_proyecto", proyectosGestor.get(0).getTrabajadoresProyecto());	
					}
					else {
						req.getSession().setAttribute("proyectos_list", null);
						req.getSession().setAttribute("proyecto_seleccionado", null);	
						req.getSession().setAttribute("trabajadores_proyecto", null);	
					}
				}

				resp.sendRedirect(req.getContextPath()+ "/AreaGestor.jsp");
	}

}
