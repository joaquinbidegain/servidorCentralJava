package Logica.Paquete;

import java.util.Date; 
import java.util.Set;

public interface IControladorPaquete {
	
	abstract public int registrarPaquete(String nombre,String descripcion,int validez,float descuento,Date fechaAlta); 
	abstract public DTInfoPaquete mostrarInfoPaquete(String nombrePaquete);
	abstract public Set<String> listadoNombrePaquetes();
	abstract public void seleccionarActividadTuristicaParaAgregarAPaquete(String nombreActividadT, String nombrePaquete);

}
