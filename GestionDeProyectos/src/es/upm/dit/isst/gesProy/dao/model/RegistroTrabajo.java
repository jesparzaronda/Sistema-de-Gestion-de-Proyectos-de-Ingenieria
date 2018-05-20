package es.upm.dit.isst.gesProy.dao.model;

import java.io.Serializable;
import java.util.Calendar;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class RegistroTrabajo implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_Registro;
	
	
	private String nombreTrabajador;
	
	private String nombreProyecto;
	
	private String nombreEmpresa;
	
	private Calendar horaInicio;
	private Calendar horaFinal;
	private double horasTrabajadas;
	
	
	
	
	public RegistroTrabajo() {
		
	}
	
	
	public int getId_Registro() {
		return id_Registro;
	}
	public void setId_Registro(int id_Registro) {
		this.id_Registro = id_Registro;
	}
	public String getId_Trabajador() {
		return nombreTrabajador;
	}
	public void setId_Trabajador(String nombreTrabajador) {
		this.nombreTrabajador = nombreTrabajador;
	}
	public Calendar getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Calendar horaInicio) {
		this.horaInicio = horaInicio;
	}
	public Calendar getHoraFinal() {
		return horaFinal;
	}
	public void setHoraFinal(Calendar horaFinal) {
		this.horaFinal = horaFinal;
	}
	
	
	public double getHorasTrabajadas() {
		return horasTrabajadas;
	}
	public void setHorasTrabajadas(double tiempoTrabajado) {
		this.horasTrabajadas = tiempoTrabajado;
	}
	public String getId_Proyecto() {
		return nombreProyecto;
	}
	public void setId_Proyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}
	
	public String getEmpresa() {
		return nombreEmpresa;
	}


	public void setEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	

}
