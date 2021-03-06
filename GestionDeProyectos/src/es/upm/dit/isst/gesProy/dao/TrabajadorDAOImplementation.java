package es.upm.dit.isst.gesProy.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.gesProy.dao.model.Trabajador;
import es.upm.dit.isst.gesProy.dao.SessionFactoryService;

public class TrabajadorDAOImplementation implements TrabajadorDAO{
	
private static TrabajadorDAOImplementation instance = null;
	
	private TrabajadorDAOImplementation() {
		
	}
	public static TrabajadorDAOImplementation getInstance() {
		if(instance == null) {
			instance = new TrabajadorDAOImplementation();
			}
		return instance;
	}
	@Override
	public Trabajador loginTrabajador(String email, String password) {
		Trabajador trabajador= null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			trabajador = (Trabajador) session.createQuery("select t from Trabajador t where"
					+ " t.email = :email and t.password = :password")
					.setParameter("email", email).setParameter("password", password)
					.uniqueResult();
			session.getTransaction().commit();
		}catch (Exception e) {
			
		}finally{
			session.close();
		}
		return trabajador;
	}
	public List<Trabajador> readAllTrabajador() {
		List<Trabajador> trabajadores = new ArrayList<>();
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			trabajadores.addAll(session.createQuery("from Trabajador").list());
			session.getTransaction().commit();
		}catch (Exception e) {
			
		}finally {
				session.close();
		}
		
		return trabajadores;
	}
	@Override
	public void createTrabajador(Trabajador trabajador) {
		Session session = SessionFactoryService.get().openSession();
		try {
				session.beginTransaction();
				session.save(trabajador);
				session.getTransaction().commit();
		}catch (Exception e) {
			
		}finally {
			session.close();
		}
	}
	@Override
	public Trabajador readTrabajador(int id_Trabajador) {
		Trabajador trabajador = null;

		Session session = SessionFactoryService.get().openSession();
		try {
				session.beginTransaction();
				trabajador = session.get(Trabajador.class, id_Trabajador);
				session.getTransaction().commit();
			} catch (Exception e) {
				
			} finally {
				session.close();
			}
		return trabajador;
	}
	@Override
	public void updateTrabajador(Trabajador trabajador) {
		Session session = SessionFactoryService.get().openSession();
		try {
				session.beginTransaction();
				session.saveOrUpdate(trabajador);
				session.getTransaction().commit();
			}catch (Exception e) {
				
			}finally {
				session.close();
			}
		
	}
	@Override
	public void deleteTrabajador(Trabajador trabajador) {
		Session session = SessionFactoryService.get().openSession();
		try {
				session.beginTransaction();
				session.delete(trabajador);
				session.getTransaction().commit();
			}catch (Exception e) {
				
			}finally {
				session.close();
			}
		
	}

}
