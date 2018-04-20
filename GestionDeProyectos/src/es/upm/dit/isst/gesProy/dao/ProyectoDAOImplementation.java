package es.upm.dit.isst.gesProy.dao;

import org.hibernate.Session;

import es.upm.dit.isst.gesProy.dao.model.Proyecto;

public class ProyectoDAOImplementation implements ProyectoDAO{
	
private ProyectoDAOImplementation instance = null;
	
	private  ProyectoDAOImplementation() {
		
	}
	private ProyectoDAOImplementation getInstance() {
		if(instance == null) {
			instance = new ProyectoDAOImplementation();
			}
		return instance;
	}
	@Override
	public void createProyecto(Proyecto proyecto) {
		Session session = SessionFactoryService.get().openSession();
		try {
				session.beginTransaction();
				session.save(proyecto);
				session.getTransaction().commit();
		}catch (Exception e) {
			
		}finally {
			session.close();
		}
	}
	@Override
	public Proyecto readProyecto(int id_Proyecto) {
		Proyecto proyecto = null;

		Session session = SessionFactoryService.get().openSession();
		try {
				session.beginTransaction();
				proyecto = session.get(Proyecto.class, id_Proyecto);
				session.getTransaction().commit();
			} catch (Exception e) {
				
			} finally {
				session.close();
			}
		return proyecto;
	}
	@Override
	public void updateProyecto(Proyecto proyecto) {
		Session session = SessionFactoryService.get().openSession();
		try {
				session.beginTransaction();
				session.saveOrUpdate(proyecto);
				session.getTransaction().commit();
			}catch (Exception e) {
				
			}finally {
				session.close();
			}
		
	}
	@Override
	public void deleteProyecto(Proyecto proyecto) {
		Session session = SessionFactoryService.get().openSession();
		try {
				session.beginTransaction();
				session.delete(proyecto);
				session.getTransaction().commit();
			}catch (Exception e) {
				
			}finally {
				session.close();
			}
		
	}

}
