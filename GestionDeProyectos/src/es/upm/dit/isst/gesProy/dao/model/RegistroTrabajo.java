package es.upm.dit.isst.gesProy.dao.model;

import java.io.Serializable;
import java.util.Calendar;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	@ManyToOne
	//@JoinColumn(name="Trabajadores")
	private Trabajador trabajador;
	@ManyToOne
	private Proyecto proyecto;
	
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
	public Trabajador getId_Trabajador() {
		return trabajador;
	}
	public void setId_Trabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
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
	public void setHorasTrabajadas(double horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}
	public Proyecto getId_Proyecto() {
		return proyecto;
	}
	public void setId_Proyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	

	

}
