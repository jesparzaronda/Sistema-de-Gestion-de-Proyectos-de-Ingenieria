package es.upm.dit.isst.gesProy.dao.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class RegistroTrabajo implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private int id_Registro;
	
	@ManyToOne
	private Trabajador trabajador;
	@ManyToOne
	private Proyecto proyecto;
	
	private Date horaInicio;
	private Date horaFinal;
	private int horasTrabajadas;
	
	
	
	
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
	public Date getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}
	public Date getHoraFinal() {
		return horaFinal;
	}
	public void setHoraFinal(Date horaFinal) {
		this.horaFinal = horaFinal;
	}
	public int getHorasTrabajadas() {
		return horasTrabajadas;
	}
	public void setHorasTrabajadas(int horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}
	public Proyecto getId_Proyecto() {
		return proyecto;
	}
	public void setId_Proyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	

	

}
