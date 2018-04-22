package es.upm.dit.isst.gesProy.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Empresa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String Nombre;
	
	private String CIF;
	private int codigoPostal;
	private int telefono;
	private String ciudad;
	private String email;
	
	@OneToMany(mappedBy = "empresa", fetch = FetchType.EAGER)
	private List<Trabajador> trabajadoresEmpresa;
	
	@OneToMany(mappedBy = "empresa", fetch = FetchType.EAGER)
	private List<Proyecto> proyectosEmpresa;
	
	
	

	public Empresa() {
		this.trabajadoresEmpresa = new ArrayList<>();
		this.proyectosEmpresa = new ArrayList<>();
		
	}
	
	public List<Trabajador> getTrabajadoresEmpresa() {
		return trabajadoresEmpresa;
	}

	public void setTrabajadoresEmpresa(List<Trabajador> trabajadoresEmpresa) {
		this.trabajadoresEmpresa = trabajadoresEmpresa;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getCIF() {
		return CIF;
	}

	public void setCIF(String cIF) {
		CIF = cIF;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Proyecto> getProyectosEmpresa() {
		return proyectosEmpresa;
	}

	public void setProyectosEmpresa(List<Proyecto> proyectosEmpresa) {
		this.proyectosEmpresa = proyectosEmpresa;
	}
	
	

}
