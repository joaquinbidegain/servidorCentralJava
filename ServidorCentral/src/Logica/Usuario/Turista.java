package Logica.Usuario;
import Logica.Turistico.*; 

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Turista extends Usuario{

	private Map<String, Inscripcion> colInscripcion; //clave es el nombre de la salida asociada a la inscripcion
	private String nacionalidad;

	public Turista(String nombre, String nickname, String apellido, String email, Date nacimiento,
			String nacionalidad) {
		super(nombre, nickname, apellido, email, nacimiento);
		this.colInscripcion = new HashMap<>();
		this.nacionalidad = nacionalidad;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	public Map<String, Inscripcion> getColInscripcion() {
		return colInscripcion;
	}
	
	//funciones
	
	public boolean estaInscripto(String salida) {
		return colInscripcion.containsKey(salida);
	}
	
	public Set<DTInfoSalida> obtenerSalidasTurista() {
		Set<DTInfoSalida> ret= new HashSet<>();
		for (String cla: colInscripcion.keySet()) {
			Inscripcion ins = colInscripcion.get(cla);
			DTInfoSalida dtSal = ins.getSalida().getInfo();
			ret.add(dtSal); 
		}		
		return ret;
	}
	public void crearInscripcion(SalidaTuristica sal, int cantTur, Date fechaIns) {
		Inscripcion ins = new Inscripcion(fechaIns, cantTur, this, sal);
		colInscripcion.put(sal.getNombre(), ins);
		sal.setInscripcion(this.getNombre(), ins);
	}


	
}
