package Logica.Usuario;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import Logica.Turistico.*;

public class Proveedor extends Usuario {
	
	private String descripcion;
	private String link;
	private Map<String, ActividadTuristica> colActividadesProveedor; //clave nombre actividad
	
	public Proveedor(String nombre, String nickname, String apellido, String email, Date nacimiento, String descripcion,
			String link) {
		super(nombre, nickname, apellido, email, nacimiento);
		this.descripcion = descripcion;
		this.link = link;
		this.colActividadesProveedor = new HashMap<>();
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	public Map<String, ActividadTuristica> getColActividadesProveedor() {
		return colActividadesProveedor;
	}
	
	//funciones
	public void agregarActividad(ActividadTuristica act) {
		this.colActividadesProveedor.put(act.getNombre(), act);
	}
	
	public DTProveedor getDTProvedor() {
		return new DTProveedor(getNombre(), getNickname(), getApellido(), getEmail(), getNacimiento(),
				descripcion, link);
	}
	
	public Set<DTInfoActividadTuristica> obtenerActividadesTuristicas() {
		Set<DTInfoActividadTuristica> ret= new HashSet<>();
		for (String cla: colActividadesProveedor.keySet()) {
			ActividadTuristica act = colActividadesProveedor.get(cla);
			DTInfoActividadTuristica dtAct = act.obtenerDTInfoActividadTuristica();
			ret.add(dtAct); 
		}		
		return ret;
	}
	/*
	for (Iterator it = colActividadesProveedor.keySet().iterator(); it.hasNext(); ) {
	    String clave = (String) it.next();
	    String valor = (String) mapa.get(clave);
	  }   
	*/
	
	
}
