package es.upm.dit.isst.gesProy.dao;

import java.util.List;

import es.upm.dit.isst.gesProy.dao.model.Trabajador;

public interface TrabajadorDAO {
	
	public Trabajador loginTrabajador( String email, String password);
	
	public List<Trabajador> readAllTrabajador();
	
	public void createTrabajador(Trabajador trabajador);
	
	public Trabajador readTrabajador(int id_Trabajador);
	
	public void updateTrabajador(Trabajador trabajador);
	
	public void deleteTrabajador(Trabajador trabajador);

}
