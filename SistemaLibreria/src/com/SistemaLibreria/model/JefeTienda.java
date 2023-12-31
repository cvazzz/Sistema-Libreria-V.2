package com.SistemaLibreria.model;

public class JefeTienda {

	private int codigo;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String dni;
	
	public JefeTienda(int codigo,  String nombre, String apellidoPaterno, String apellidoMaterno, String dni) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;	
		this.dni = dni;
	}


	public JefeTienda() {
		// TODO Auto-generated constructor stub
	}


	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
}
