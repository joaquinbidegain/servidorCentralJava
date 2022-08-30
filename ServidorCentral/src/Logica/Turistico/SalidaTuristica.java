package Logica.Turistico;

import Logica.Usuario.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class SalidaTuristica {
	// ATRIBUTOS
	private String nombre;
	private int cantMax;
	private Date fechaAlta;
	private Date fechaSalida;
	private String lugarSalida;
	private ActividadTuristica actividad;
	private Map<String, Inscripcion> colInscripcion;
	
	//CONSTRUCTOR
	public SalidaTuristica(String nombre, int cantMax, Date fechaAlta, Date fechaSalida, String lugarSalida, ActividadTuristica actividad) {
		this.nombre = nombre;
		this.cantMax = cantMax;
		this.fechaAlta = fechaAlta;
		this.fechaSalida = fechaSalida;
		this.lugarSalida = lugarSalida;
		this.actividad = actividad;
		this.colInscripcion = new HashMap<>();
	}

	//SETTERS Y GETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantMax() {
		return cantMax;
	}

	public void setCantMax(int cantMax) {
		this.cantMax = cantMax;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getLugarSalida() {
		return lugarSalida;
	}

	public void setLugarSalida(String lugarSalida) {
		this.lugarSalida = lugarSalida;
	}
	
	public ActividadTuristica getActividad() {
		return actividad;
	}

	public void setActividad(ActividadTuristica actividad) {
		this.actividad = actividad;
	}
	
	public int cupos(){
		int cupo = cantMax;
		for (String cla: colInscripcion.keySet()) {
			Inscripcion ins = colInscripcion.get(cla);
			cupo = cupo - ins.getCantTuristas();
		}
		return cupo;
	}

	//OPERACIONES
	
	public boolean estaVigente() {
		Date fechaActual = null; // Arreglar, PONER FECHA ACTUAL SISTEMA
		return  (fechaActual.compareTo(this.fechaSalida) > 0);
	}
	
	public DTInfoBasicaSalida getInfoBasica() {
		
		DTInfoBasicaSalida info = new DTInfoBasicaSalida(nombre, cantMax, fechaAlta, fechaSalida, lugarSalida);
		return info;
	}
	
	public DTInfoSalida getInfo() {
		
		DTInfoSalida info_sal = new DTInfoSalida(nombre, cantMax, fechaAlta, fechaSalida, lugarSalida, actividad);
		return info_sal;
	}
	
	public void setInscripcion(String nombreTurista, Inscripcion ins) {
		this.colInscripcion.put(nombreTurista, ins);
	}
}
