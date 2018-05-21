package es.upm.dit.isst.gesProy.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.gesProy.dao.ProyectoDAOImplementation;
import es.upm.dit.isst.gesProy.dao.TrabajadorDAOImplementation;
import es.upm.dit.isst.gesProy.dao.model.Proyecto;
import es.upm.dit.isst.gesProy.dao.model.Trabajador;

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
				//Eliminamos del proyecto los trabajadores que hayan trabajado en él
				List<Trabajador> trabajadoresEnProyecto= proyectoEscogido.getTrabajadoresProyecto();
				for(int i = 0; i < trabajadoresEnProyecto.size(); i++) {
					Trabajador esteTrabajador = trabajadoresEnProyecto.get(i);
					List<Proyecto> proyectosDeTrabajador = esteTrabajador.getProyectosTrabajador();
					proyectosDeTrabajador.remove(proyectoEscogido);
					TrabajadorDAOImplementation.getInstance().updateTrabajador(esteTrabajador);
						}
				List <Trabajador> trabajadoresVacios = new ArrayList<>();
					proyectoEscogido.setTrabajadoresProyecto(trabajadoresVacios);
					ProyectoDAOImplementation.getInstance().updateProyecto(proyectoEscogido);
				
				//Lo eliminamos, actualizamos y redirigmos
				//if(proyectoEscogido!=null) {
					ProyectoDAOImplementation.getInstance().deleteProyecto(proyectoEscogido);
					List<Proyecto> proyectosGestor = ProyectoDAOImplementation.getInstance().readAllProyectosdeGestor(proyectoEscogido.getGestor());
					req.getSession().setAttribute("proyectos_list", proyectosGestor);
					if(proyectosGestor!=null && !proyectosGestor.isEmpty()){
						req.getSession().setAttribute("proyecto_seleccionado", proyectosGestor.get(0).getNombre());	
						req.getSession().setAttribute("trabajadores_proyecto", proyectosGestor.get(0).getTrabajadoresProyecto());	
					//}
					/*else {
						req.getSession().setAttribute("proyectos_list", null);
						req.getSession().setAttribute("proyecto_seleccionado", null);	
						req.getSession().setAttribute("trabajadores_proyecto", null);	
					}*/
				}

				resp.sendRedirect(req.getContextPath()+ "/AreaGestor.jsp");
	}

}
