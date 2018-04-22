package es.upm.dit.isst.gesProy.dao;

import org.hibernate.Session;

import es.upm.dit.isst.gesProy.dao.model.RegistroTrabajo;;

public class RegistroTrabajoDAOImplementation implements RegistroTrabajoDAO{
	
private static RegistroTrabajoDAOImplementation instance = null;
	
	private  RegistroTrabajoDAOImplementation() {
		
	}
	public static RegistroTrabajoDAOImplementation getInstance() {
		if(instance == null) {
			instance = new RegistroTrabajoDAOImplementation();
			}
		return instance;
	}
	@Override
	public void createRegistro(RegistroTrabajo registro) {
		Session session = SessionFactoryService.get().openSession();
		try {
				session.beginTransaction();
				session.save(registro);
				session.getTransaction().commit();
		}catch (Exception e) {
			
		}finally {
			session.close();
		}
	}
	@Override
	public RegistroTrabajo readRegistro(int id_Registro) {
		RegistroTrabajo registro = null;

		Session session = SessionFactoryService.get().openSession();
		try {
				session.beginTransaction();
				registro = session.get(RegistroTrabajo.class, id_Registro);
				session.getTransaction().commit();
			} catch (Exception e) {
				
			} finally {
				session.close();
			}
		return registro;
	}
	@Override
	public void updateRegistro(RegistroTrabajo registro) {
		Session session = SessionFactoryService.get().openSession();
		try {
				session.beginTransaction();
				session.saveOrUpdate(registro);
				session.getTransaction().commit();
			}catch (Exception e) {
				
			}finally {
				session.close();
			}
		
	}
	@Override
	public void deleteRegistro(RegistroTrabajo registro) {
		Session session = SessionFactoryService.get().openSession();
		try {
				session.beginTransaction();
				session.delete(registro);
				session.getTransaction().commit();
			}catch (Exception e) {
				
			}finally {
				session.close();
			}
		
	}

}
