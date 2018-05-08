package es.upm.dit.isst.gesProy.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Proyecto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String nombre;
	
	private String gestor;
	private String fechaInicio;
	private String fechaFinal;
	
	@ManyToOne
	private Empresa empresa;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Trabajador> trabajadoresPosibles;
	
	
	@OneToMany(mappedBy = "proyecto", fetch = FetchType.EAGER)
	private List<RegistroTrabajo> registroProyecto;
	
	public Proyecto () {
		
		this.registroProyecto = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGestor() {
		return gestor;
	}

	public void setGestor(String gestor) {
		this.gestor = gestor;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Empresa getId_Empresa() {
		return empresa;
	}

	public void setId_Empresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Trabajador> getTrabajadoresProyecto() {
		return trabajadoresPosibles;
	}

	public void setTrabajadoresProyecto(List<Trabajador> trabajadoresPosibles) {
		this.trabajadoresPosibles = trabajadoresPosibles;
	}

	public List<RegistroTrabajo> getRegistroProyecto() {
		return registroProyecto;
	}

	public void setRegistroProyecto(List<RegistroTrabajo> registroProyecto) {
		this.registroProyecto = registroProyecto;
	}
	public void inicializarListTrabajadores() {
		this.trabajadoresPosibles = new ArrayList<>();
	}
	
	
	
	

}
