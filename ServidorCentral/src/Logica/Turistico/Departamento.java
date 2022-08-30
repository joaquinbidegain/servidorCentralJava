package Logica.Turistico;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Departamento {
	
	public Departamento(String nombre, String descripcion, String url) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.url = url;
		this.colActividadTuristica = new HashMap<>();
	}
	
	private String nombre;
	private String descripcion;
	private String url;
	private Map<String, ActividadTuristica> colActividadTuristica;
	
	// OPERACIONES
	public void agregarActividad(ActividadTuristica actividad) {
		this.colActividadTuristica.put(actividad.getNombre(), actividad);
	}
	
	public Set<String> getActividades(){
		return this.colActividadTuristica.keySet();
		
	}
	
	public ActividadTuristica getActividad(String nombreActividad) {
		ActividadTuristica a = colActividadTuristica.get(nombreActividad);
		return a;
	}
	
	public boolean estaActividad(String nombre) {
		boolean b = colActividadTuristica.containsKey(nombre);
		return b;
	}
	// SETTERS Y GETTERS
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public Map<String, ActividadTuristica> getColActividadTuristica() {
		return colActividadTuristica;
	}
	
	// OPERACIONES COLECCION
}
