package es.upm.dit.isst.gesProy.servlets;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.io.IOException;

import es.upm.dit.isst.gesProy.dao.EmpresaDAOImplementation;
import es.upm.dit.isst.gesProy.dao.ProyectoDAOImplementation;
import es.upm.dit.isst.gesProy.dao.TrabajadorDAOImplementation;
import es.upm.dit.isst.gesProy.dao.model.Empresa;
import es.upm.dit.isst.gesProy.dao.model.Proyecto;
import es.upm.dit.isst.gesProy.dao.model.Trabajador;

/**
 * Servlet implementation class FormAñadirProyecto
 */
@WebServlet("/CrearProyecto")
public class CrearProyecto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @throws java.io.IOException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, java.io.IOException {
		
		String nombre = req.getParameter("nombre");
		String fechaInicio = req.getParameter("fechaInicio");		
		String fechaFinal = req.getParameter("fechaFinal");	
		String nombreEmpresa = req.getParameter("empresa");
		Empresa empresaBuscada = null;
		List<Empresa> empresas = EmpresaDAOImplementation.getInstance().readAllEmpresa();
		for(Empresa empresa : empresas) {
			if ((empresa.getNombre()).equals(nombreEmpresa)) {
				empresaBuscada = empresa;
			}
		}
		String emailGestor = (String) req.getSession().getAttribute("gestorLogged");
		Trabajador gestorBuscado = null;
		List<Trabajador> gestores = TrabajadorDAOImplementation.getInstance().readAllTrabajador();
		
		for(Trabajador gestor : gestores) {
			if ((gestor.getEmail()).equals(emailGestor)) {
				if(gestor.getPrivilegios() == 2) {
				gestorBuscado = gestor;
				}
			}
		}
		
		
		
		//Creamos el nuevo Proyecto
		Proyecto nuevoProyecto = new Proyecto();
		
		nuevoProyecto.setNombre(nombre);
		nuevoProyecto.setGestor(gestorBuscado.getNombre() + " " +gestorBuscado.getApellidos());
		nuevoProyecto.setFechaInicio(fechaInicio);
		nuevoProyecto.setFechaFinal(fechaFinal);
		nuevoProyecto.setId_Empresa(empresaBuscada);
		
	
		
		ProyectoDAOImplementation.getInstance().createProyecto(nuevoProyecto);
		String nombreGestor = TrabajadorDAOImplementation.getInstance().obtenerNombreTrabajador(emailGestor);
		req.getSession().setAttribute("proyecto_seleccionado", nuevoProyecto.getNombre());	
		req.getSession().setAttribute("proyectos_list", ProyectoDAOImplementation.getInstance().readAllProyectosdeGestor(nombreGestor));
		req.getSession().setAttribute("trabajadores_proyecto", nuevoProyecto.getTrabajadoresProyecto());
		req.getSession().setAttribute("proyecto_gestor", nuevoProyecto.getGestor());
		resp.sendRedirect(req.getContextPath()+ "/AreaGestor.jsp");
		
	}


}