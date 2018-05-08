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

		//Seleccionamos el trabajador
		Trabajador trabajadorEscogido = null;
		List<Trabajador> trabajadores = TrabajadorDAOImplementation.getInstance().readAllTrabajador();
		for(Trabajador trabajador : trabajadores) {
			String nombreCompleto = trabajador.getNombre() + " " + trabajador.getApellidos();
			if(nombreCompleto.equals(nombreTrabajadorEscogido)) {
				trabajadorEscogido = trabajador;
			}	
		}

		//Seleccionamos el proyecto
		List<Proyecto> proyectos = ProyectoDAOImplementation.getInstance().readAllProyecto();
		Proyecto proyectoEscogido = null;
		String proyecto_seleccionado = (String)req.getSession().getAttribute("proyecto_seleccionado");
		for(Proyecto proyecto : proyectos) {
			if(proyecto_seleccionado.equals(proyecto.getNombre())) {
				proyectoEscogido = proyecto;
			}	
		}
		
	
		//Añadimos trabajador al proyecto
		List<Trabajador> trabajadoresProyecto = proyectoEscogido.getTrabajadoresProyecto();

		boolean contains = false;
			//Comprobamos primero si ya está añadido
		for(int i=trabajadoresProyecto.size()-1; i>-1; i--) {
			if(trabajadoresProyecto.get(i).getNombre().equals(trabajadorEscogido.getNombre()) && trabajadoresProyecto.get(i).getApellidos().equals(trabajadorEscogido.getApellidos())) {
				contains = true;
			}
		}
			//Si no está lo añadimos
		if(!contains) {	
			trabajadoresProyecto.add(trabajadorEscogido);
			proyectoEscogido.setTrabajadoresProyecto(trabajadoresProyecto);
		}	
		
		//Actualizamos y redirigimos
		req.getSession().setAttribute("trabajadores_proyecto", trabajadoresProyecto);
		ProyectoDAOImplementation.getInstance().updateProyecto(proyectoEscogido);
		resp.sendRedirect(req.getContextPath() + "/AreaGestor.jsp");
	}
}
