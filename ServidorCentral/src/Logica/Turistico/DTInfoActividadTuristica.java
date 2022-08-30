package Logica.Turistico;

import java.util.Date;
import java.util.Set;

public class DTInfoActividadTuristica {

	private String nombre;
	private String descripcion;
	private int duracionxHora;
	private float costoxTurista;
	private Date fechaAlta;
	private String ciudad;
	private Set<String> listaSalidas;
	private Set<String> paquetesAsoc;
	private String departamento;
	
	
	public DTInfoActividadTuristica(String nombre, String descripcion, int duracionxHora, float costoxTurista2,
			Date fechaAlta, String ciudad, Set<String> listaSalidas, Set<String> paquetesAsoc, String departamento) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracionxHora = duracionxHora;
		this.costoxTurista = costoxTurista2;
		this.fechaAlta = fechaAlta;
		this.ciudad = ciudad;
		this.listaSalidas = listaSalidas;
		this.paquetesAsoc = paquetesAsoc;
		this.departamento = departamento;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public int getDuracionxHora() {
		return duracionxHora;
	}
	public float getCostoxTurista() {
		return costoxTurista;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public String getCiudad() {
		return ciudad;
	}
	public Set<String> getListaSalidas() {
		return listaSalidas;
	}
	public Set<String> getPaquetesAsoc() {
		return paquetesAsoc;
	}


	public String getDepartamento() {
		return departamento;
	}
	
	
	
}
