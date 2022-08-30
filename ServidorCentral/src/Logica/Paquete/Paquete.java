package Logica.Paquete;

import Logica.Turistico.*;
import java.util.Map;
import java.util.Set;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Paquete {
	
	private String nombre;
	private String descripcion;
	private int validez;
	private float descuento;
	private Date fechaAlt;
	private Map<String, ActividadTuristica> colActividad;
	
	public Paquete(String nombre, String descripcion, int validez, float descuento, Date fechaAlt){
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.validez = validez;
		this.descuento = descuento;
		this.fechaAlt = fechaAlt;
		this.colActividad = new HashMap<>();
	}
	
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
	public int getValidez() {
		return validez;
	}
	public void setValidez(int validez) {
		this.validez = validez;
	}
	public float getDescuento() {
		return descuento;
	}
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	
	public Date getFechaAlt() {
		return fechaAlt;
	}

	public void setFechaAlt(Date fechaAlt) {
		this.fechaAlt = fechaAlt;
	}
	
	//Modificar dps el set ya que es coleccion
	public Map<String, ActividadTuristica> getColActividad() {
		return colActividad;
	}
	public void setColActividad(Map<String, ActividadTuristica> colActividad) {
		this.colActividad = colActividad;
	}
	
	
	//Funciones
	
	public DTInfoPaquete obtenerInfoPaquete() {
		Set<String> colNombreActividades = new HashSet<>();
		for (Iterator<Map.Entry<String, ActividadTuristica>> entries = colActividad.entrySet().iterator(); entries.hasNext(); ) {
		    Map.Entry<String, ActividadTuristica> entry = entries.next();
		    colNombreActividades.add(entry.getKey());
		}
		
		DTInfoPaquete info_paquete = new DTInfoPaquete(nombre, descripcion, validez, descuento, colNombreActividades);
		return info_paquete;
	}

	public String buscarActividadEnPaquete(ActividadTuristica act) {
		
		String nombre_act = act.getNombre();
		boolean existe = colActividad.containsKey(nombre_act);
		if(existe) {
			return nombre_act;
		}else {
			return " "; 
		}
	}
	
	
	//es un void y no un string lo que retorna
	public void agregarActividad(ActividadTuristica act) {
		colActividad.put(act.getNombre(), act);
	}
	
}
