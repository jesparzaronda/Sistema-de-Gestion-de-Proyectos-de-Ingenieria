package es.upm.dit.isst.gesProy.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.hibernate.Session;

import es.upm.dit.isst.gesProy.dao.model.Proyecto;
import es.upm.dit.isst.gesProy.dao.model.RegistroTrabajo;
import es.upm.dit.isst.gesProy.dao.model.Trabajador;;

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
	public String calcularHorasTotales(String nombreTrabajador) {
		List<RegistroTrabajo> listaRegistros = new ArrayList<>();
		double tiempoTotalNumero = 0;
		String respuesta = null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			listaRegistros.addAll(session.createQuery("from RegistroTrabajo where :nombreTrabajador = nombreTrabajador").setParameter("nombreTrabajador", nombreTrabajador).list());
			
			for(int i = 0; i < listaRegistros.size(); i++) {
				tiempoTotalNumero+=listaRegistros.get(i).getHorasTrabajadas();	
			}
			double hora = tiempoTotalNumero/3600000;
			double restoHora = tiempoTotalNumero%3600000;
			double minuto = restoHora/60000;
			double restoMinuto = restoHora%60000;
			double segundo = restoMinuto/1000;
			respuesta = (int)hora + "h " + (int)minuto + "m " + (int)segundo + "s";
		session.getTransaction().commit();
		
		}catch (Exception e) {
			
		}finally {
				session.close();
		}
		
		return respuesta;
	}

	public List<Double> calcularHorasPorDia(Trabajador trabajador, Proyecto proyecto) {
		List<RegistroTrabajo> listaRegistros = new ArrayList<>();
		Session session = SessionFactoryService.get().openSession();
		List<Double> horasPorDia = new ArrayList<>();
		try {
			session.beginTransaction();
			listaRegistros.addAll(session.createQuery("from RegistroTrabajo where :trabajador = trabajador and proyecto = :proyecto").setParameter("trabajador", trabajador).setParameter("proyecto", proyecto).list());		
			for(int i = 1; i < 32; i++) {
				double horas = 0;
				for(int n = 0; n < listaRegistros.size(); n++) {
					if(listaRegistros.get(n).getHoraInicio().get(Calendar.DAY_OF_MONTH)==i) {
						horas += listaRegistros.get(n).getHorasTrabajadas();
					}		
				}
				horasPorDia.add(horas);		
			}
			
			
		
		session.getTransaction().commit();
		
		}catch (Exception e) {
			
		}finally {
				session.close();
		}
		
		return horasPorDia;
	}
	public String horasTrabajadorPorProyecto(String nombreTrabajador, String nombreProyecto) {
		List<RegistroTrabajo> listaRegistros = new ArrayList<>();
		List<Double> listaTiempo = new ArrayList<>();
		double tiempoTotalMilisegundos = 0;
		String respuesta = null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			listaRegistros.addAll( session.createQuery("from RegistroTrabajo where :nombreTrabajador = nombreTrabajador and"
					+ " :nombreProyecto = nombreProyecto")
					.setParameter("nombreTrabajador", nombreTrabajador).setParameter("nombreProyecto", nombreProyecto).list());
			for(int i = 0; i < listaRegistros.size(); i++) {
				listaTiempo.add(listaRegistros.get(i).getHorasTrabajadas());
			}
			//Una vez sacado todos los tiempos, sumamos todos los milisegundos.
			for(int i = 0; i < listaTiempo.size(); i++) {
				tiempoTotalMilisegundos = tiempoTotalMilisegundos + listaTiempo.get(i);
			}
			double hora = tiempoTotalMilisegundos/3600000;
			double restoHora = tiempoTotalMilisegundos%3600000;
			double minuto = restoHora/60000;
			double restoMinuto = restoHora%60000;
			double segundo = restoMinuto/1000;
			respuesta = (int)hora + "h " + (int)minuto + "m " + (int)segundo + "s";
			
			session.getTransaction().commit();
		}catch (Exception e) {
			
		}finally {
			session.close();
		}
		return respuesta;
	}
	
	
	public double horasTrabajadorEntero(String nombreTrabajador) {
		List<RegistroTrabajo> listaRegistros = new ArrayList<>();
		List<Double> listaTiempo = new ArrayList<>();
		double tiempoTotalMilisegundos = 0;
		double respuesta = 0;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			listaRegistros.addAll( session.createQuery("from RegistroTrabajo where :nombreTrabajador = nombreTrabajador").setParameter("nombreTrabajador", nombreTrabajador).list());
			for(int i = 0; i < listaRegistros.size(); i++) {
				listaTiempo.add(listaRegistros.get(i).getHorasTrabajadas());
			}
			//Una vez sacado todos los tiempos, sumamos todos los milisegundos.
			for(int i = 0; i < listaTiempo.size(); i++) {
				tiempoTotalMilisegundos = tiempoTotalMilisegundos + listaTiempo.get(i);
			}
			
			respuesta = tiempoTotalMilisegundos;		
			session.getTransaction().commit();
		}catch (Exception e) {
			
		}finally {
			session.close();
		}
		return respuesta;
	}
	
	public double horasTrabajadoresEntero() {
		List<RegistroTrabajo> listaRegistros = new ArrayList<>();
		List<Double> listaTiempo = new ArrayList<>();
		double tiempoTotalMilisegundos = 0;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			listaRegistros.addAll( session.createQuery("from RegistroTrabajo").list());
			for(int i = 0; i < listaRegistros.size(); i++) {
				listaTiempo.add(listaRegistros.get(i).getHorasTrabajadas());
			}
			//Una vez sacado todos los tiempos, sumamos todos los milisegundos.
			for(int i = 0; i < listaTiempo.size(); i++) {
				tiempoTotalMilisegundos = tiempoTotalMilisegundos + listaTiempo.get(i);
			}
					
			session.getTransaction().commit();
		}catch (Exception e) {
			
		}finally {
			session.close();
		}
		return tiempoTotalMilisegundos;
	}
	
}
