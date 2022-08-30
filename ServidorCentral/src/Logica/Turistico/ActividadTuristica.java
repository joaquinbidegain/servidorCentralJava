package Logica.Turistico;
import Logica.Usuario.*;
import Logica.Paquete.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ActividadTuristica {
	
	private String nombre;
	private String descripcion;
	private int duracionxHora;
	private float costoxTurista;
	private Date fechaAlta;
	private String ciudad;
	private Proveedor prov;
	private Departamento depto;//Departamento es uno solo
	private Map<String, SalidaTuristica> colSalidaTuristica;
	private Map<String, Paquete> colPaquete;
	
	public ActividadTuristica(String nombre, String descripcion, int duracionxHora, float costoxTurista, Date fechaAlta, String ciudad) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracionxHora = duracionxHora;
		this.costoxTurista = costoxTurista;
		this.fechaAlta = fechaAlta;
		this.ciudad = ciudad;
		this.colSalidaTuristica = new HashMap<>();
		this.colPaquete = new HashMap<>();
	}


	
	//SETTERS Y GETTERS
	
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
	public int getDuracionxHora() {
		return duracionxHora;
	}
	public void setDuracionxHora(int duracionxHora) {
		this.duracionxHora = duracionxHora;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public float getCostoxTurista() {
		return costoxTurista;
	}
	public void setCostoxTurista(float costoxTurista) {
		this.costoxTurista = costoxTurista;
	}
	
	public Proveedor getProv() {
		return prov;
	}
	public void setProv(Proveedor prov) {
		this.prov = prov;
	}

	public Departamento getDepto() {
		return depto;
	}
	public void setDepto(Departamento depto) {
		this.depto = depto;
	}
	
	//OPERACIONES
	public DTInfoActividadTuristica obtenerDTInfoActividadTuristica() {
		DTInfoActividadTuristica info = new DTInfoActividadTuristica(nombre, descripcion, duracionxHora,  costoxTurista, fechaAlta, ciudad, colSalidaTuristica.keySet() , colPaquete.keySet(), depto.getNombre());
		return info;
	}
	
	public void agregarProveedorDepartamento(Proveedor prov, Departamento depto) {
		this.prov = prov;
		this.depto = depto;
	}
	
	public Set<String> getSalidas(){
		return this.colSalidaTuristica.keySet();
	}
	
	
	public void setColSalidaTuristica(SalidaTuristica salida) {
		this.colSalidaTuristica.put(salida.getNombre(), salida);
	}
	
	public boolean estaSalidaTuristica(String nombre) {
		boolean esta = colSalidaTuristica.containsKey(nombre);
		return esta;
	}

	public String getNombreDepartamento() {
		return this.depto.getNombre();
	}
	
	
	
	
}
