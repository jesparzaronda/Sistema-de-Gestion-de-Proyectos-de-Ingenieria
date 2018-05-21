package es.upm.dit.isst.gesProy.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.gesProy.dao.ProyectoDAOImplementation;
import es.upm.dit.isst.gesProy.dao.RegistroTrabajoDAOImplementation;
import es.upm.dit.isst.gesProy.dao.TrabajadorDAOImplementation;
import es.upm.dit.isst.gesProy.dao.model.Proyecto;
import es.upm.dit.isst.gesProy.dao.model.Trabajador;

/**
 * Servlet implementation class SeleccionarProyectoGestor
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
		if(req.getSession().getAttribute("gestorLogged") != null && req.getSession().getAttribute("trabajadorLogged") == null) {
			List<String> horasTrabajador = new ArrayList<>();
			for(int i = 0; i < proyectoEscogido.getTrabajadoresProyecto().size(); i++) {
				String nombreTrabajador = proyectoEscogido.getTrabajadoresProyecto().get(i).getNombre() + " " + proyectoEscogido.getTrabajadoresProyecto().get(i).getApellidos();
				horasTrabajador.add(RegistroTrabajoDAOImplementation.getInstance().horasTrabajadorPorProyecto(nombreTrabajador, proyectoEscogido.getNombre()));
			}
			
			req.getSession().setAttribute("lista_horas", horasTrabajador);
		resp.sendRedirect(req.getContextPath() + "/AreaGestor.jsp");
		}
		else {
			String trabajadorEmail = (String) req.getSession().getAttribute("trabajadorLogged");
			List<Trabajador> trabajadores = TrabajadorDAOImplementation.getInstance().readAllTrabajador();
			Trabajador trabajadorEscogido = null;
			for(Trabajador trabajador : trabajadores) {
				if(trabajadorEmail.equals(trabajador.getEmail())) {
					trabajadorEscogido = trabajador;
				}	
			}
			
			//List<Double> horasPorDia = RegistroTrabajoDAOImplementation.getInstance().calcularHorasPorDia(trabajadorEscogido, proyectoEscogido);
			
			//req.getSession().setAttribute("horas_por_dia", horasPorDia);
			req.getSession().setAttribute("proyecto_trabajador", proyectoEscogido.getGestor());
			
			resp.sendRedirect(req.getContextPath() + "/AreaTrabajador.jsp");
			
		}
		
	}
}
