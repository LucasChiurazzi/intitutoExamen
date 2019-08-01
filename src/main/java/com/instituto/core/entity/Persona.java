package com.instituto.core.entity;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
public abstract class Persona implements Serializable {

	public Persona() {
				
	}
	public Persona(String tipodni, int dni, String nombre, String apellido, Date fechanac, String sexo,
			String telefono, @Size(max = 250) String domicilio) {
			
		this.tipodni = tipodni;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechanac = fechanac;
		this.sexo = sexo;
		this.telefono = telefono;
		this.domicilio = domicilio;
	}



	public Persona(long id, String tipodni, int dni, String nombre, String apellido, Date fechanac, String sexo,
			String telefono, @Size(max = 250) String domicilio) {
		
		this.id = id;
		this.tipodni = tipodni;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechanac = fechanac;
		this.sexo = sexo;
		this.telefono = telefono;
		this.domicilio = domicilio;
	}


	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID", updatable = false, nullable = false)
	private long id;
	
	@NotNull
	@Column(name="TIPODNI")
	private String tipodni;
	
	@NotNull
	@Column(name= "DNI")
	private int dni;
	
	@NotNull
	@Column(name= "NOMBRE")
	private String nombre;
	
	@NotNull
	@Column(name="APELLIDO")
	private String apellido;
	
	@NotNull
	@Column(name="FECHANAC")
	@Temporal(TemporalType.DATE)
	private Date fechanac;
	
	@NotNull
	@Column(name="SEXO")
	private String sexo;
	
	@NotNull
	@Column(name="TELEFONO")
	private String telefono;
	
	@NotNull
	@Column(name="DOMICILIO")
    @Size(max = 250)
	private String domicilio;
	
	
	


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getTipodni() {
		return tipodni;
	}


	public void setTipodni(String tipodni) {
		this.tipodni = tipodni;
	}


	public int getDni() {
		return dni;
	}


	public void setDni(int dni) {
		this.dni = dni;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public Date getFechanac() {
		return fechanac;
	}


	public void setFechanac(Date fechanac) {
		this.fechanac = fechanac;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getDomicilio() {
		return domicilio;
	}


	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
	
	
}
