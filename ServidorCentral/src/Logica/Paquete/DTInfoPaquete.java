package Logica.Paquete;

import java.util.Set;

public class DTInfoPaquete {
	private String nombre;
	private String descripcion;
	private int validez;
	private float descuento;
	private Set<String> colActividades;
	
	
	
	public DTInfoPaquete(String nombre, String descripcion, int validez, float descuento, Set<String> colActividades) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.validez = validez;
		this.descuento = descuento;
		this.colActividades = colActividades;
	}
	
	public String getNombre() {
		return nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public int getValidez() {
		return validez;
	}
	public float getDescuento() {
		return descuento;
	}
	public Set<String> getColActividades() {
		return colActividades;
	}
}
