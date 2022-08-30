package Logica.Paquete;

import java.util.Date; 
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import Logica.Turistico.*;

public class ControladorPaquete implements IControladorPaquete{
	
	private static ControladorPaquete instance;
	private Map<String, Paquete> colPaquete;
	private ControladorPaquete() {
		this.colPaquete = new HashMap<>();
	}
	
	public static ControladorPaquete getInstance() {
	       if (instance == null) {
	           instance = new ControladorPaquete();
	       }
	       return instance;
	   }
	
	//modificar el set ya que es la coleccion
	public Map<String, Paquete> getColPaquete() {
		return colPaquete;
	}
	
	public void setColPaquete(Map<String, Paquete> colPaquete) {
		this.colPaquete = colPaquete;
	}

	public int registrarPaquete(String nombre,String descripcion,int validez,float descuento,Date fechaAlta) {
		if(colPaquete.containsKey(nombre)) {
			return 1;
		} else {
			Paquete p = new Paquete(nombre, descripcion, validez, descuento, fechaAlta);
			colPaquete.put(nombre, p);
			return 2;
		}
		
	} 
	
	public DTInfoPaquete mostrarInfoPaquete(String nombrePaquete) {
		Paquete p = colPaquete.get(nombrePaquete);
		DTInfoPaquete pinfo = p.obtenerInfoPaquete();
		return pinfo;
	}
	
	public Set<String> listadoNombrePaquetes() {
		Set<String> res = colPaquete.keySet();
		return res;
	}
	
	public Paquete obtenerPaquete(String nombrePaquete) {
		Paquete p = colPaquete.get(nombrePaquete);
		return p;
	}
	
	public void seleccionarActividadTuristicaParaAgregarAPaquete(String nombreActividadT, String nombrePaquete) {
		Paquete p = colPaquete.get(nombrePaquete);
		ControladorTuristico k = ControladorTuristico.getInstance();
		ActividadTuristica a = k.getActividadTuristica(nombreActividadT);
		if(a == null) {		System.out.println( "ERROR");
		}
		p.agregarActividad(a);
	}
	

}
