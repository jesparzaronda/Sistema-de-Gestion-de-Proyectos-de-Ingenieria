package es.upm.dit.isst.gesProy.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.io.IOException;

import es.upm.dit.isst.gesProy.dao.EmpresaDAOImplementation;
import es.upm.dit.isst.gesProy.dao.ProyectoDAOImplementation;
import es.upm.dit.isst.gesProy.dao.model.Empresa;
import es.upm.dit.isst.gesProy.dao.model.Proyecto;

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
		String gestor = req.getParameter("gestor");
		String fechaInicio = req.getParameter("fechaInicio");		
		String fechaFinal = req.getParameter("fechaFinal");	
		Empresa empresa = (Empresa) req.getAttribute("Empresa");
		
		
		//Creamos la nueva empresa
		Proyecto nuevoProyecto = new Proyecto();
		
		nuevoProyecto.setNombre(nombre);
		nuevoProyecto.setGestor(gestor);
		nuevoProyecto.setFechaInicio(fechaInicio);
		nuevoProyecto.setFechaFinal(fechaFinal);
		nuevoProyecto.setId_Empresa(empresa);
	
		
		ProyectoDAOImplementation.getInstance().createProyecto(nuevoProyecto);
		resp.sendRedirect(req.getContextPath()+ "/AreaGestor.jsp");
		
	}


}