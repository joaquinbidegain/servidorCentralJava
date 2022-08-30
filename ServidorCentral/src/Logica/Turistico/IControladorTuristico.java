package Logica.Turistico;

import java.util.Date;
import java.util.Set;

public interface IControladorTuristico {
	
	abstract Set<String> obtenerActividadesDepartamento(String nombreDepartamento);
	abstract DTInfoActividadTuristica seleccionarActividadTuristica(String nombreActividad, String nombreDepartamento);
	abstract int ingresarSalidaTuristica(String nombreSalida, Date fecha, String lugarSalida, int maxCantTuristas, Date fechaAlta, String nombreActividad, String nombreDepartamento);
	abstract Set<String> listarDepartamentos();
	abstract int ingresarDatosBasicos(String proveedor, String departamento, String nombreActividad, String descripcion, int duracion, float costo, String ciudadAlta, Date fechaAlta);
	abstract Set<DTInfoBasicaSalida> listaSalidasVigentes(String actividad);
	abstract Set<String> listaSalidasAsociadas(String actividad);
	abstract DTInfoSalida datosSalida(String salida);
	abstract Set<String> listadoActividadesTuristicasDelDepto(String nombreDepto, String nombrePaquete);
	abstract int ingresarDatosDepto(String nombreDepto, String descripcion, String url);
}
