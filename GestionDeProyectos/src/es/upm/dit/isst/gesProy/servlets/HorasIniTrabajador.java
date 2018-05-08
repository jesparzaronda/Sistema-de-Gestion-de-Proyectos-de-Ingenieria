package es.upm.dit.isst.gesProy.servlets;

import java.io.IOException;
import java.util.Calendar;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HorasTrabajador
 */
@WebServlet("/HorasIniTrabajador")
public class HorasIniTrabajador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
			Calendar fechaInicio = Calendar.getInstance();			
			//Guardamos id de registro en la sesión actual
			req.getSession().setAttribute("Hora_Inicial",fechaInicio);
			resp.sendRedirect(req.getContextPath() + "/AreaTrabajador.jsp");
							
		}
	}


