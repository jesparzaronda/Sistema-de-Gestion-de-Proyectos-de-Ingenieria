package es.upm.dit.isst.gesProy.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.gesProy.dao.EmpresaDAOImplementation;
import es.upm.dit.isst.gesProy.dao.TrabajadorDAOImplementation;
import es.upm.dit.isst.gesProy.dao.model.Empresa;
import es.upm.dit.isst.gesProy.dao.model.Trabajador;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Se guardan todos los datos introducidos en la Web de Administrador
		String nombre = req.getParameter("nombre");
		String apellidos = req.getParameter("apellidos");
		int edad = Integer.parseInt(req.getParameter("edad"));
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String nombreEmpresa = req.getParameter("empresa");
		Empresa empresa = EmpresaDAOImplementation.getInstance().readEmpresa(nombreEmpresa);
		int privilegios = Integer.parseInt(req.getParameter("privilegio"));
		
		//Creamos un nuevo objeto trabajador
		Trabajador trabajador = new Trabajador();
		
		//Creamos el trabajador con los datos introducidos en la Web.
		trabajador.setNombre(nombre);
		trabajador.setApellidos(apellidos);
		trabajador.setEdad(edad);
		trabajador.setEmail(email);
		trabajador.setPrivilegios(privilegios);
		trabajador.setPassword(password);
		trabajador.setEmpresa(empresa);
		
		//Ahora, metemos en la base de datos al nuevo trabajador.
		TrabajadorDAOImplementation.getInstance().createTrabajador(trabajador);
		resp.sendRedirect(req.getContextPath() + "/admin.jsp");
		
		
		
	}


}
