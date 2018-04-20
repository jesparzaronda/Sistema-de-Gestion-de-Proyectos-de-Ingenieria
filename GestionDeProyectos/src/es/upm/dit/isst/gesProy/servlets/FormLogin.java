package es.upm.dit.isst.gesProy.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.gesProy.dao.TrabajadorDAOImplementation;
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
			resp.sendRedirect(req.getContextPath() + "/AreaTrabajador.jsp");
		} else {
				resp.sendRedirect(req.getContextPath() + "/Login.jsp");
		}
	}

}
