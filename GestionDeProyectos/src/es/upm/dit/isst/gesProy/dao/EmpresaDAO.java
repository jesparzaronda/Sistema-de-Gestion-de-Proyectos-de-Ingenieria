package es.upm.dit.isst.gesProy.dao;

import es.upm.dit.isst.gesProy.dao.model.Empresa;

public interface EmpresaDAO {
	
	public void createEmpresa(Empresa empresa);
	
	public Empresa readEmpresa(String nombre);
	
	public void updateEmpresa(Empresa empresa);
	
	public void deleteEmpresa(Empresa empresa);
}
