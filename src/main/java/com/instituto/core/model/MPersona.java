package com.instituto.core.model;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.instituto.core.entity.Persona;


public abstract class MPersona implements Serializable {

	public MPersona() {
		
	}
	
	
	
	public MPersona(Persona persona) {
		this.id = persona.getId();
		this.tipodni = persona.getTipodni();
		this.dni = persona.getDni();
		this.nombre = persona.getNombre();
		this.apellido = persona.getApellido();
		this.fechanac = persona.getFechanac();
		this.sexo = persona.getSexo();
		this.telefono = persona.getTelefono();
		this.domicilio = persona.getDomicilio();
		
	}
	
	
	public MPersona(long id, String tipodni, int dni, String nombre, String apellido, Date fechanac, String sexo,
			String telefono, String domicilio) {

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


	private long id;
	
	private String tipodni;
	
	private int dni;
	
	private String nombre;
	
	private String apellido;
	
	private Date fechanac;
	
	private String sexo;
	
	private String telefono;
		
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
