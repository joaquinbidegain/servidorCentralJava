package Logica.Fabrica;

import Logica.Paquete.*;
import Logica.Turistico.*;
import Logica.Usuario.*;

public class Fabrica {
	
private static Fabrica instance;
	private Fabrica() {
	}

	public static Fabrica getInstance() {
		  if (instance == null) {
		     instance = new Fabrica();
		   }
		  return instance;
		}
	
	public IControladorPaquete getIControladorPaquete() {
		IControladorPaquete p = ControladorPaquete.getInstance();
		return p;
	}
	public IControladorTuristico getIControladorTuristico() {
		IControladorTuristico t = ControladorTuristico.getInstance();
		return t;
	}
	public IControladorUsuario getIControladorUsuario() {
		IControladorUsuario u = ControladorUsuario.getInstance();
		return u;
	}
}
