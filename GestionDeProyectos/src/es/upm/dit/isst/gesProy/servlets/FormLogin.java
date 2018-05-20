package es.upm.dit.isst.gesProy.servlets;

import java.io.IOException;
import java.util.List;

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
 * Servlet Inicial. En página de login se introduce user y password.
 */
@WebServlet("/FormLogin")
public class FormLogin extends HttpServlet {
	
	private final String ADMIN_EMAIL = "root";
	private final String ADMIN_PASSWORD = "root";
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		Trabajador trabajador = TrabajadorDAOImplementation.getInstance().loginTrabajador(email, password);
		
		if (ADMIN_EMAIL.equals(email) && ADMIN_PASSWORD.equals(password)) {
			req.getSession().setAttribute("adminLogged", true);
			req.getSession().setAttribute("trabajadores_list", TrabajadorDAOImplementation.getInstance().readAllTrabajador());
			resp.sendRedirect(req.getContextPath() + "/admin.jsp");
		} else if(trabajador != null ) {
			if(trabajador.getPrivilegios() == 1) {
				req.getSession().setAttribute("trabajadorLogged", email );
				List<Proyecto> proyectosTrabajador = TrabajadorDAOImplementation.getInstance().getProyectosTrabajador(email);
				req.getSession().setAttribute("proyectos_trabajador", proyectosTrabajador);
				req.getSession().setAttribute("proyecto_seleccionado", proyectosTrabajador.get(0).getNombre());
				req.getSession().setAttribute("proyecto_trabajador", proyectosTrabajador.get(0).getGestor());
				for(int i = 0; i< proyectosTrabajador.size(); i ++) {
					System.out.println(proyectosTrabajador.get(i).getNombre());
				}
				resp.sendRedirect(req.getContextPath() + "/AreaTrabajador.jsp");
			} else if(trabajador.getPrivilegios() == 2) {
				req.getSession().setAttribute("gestorLogged", email );
				req.getSession().setAttribute("trabajadores_list", TrabajadorDAOImplementation.getInstance().readAllTrabajador());
				String nombreGestor = TrabajadorDAOImplementation.getInstance().obtenerNombreTrabajador(email);
				List<Proyecto> proyectosGestor = ProyectoDAOImplementation.getInstance().readAllProyectosdeGestor(nombreGestor);
				req.getSession().setAttribute("proyectos_list", proyectosGestor);
				if(proyectosGestor!=null && !proyectosGestor.isEmpty()) {
					req.getSession().setAttribute("proyecto_seleccionado", proyectosGestor.get(0).getNombre());
					req.getSession().setAttribute("proyecto_gestor", proyectosGestor.get(0).getGestor());
					req.getSession().setAttribute("trabajadores_proyecto", proyectosGestor.get(0).getTrabajadoresProyecto());
				}
				resp.sendRedirect(req.getContextPath() + "/AreaGestor.jsp");
			}	else  if(trabajador.getPrivilegios() == 3) {
				req.getSession().setAttribute("RRHHLogged", email );
				req.getSession().setAttribute("trabajadores_list", TrabajadorDAOImplementation.getInstance().readAllTrabajador());
				req.getSession().setAttribute("proyectos_list", ProyectoDAOImplementation.getInstance().readAllProyecto());
				
				resp.sendRedirect(req.getContextPath() + "/AreaRecursos.jsp");
			}
		
		
		}else {
				resp.sendRedirect(req.getContextPath() + "/Login.jsp");
				
		}
	}

}
