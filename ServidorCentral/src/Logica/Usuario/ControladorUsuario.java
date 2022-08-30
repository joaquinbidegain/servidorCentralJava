package Logica.Usuario;

import Logica.Usuario.*;
import Logica.Turistico.*;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ControladorUsuario implements IControladorUsuario{
	
	private Map<String, Usuario> colUsuarioCorreo; //clave es el correo del user
	private Map<String, Usuario> colUsuarioNick; //clave es el nick del user
	private static ControladorUsuario instance;
	
	private ControladorUsuario() {
		this.colUsuarioCorreo = new HashMap<>();
		this.colUsuarioNick = new HashMap<>();
	}
	
	public static ControladorUsuario getInstance() {
	  if (instance == null) {
	     instance = new ControladorUsuario();
	   }
	  return instance;
	}

	public Set<DTProveedor> listarProveedores() {
		Set<DTProveedor> ret = new HashSet<>();
		for (String cla: colUsuarioCorreo.keySet()) {
			Usuario usuario = colUsuarioCorreo.get(cla);
			if (usuario instanceof Proveedor){
				DTProveedor dtProv = ((Proveedor) usuario).getDTProvedor();
				ret.add(dtProv); 
		    }
		}		
		return ret;
	}
	
	public Proveedor obtenerProveedor(String proveedor, ActividadTuristica act) {
		Usuario usuario = colUsuarioNick.get(proveedor);
		((Proveedor) usuario).agregarActividad(act);
		return ((Proveedor) usuario);
	}
	
	public int ingresoTurista(String nick, String nombre, String apellido, String correo, Date nacimiento, String nacionalidad) {
		//devuelve un int del 1 al 4 ||1=todo bien; 2=mal mail; 3=mal nickname; 4=todo mal
		boolean boolCorreo = colUsuarioCorreo.containsKey(correo);
		boolean boolNick = colUsuarioNick.containsKey(nick);
		if ((!boolCorreo) && (!boolNick)) {
			Turista t = new Turista(nick, nombre, apellido, correo, nacimiento, nacionalidad);
			colUsuarioCorreo.put(correo, t);
			colUsuarioNick.put(nick, t);
			return 1;
		}
		else if ((boolCorreo) && (!boolNick)) {
			return 2;
		}
		else if ((!boolCorreo) && (boolNick)) {
			return 3;
		}
		else {
			return 4;
		}

	}
	public int ingresoProveedor(String nick,String nombre, String apellido, String correo, Date nacimiento,  String descripcion, String link) {
		//devuelve un int del 1 al 4 ||1=todo bien; 2=mal mail; 3=mal nickname; 4=todo mal
		boolean boolCorreo = colUsuarioCorreo.containsKey(correo);
		boolean boolNick = colUsuarioNick.containsKey(nick);
		if ((!boolCorreo) && (!boolNick)) {
			Proveedor t = new Proveedor(nick, nombre, apellido, correo, nacimiento,descripcion, link );
			colUsuarioCorreo.put(correo, t);
			colUsuarioNick.put(nick, t);
			return 1;
		}
		else if ((boolCorreo) && (!boolNick)) {
			return 2;
		}
		else if ((!boolCorreo) && (boolNick)) {
			return 3;
		}
		else {
			return 4;
		}
	}
	public Set<DTUsuario> listaUsuario() {
		Set<DTUsuario> usu= new HashSet<>();
		for (String cla: colUsuarioNick.keySet()) {
			Usuario act = colUsuarioNick.get(cla);
			DTUsuario dtAct = act.datosUsuario();
			usu.add(dtAct); 
		}		
		return usu;
	}
	public DTUsuario obtenerUsuario(String nickname) {
		Usuario act = colUsuarioNick.get(nickname);
		DTUsuario dtAct = act.datosUsuario();
		return dtAct;
	}
	public Set<DTInfoActividadTuristica> obtenerActividadesTuristicas(String nickname) {
		Usuario usu = colUsuarioNick.get(nickname);
		return ((Proveedor) usu).obtenerActividadesTuristicas();
	}
	
	
	//supongo que es obtenerSalidasTurista(nickname: string): set(DTInfoSalida)
	public Set<DTInfoSalida> obtenerSalidasTuristicas(String nickname) {
		Usuario usu = colUsuarioNick.get(nickname);
		return ((Turista) usu).obtenerSalidasTurista();
	}
	
	public void modificarNombre(String nickname, String nombre) {
		Usuario usu = colUsuarioNick.get(nickname);
		usu.setNombre(nombre);
	}
	
	public void modificarApellido(String nickname, String apellido) {
		Usuario usu = colUsuarioNick.get(nickname);
		usu.setApellido(apellido);
	}
	
	public void modificarFechaNacimiento(String nickname, Date fechaNac) {
		Usuario usu = colUsuarioNick.get(nickname);
		usu.setNacimiento(fechaNac);
	}
	
	public Set<String> listaTuristas() {
		Set<String> ret = new HashSet<>();
		for (String cla: colUsuarioNick.keySet()) {
			Usuario usuario = colUsuarioNick.get(cla);
			if (usuario instanceof Turista){
				String nombreTurista = ((Turista) usuario).getNickname();
				ret.add(nombreTurista); 
		    }
		}		
		return ret;
	}
	
	public int inscripcion(String turista, String salida, int cantTuristas, Date fechaIns) {
		//devuelve un int del 1 al 4 ||1=todo bien; 2=mal estaInscripto; 3=mal cuposDisponibles; 4=todo mal
		ControladorTuristico t = ControladorTuristico.getInstance();
		SalidaTuristica salidaTuris = t.getSalida(salida);
		if(salidaTuris == null) {
		System.out.println("Despues slaida");
		}
		int cupos = salidaTuris.cupos();
		
		Usuario usu = colUsuarioNick.get(turista);
		boolean estaInscrip = ((Turista) usu).estaInscripto(salida);
		
		if ((!estaInscrip) && (cupos>=cantTuristas)) {
			((Turista) usu).crearInscripcion(salidaTuris, cantTuristas, fechaIns);
			return 1;
		}
		else if ((estaInscrip) && (cupos>=cantTuristas)) {
			return 2;
		}
		else if ((!estaInscrip) && (cupos<cantTuristas)) {
			return 3;
		}
		else {
			return 4;
		}
		
	}

	public Map<String, Usuario> getColUsuarioCorreo() {
		return colUsuarioCorreo;
	}

	public Map<String, Usuario> getColUsuarioNick() {
		return colUsuarioNick;
	}
	
	public boolean esTurista(String nickname) {
		Usuario usu = colUsuarioNick.get(nickname);
		return usu.getClass() == Turista.class;
 	}
}
