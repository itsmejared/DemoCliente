package com.demo.cliente.model;

public class ClienteModel {

	private String nombre;
	private String apellido;
	private int edad;
	private String fecha_nacimiento;

	public ClienteModel(String nombre, String apellido, int edad, String fecha_nacimiento) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.fecha_nacimiento = fecha_nacimiento;
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

}
