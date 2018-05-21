package es.upm.dit.isst.gesProy.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.gesProy.dao.TrabajadorDAOImplementation;
import es.upm.dit.isst.gesProy.dao.model.Proyecto;

/**
 * Servlet implementation class GestorToTrabajador
 */
@WebServlet("/GestorToTrabajador")
public class GestorToTrabajador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestorToTrabajador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String trabajador = (String) req.getSession().getAttribute("gestorLogged");
		List<Proyecto> proyectosTrabajador = TrabajadorDAOImplementation.getInstance().getProyectosTrabajador(trabajador);
		req.getSession().setAttribute("proyectos_trabajador", proyectosTrabajador);
		if(proyectosTrabajador!=null && !proyectosTrabajador.isEmpty()) {
			req.getSession().setAttribute("proyecto_seleccionado", proyectosTrabajador.get(0).getNombre());
			req.getSession().setAttribute("proyecto_trabajador", proyectosTrabajador.get(0).getGestor());
		}
		req.getSession().setAttribute("trabajadorLogged", trabajador);
		resp.sendRedirect(req.getContextPath() + "/AreaTrabajador.jsp");
	}

	

}
