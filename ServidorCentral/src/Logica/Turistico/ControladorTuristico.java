package Logica.Turistico;


import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import Logica.Paquete.ControladorPaquete;
import Logica.Paquete.IControladorPaquete;
import Logica.Paquete.Paquete;
import Logica.Usuario.ControladorUsuario;
import Logica.Usuario.IControladorUsuario;
import Logica.Usuario.Proveedor;

public class ControladorTuristico implements IControladorTuristico {
	private Map<String, SalidaTuristica> colSalidaTuristica;
	private Map<String, Departamento> colDepartamento;
	private static ControladorTuristico instance;
	private ControladorTuristico() {
		this.colDepartamento = new HashMap<>();
		this.colSalidaTuristica = new HashMap<>();
	}


	public static ControladorTuristico getInstance() {
	    if (instance == null) {
	        instance = new ControladorTuristico();
	    }
	    return instance;
	}


	public Set<String> obtenerActividadesDepartamento(String nombreDepartamento) {
		Departamento d = colDepartamento.get(nombreDepartamento);
		Set<String> res = d.getActividades();
		return res;
	}


	public DTInfoActividadTuristica seleccionarActividadTuristica(String nombreActividad, String nombreDepartamento) {
		Departamento d = colDepartamento.get(nombreDepartamento);
		ActividadTuristica a = d.getActividad(nombreActividad);
		return a.obtenerDTInfoActividadTuristica();
	}


	public int ingresarSalidaTuristica(String nombreSalida, Date fecha, String lugarSalida, int maxCantTuristas,
			Date fechaAlta, String nombreActividad, String nombreDepartamento) {
		Departamento d = colDepartamento.get(nombreDepartamento);
		ActividadTuristica a = d.getActividad(nombreActividad);
		boolean esta = a.estaSalidaTuristica(nombreSalida);
		if(esta) {
			return 1;
		} else {
			SalidaTuristica s = new SalidaTuristica(nombreSalida, maxCantTuristas, fechaAlta, fecha, lugarSalida, a);
			colSalidaTuristica.put(nombreSalida, s);
			a.setColSalidaTuristica(s);
			return 2;
		}
	}


	public Set<String> listarDepartamentos() {
		Set<String> res = colDepartamento.keySet();
		return res;
	}


	public int ingresarDatosBasicos(String proveedor, String departamento, String nombreActividad, String descripcion,
			int duracion, float costo, String ciudadAlta, Date fechaAlta) {
		Departamento d = colDepartamento.get(departamento);
		boolean b = d.estaActividad(nombreActividad);
		if(b) {
			return 2;
		} else {
			ControladorUsuario CU = ControladorUsuario.getInstance();
			ActividadTuristica a = new ActividadTuristica(nombreActividad, descripcion, duracion, costo, fechaAlta, ciudadAlta);
			Proveedor p = CU.obtenerProveedor(proveedor, a);
			d.agregarActividad(a);
			a.agregarProveedorDepartamento(p, d);
			return 1;
		}
	}


	public Set<DTInfoBasicaSalida> listaSalidasVigentes(String actividad) {
		Set<DTInfoBasicaSalida> res = new HashSet<>();
		for (Map.Entry<String, SalidaTuristica> a: colSalidaTuristica.entrySet()) {
			SalidaTuristica s = a.getValue();
			if(s.estaVigente()) {
				res.add(s.getInfoBasica());
			} 
		 }
		return res;
	}


	public Set<String> listaSalidasAsociadas(String actividad) {
		Iterator<Map.Entry<String, SalidaTuristica>> itr = colSalidaTuristica.entrySet().iterator();
		boolean encontrado = false;
		ActividadTuristica a = null;
		while((itr.hasNext()) && (!encontrado)) {
            Map.Entry<String, SalidaTuristica> entry = itr.next();
            a = entry.getValue().getActividad();
            if(a.getNombre().equals(actividad) ) {
            	encontrado = true;
            }
		}
		Set<String> res = a.getSalidas();
		return res;
	}


	public DTInfoSalida datosSalida(String salida) {
		SalidaTuristica s = colSalidaTuristica.get(salida);
		DTInfoSalida res = s.getInfo();
		return res;
	}


	public Set<String> listadoActividadesTuristicasDelDepto(String nombreDepto, String nombrePaquete) {
		ControladorPaquete ICP = ControladorPaquete.getInstance();
		Paquete p = ICP.obtenerPaquete(nombrePaquete);
		Set<String> res = new HashSet<>();
		for (Map.Entry<String, Departamento> d: colDepartamento.entrySet()) {
			Map<String,ActividadTuristica> acts = d.getValue().getColActividadTuristica();
			for (Map.Entry<String, ActividadTuristica> aux: acts.entrySet()) {
				if(nombreDepto.equals(aux.getValue().getNombreDepartamento())) {
					String str = p.buscarActividadEnPaquete(aux.getValue());
					res.add(str);
				}
			}
		}
		return res;
	}
		 
	


	public int ingresarDatosDepto(String nombreDepto, String descripcion, String url) {
		Departamento d = colDepartamento.get(nombreDepto);
		if(d == null) {
			d = new Departamento(nombreDepto, descripcion, url);
			colDepartamento.put(nombreDepto, d);
			return 2;
		} else {
			return 1;
		}
			
	}

	public SalidaTuristica getSalida(String salida) {
			SalidaTuristica s = colSalidaTuristica.get(salida);
			return s;	
	}


	public Map<String, SalidaTuristica> getColSalidaTuristica() {
		return colSalidaTuristica;
	}

	public ActividadTuristica getActividadTuristica(String a) {
		
		Iterator<Map.Entry<String, Departamento>> itr = colDepartamento.entrySet().iterator();
		boolean encontrado = false;
		ActividadTuristica a1 = null;
		while((itr.hasNext()) && (a1 == null )) {
            Map.Entry<String, Departamento> entry = itr.next();
            a1 = entry.getValue().getActividad(a);
		}
		return a1;
	}
}
