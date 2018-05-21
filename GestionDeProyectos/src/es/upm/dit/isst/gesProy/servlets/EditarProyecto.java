package es.upm.dit.isst.gesProy.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.gesProy.dao.EmpresaDAOImplementation;
import es.upm.dit.isst.gesProy.dao.ProyectoDAOImplementation;
import es.upm.dit.isst.gesProy.dao.TrabajadorDAOImplementation;
import es.upm.dit.isst.gesProy.dao.model.Empresa;
import es.upm.dit.isst.gesProy.dao.model.Proyecto;
import es.upm.dit.isst.gesProy.dao.model.Trabajador;

/**
 * Servlet implementation class EditarProyecto
 */
@WebServlet("/EditarProyecto")
public class EditarProyecto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @throws java.io.IOException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, java.io.IOException {
		
		//Recuperamos los parametros
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
		
		//Obtenemos el proyecto a actualizar
		String proyecto_nombre = (String) req.getSession().getAttribute("proyecto_seleccionado");
		List<Proyecto> proyectos = ProyectoDAOImplementation.getInstance().readAllProyecto();
		Proyecto proyectoEscogido = null;
		for(Proyecto proyecto : proyectos) {
			if(proyecto_nombre.equals(proyecto.getNombre())) {
				proyectoEscogido = proyecto;
				System.out.println("/"+proyectoEscogido.getNombre()+"/");
				
			}	
		}
		
	
		//ProyectoDAOImplementation.getInstance().deleteProyecto(proyectoEscogido);
		
		//Actualizamos el nuevo Proyecto y redirigimos
		if(nombre!=null && nombre!="") {
			proyectoEscogido.setNombre(nombre);
		}
		if(fechaInicio!=null && fechaInicio!="") {
			proyectoEscogido.setFechaInicio(fechaInicio);
		}
		if(fechaFinal!=null && fechaFinal!="") {
			proyectoEscogido.setFechaFinal(fechaFinal);
		}
		if(empresaBuscada!=null) {
			proyectoEscogido.setId_Empresa(empresaBuscada);
		}
		
		//ProyectoDAOImplementation.getInstance().updateProyecto(proyectoEscogido);
		req.getSession().setAttribute("proyecto_seleccionado", proyectoEscogido.getNombre());	
		req.getSession().setAttribute("proyectos_list", ProyectoDAOImplementation.getInstance().readAllProyectosdeGestor(proyectoEscogido.getGestor()));
		req.getSession().setAttribute("trabajadores_proyecto", proyectoEscogido.getTrabajadoresProyecto());	
		resp.sendRedirect(req.getContextPath() + "/AreaGestor.jsp");
		
		
	}

}
