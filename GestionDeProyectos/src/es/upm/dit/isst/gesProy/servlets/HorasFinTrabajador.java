package es.upm.dit.isst.gesProy.servlets;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.gesProy.dao.RegistroTrabajoDAOImplementation;
import es.upm.dit.isst.gesProy.dao.model.RegistroTrabajo;

/**
 * Servlet implementation class HorasFinTrabajador
 */
@WebServlet("/HorasFinTrabajador")
public class HorasFinTrabajador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Calendar fechaFinal = Calendar.getInstance();
		Calendar fechaInicio = (Calendar)req.getSession().getAttribute("Hora_Inicial");
		RegistroTrabajo registro = new RegistroTrabajo();
		
		double milisec = fechaFinal.getTimeInMillis() - fechaInicio.getTimeInMillis();
		double horasTrabajadas = milisec/1000/60;
		System.out.println(milisec);
		System.out.println(horasTrabajadas);
		
		
		
		registro.setHorasTrabajadas(horasTrabajadas);
		registro.setHoraInicio(fechaInicio);
		registro.setHoraFinal(fechaFinal);
		
		RegistroTrabajoDAOImplementation.getInstance().createRegistro(registro);
		
		
				
	}
	}

	


