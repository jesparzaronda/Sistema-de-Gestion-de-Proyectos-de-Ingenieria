package es.upm.dit.isst.gesProy.dao;

import es.upm.dit.isst.gesProy.dao.model.Proyecto;

public interface ProyectoDAO {
	
	public void createProyecto(Proyecto proyecto);
	
	public Proyecto readProyecto(int id_Proyecto);
	
	public void updateProyecto(Proyecto proyecto);
	
	public void deleteProyecto(Proyecto proyecto);

	
}
