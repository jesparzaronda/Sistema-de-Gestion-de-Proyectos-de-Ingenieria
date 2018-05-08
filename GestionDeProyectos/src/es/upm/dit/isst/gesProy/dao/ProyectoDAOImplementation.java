package es.upm.dit.isst.gesProy.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.gesProy.dao.model.Proyecto;

public class ProyectoDAOImplementation implements ProyectoDAO{
	
private static ProyectoDAOImplementation instance = null;
	
	private  ProyectoDAOImplementation() {
		
	}
	public static ProyectoDAOImplementation getInstance() {
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
				session.update(proyecto);
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
	

	public List<Proyecto> readAllProyecto() {
		List<Proyecto> proyectos = new ArrayList<>();
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			proyectos.addAll(session.createQuery("from Proyecto").list());
			session.getTransaction().commit();
		}catch (Exception e) {
			
		}finally {
				session.close();
		}
		
		return proyectos;
	}
	public List<Proyecto> readAllProyectosdeGestor(String gestor) {
		List<Proyecto> proyectos = new ArrayList<>();
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			
			proyectos.addAll(session.createQuery("from Proyecto where :gestor = gestor").setParameter("gestor", gestor).list());
			session.getTransaction().commit();
		}catch (Exception e) {
			
		}finally {
				session.close();
		}
		
		return proyectos;
	}

}
