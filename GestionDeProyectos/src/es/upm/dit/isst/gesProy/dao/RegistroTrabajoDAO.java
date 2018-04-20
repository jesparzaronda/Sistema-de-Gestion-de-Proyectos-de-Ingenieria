package es.upm.dit.isst.gesProy.dao;

import es.upm.dit.isst.gesProy.dao.model.RegistroTrabajo;

public interface RegistroTrabajoDAO {
	
	public void createRegistro(RegistroTrabajo registro);
	
	public RegistroTrabajo readRegistro(int id_Registro);
	
	public void updateRegistro(RegistroTrabajo registro);
	
	public void deleteRegistro(RegistroTrabajo registro);


}
