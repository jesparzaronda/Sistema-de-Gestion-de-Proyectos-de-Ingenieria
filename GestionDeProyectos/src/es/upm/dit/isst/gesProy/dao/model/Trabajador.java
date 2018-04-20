package es.upm.dit.isst.gesProy.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Trabajador implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
	private int id_Trabajador;
	
	private String nombre;
	private String apellidos;
	private int edad;
	private String email;
	private String password;
	private int privilegios;
	
	@ManyToOne
	private Empresa empresa;
	
	@ManyToMany
	private List<Proyecto> proyectosPosibles;
	
	@OneToMany(mappedBy = "trabajador", fetch = FetchType.EAGER)
	private List<RegistroTrabajo> registroTrabajador;
	
	public Trabajador() {
		this.proyectosPosibles = new ArrayList<>();
		this.registroTrabajador = new ArrayList<>();
	}

	public int getId_Trabajador() {
		return id_Trabajador;
	}

	public void setId_Trabajador(int id_Trabajador) {
		this.id_Trabajador = id_Trabajador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPrivilegios() {
		return privilegios;
	}

	public void setPrivilegios(int privilegios) {
		this.privilegios = privilegios;
	}

	//public int getId_empresa() {
	//	return id_Empresa;
	//}

	//public void setId_empresa(int id_empresa) {
		//this.id_Empresa = id_empresa;
	//}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//public int getId_Empresa() {
//		return id_Empresa;
//	}

	//public void setId_Empresa(int id_Empresa) {
	//	this.id_Empresa = id_Empresa;
	//}

	public List<Proyecto> getProyectosTrabajador() {
		return proyectosPosibles;
	}

	public void setProyectosTrabajador(List<Proyecto> proyectosTrabajador) {
		this.proyectosPosibles = proyectosTrabajador;
	}

	public List<RegistroTrabajo> getRegistroTrabajador() {
		return registroTrabajador;
	}

	public void setRegistroTrabajador(List<RegistroTrabajo> registroTrabajador) {
		this.registroTrabajador = registroTrabajador;
	}

}
