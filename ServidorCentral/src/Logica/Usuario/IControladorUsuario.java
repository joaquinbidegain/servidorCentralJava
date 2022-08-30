package Logica.Usuario;
import Logica.Turistico.*;
import java.util.Date;
import java.util.Set;

public interface IControladorUsuario {

	abstract public Set<DTProveedor> listarProveedores();
	abstract public int ingresoTurista(String nick, String nombre, String apellido, String correo, Date nacimiento, String nacionalidad);
	abstract public int ingresoProveedor(String nick,String nombre, String apellido, String correo, Date nacimiento,  String descripcion, String link);
	abstract public Set<DTUsuario> listaUsuario();
	abstract public DTUsuario obtenerUsuario(String nickname);
	abstract public Set<DTInfoActividadTuristica> obtenerActividadesTuristicas(String nickname);
	abstract public Set<DTInfoSalida> obtenerSalidasTuristicas(String nickname);
	abstract public void modificarNombre(String nickname, String nombre);
	abstract public void modificarApellido(String nickname, String apellido);
	abstract public void modificarFechaNacimiento(String nickname, Date fechaNac);
	abstract public Set<String> listaTuristas();
	abstract public int inscripcion(String turista, String salida, int cantTuristas, Date fechaIns);
	abstract public boolean esTurista(String nickname);
}
