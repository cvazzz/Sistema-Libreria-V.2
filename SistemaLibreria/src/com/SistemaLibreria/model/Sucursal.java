package com.SistemaLibreria.model;

public class Sucursal {
	private int codigo;
	private String nombre;
	private String direccion;
	private int estado;
	public Sucursal() {
		
		
	}
	public Sucursal(int codigo, String nombre, String direccion, int estado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.estado = estado;
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}

}
