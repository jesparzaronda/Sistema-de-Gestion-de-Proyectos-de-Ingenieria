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
import es.upm.dit.isst.gesProy.dao.RegistroTrabajoDAOImplementation;
import es.upm.dit.isst.gesProy.dao.model.Proyecto;

/**
 * Servlet implementation class InformeProyecto
 */
@WebServlet("/InformeProyecto")
public class InformeProyecto extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String nombreProyecto = req.getParameter("nombre_proyecto");
	
		//Seleccionamos el trabajador
		Proyecto proyectoEscogido = null;
		List<Proyecto> proyectos = ProyectoDAOImplementation.getInstance().readAllProyecto();
		for(Proyecto proyecto : proyectos) {
			String nombreCompleto = proyecto.getNombre();
			if(nombreCompleto.equals(nombreProyecto)) {
				proyectoEscogido = proyecto;
			}	
		}
		
		
		//Calculo de rendimiento 

		
		//Actualizamos y redirigimos
		List<String> horasTrabajador = new ArrayList<>();
		for(int i = 0; i < proyectoEscogido.getTrabajadoresProyecto().size(); i++) {
			String nombreTrabajador = proyectoEscogido.getTrabajadoresProyecto().get(i).getNombre() + " " + proyectoEscogido.getTrabajadoresProyecto().get(i).getApellidos();
			horasTrabajador.add(RegistroTrabajoDAOImplementation.getInstance().horasTrabajadorPorProyecto(nombreTrabajador, proyectoEscogido.getNombre()));
		}
		
		req.getSession().setAttribute("lista_horas", horasTrabajador);
		req.getSession().setAttribute("proyecto",proyectoEscogido);
		req.getSession().setAttribute("trabajadores_proyecto", proyectoEscogido.getTrabajadoresProyecto());
		resp.sendRedirect(req.getContextPath() + "/InformeProyecto.jsp");
	}

}
