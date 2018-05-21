package es.upm.dit.isst.gesProy.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.gesProy.dao.ProyectoDAOImplementation;
import es.upm.dit.isst.gesProy.dao.TrabajadorDAOImplementation;
import es.upm.dit.isst.gesProy.dao.model.Proyecto;

/**
 * Servlet implementation class TrabajadorToGestor
 */
@WebServlet("/TrabajadorToGestor")
public class TrabajadorToGestor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrabajadorToGestor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().setAttribute("trabajadorLogged" , null);
		req.getSession().setAttribute("trabajadores_list", TrabajadorDAOImplementation.getInstance().readAllTrabajador());
		String nombreGestor = TrabajadorDAOImplementation.getInstance().obtenerNombreTrabajador((String)req.getSession().getAttribute("gestorLogged"));
		List<Proyecto> proyectosGestor = ProyectoDAOImplementation.getInstance().readAllProyectosdeGestor(nombreGestor);
		req.getSession().setAttribute("proyectos_list", proyectosGestor);
		List<Proyecto> proyectosTrabajador = TrabajadorDAOImplementation.getInstance().getProyectosTrabajador((String)req.getSession().getAttribute("gestorLogged"));
		req.getSession().setAttribute("proyectos_trabajador", proyectosTrabajador);
		req.getSession().setAttribute("proyecto_trabajador", proyectosTrabajador.get(0).getGestor());
		if(proyectosGestor!=null && !proyectosGestor.isEmpty()) {
			req.getSession().setAttribute("proyecto_seleccionado", proyectosGestor.get(0).getNombre());
			req.getSession().setAttribute("proyecto_gestor", proyectosGestor.get(0).getGestor());
			req.getSession().setAttribute("trabajadores_proyecto", proyectosGestor.get(0).getTrabajadoresProyecto());
			
		resp.sendRedirect(req.getContextPath() + "/AreaGestor.jsp");
		
	}

	
	

}
}
