package es.upm.dit.isst.gesProy.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.gesProy.dao.EmpresaDAOImplementation;
import es.upm.dit.isst.gesProy.dao.model.Empresa;


/**
 * Servlet de Gestion de proyectos.
 */
@WebServlet("/FormAñadirNuevaEmpresa")
public class FormAñadirNuevaEmpresa extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nombre = req.getParameter("nombre");
		String cif = req.getParameter("cif");
		int codigoPostal = Integer.parseInt(req.getParameter("codigoPostal"));		
		int telefono = Integer.parseInt(req.getParameter("telefono"));
		String ciudad = req.getParameter("ciudad");
		String email = req.getParameter("email");
		
		//Creamos la nueva empresa
		Empresa nuevaEmpresa = new Empresa();
		
		nuevaEmpresa.setNombre(nombre);
		nuevaEmpresa.setCIF(cif);
		nuevaEmpresa.setCodigoPostal(codigoPostal);
		nuevaEmpresa.setTelefono(telefono);
		nuevaEmpresa.setCiudad(ciudad);
		nuevaEmpresa.setEmail(email);
		
		EmpresaDAOImplementation.getInstance().createEmpresa(nuevaEmpresa);
		resp.sendRedirect(req.getContextPath()+ "/admin.jsp");
		
		
	}
	
}
