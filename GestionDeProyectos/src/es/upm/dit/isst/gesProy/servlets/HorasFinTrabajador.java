package es.upm.dit.isst.gesProy.servlets;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.gesProy.dao.RegistroTrabajoDAOImplementation;
import es.upm.dit.isst.gesProy.dao.TrabajadorDAOImplementation;
import es.upm.dit.isst.gesProy.dao.model.RegistroTrabajo;
import es.upm.dit.isst.gesProy.dao.model.Trabajador;

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
		int horas = (int)milisec/3600000;
		double restohora = milisec%3600000;
		int minutos = (int)restohora/60000;
		double restominuto = restohora%60000;
		int segundos = (int)restominuto/1000;
		
		String tiempoTrabajado = String.valueOf(horas)+"h "+String.valueOf(minutos)+"min "+String.valueOf(segundos)+ "s ";
		registro.setHorasTrabajadas(tiempoTrabajado);
		
		String emailTrabajador = (String)req.getSession().getAttribute("trabajadorLogged");
		List<Trabajador> trabajadores = TrabajadorDAOImplementation.getInstance().readAllTrabajador();
		Trabajador trabajadorBuscado = null;
		for(Trabajador trabajador : trabajadores) {
			if ((trabajador.getEmail()).equals(emailTrabajador)) {
				trabajadorBuscado = trabajador;
			}
		}
		
		
		
		registro.setHoraInicio(fechaInicio);
		registro.setHoraFinal(fechaFinal);
		//registro.setId_Proyecto(proyecto);
		registro.setId_Trabajador(trabajadorBuscado);
		
		RegistroTrabajoDAOImplementation.getInstance().createRegistro(registro);
		resp.sendRedirect(req.getContextPath()+ "/AreaTrabajador.jsp");
		
				
	}
	}

	


