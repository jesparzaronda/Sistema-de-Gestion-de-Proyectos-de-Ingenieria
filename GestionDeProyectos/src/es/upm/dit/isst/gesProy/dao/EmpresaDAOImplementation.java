package es.upm.dit.isst.gesProy.dao;

import org.hibernate.Session;

import es.upm.dit.isst.gesProy.dao.model.Empresa;
import es.upm.dit.isst.gesProy.dao.SessionFactoryService;

public class EmpresaDAOImplementation implements EmpresaDAO{
	
	private EmpresaDAOImplementation instance = null;
	
	private  EmpresaDAOImplementation() {
		
	}
	private EmpresaDAOImplementation getInstance() {
		if(instance == null) {
			instance = new EmpresaDAOImplementation();
			}
		return instance;
	}
	@Override
	public void createEmpresa(Empresa empresa) {
		Session session = SessionFactoryService.get().openSession();
		try {
				session.beginTransaction();
				session.save(empresa);
				session.getTransaction().commit();
		}catch (Exception e) {
			
		}finally {
			session.close();
		}
	}
	@Override
	public Empresa readEmpresa(int id_Empresa) {
		Empresa empresa = null;

		Session session = SessionFactoryService.get().openSession();
		try {
				session.beginTransaction();
				empresa = session.get(Empresa.class, id_Empresa);
				session.getTransaction().commit();
			} catch (Exception e) {
				
			} finally {
				session.close();
			}
		return empresa;
	}
	@Override
	public void updateEmpresa(Empresa empresa) {
		Session session = SessionFactoryService.get().openSession();
		try {
				session.beginTransaction();
				session.saveOrUpdate(empresa);
				session.getTransaction().commit();
			}catch (Exception e) {
				
			}finally {
				session.close();
			}
		
	}
	@Override
	public void deleteEmpresa(Empresa empresa) {
		Session session = SessionFactoryService.get().openSession();
		try {
				session.beginTransaction();
				session.delete(empresa);
				session.getTransaction().commit();
			}catch (Exception e) {
				
			}finally {
				session.close();
			}
		
	}

}
