package Logica.Usuario;
import Logica.Turistico.*;
import java.util.Date;

public class Inscripcion {

	private Date fecha;
	private int cantTuristas;
	private SalidaTuristica salida;
	private Turista turista;

	public Inscripcion(Date fecha, int cantTuristas, Turista turista, SalidaTuristica salida) {
		this.fecha = fecha;
		this.cantTuristas = cantTuristas;
		this.turista = turista;
		this.setSalida(salida);
	}
	
	public float Costo(){
		return cantTuristas* salida.getActividad().getCostoxTurista();
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getCantTuristas() {
		return cantTuristas;
	}

	public void setCantTuristas(int cantTuristas) {
		this.cantTuristas = cantTuristas;
	}
	
	public Turista getTurista() {
		return turista;
	}

	public void setTurista(Turista turista) {
		this.turista = turista;
	}

	public SalidaTuristica getSalida() {
		return salida;
	}

	public void setSalida(SalidaTuristica salida) {
		this.salida = salida;
	}

	//funciones
	
	public DTInfoSalida obtenerSalidaTuristica() {
		DTInfoSalida sal = salida.getInfo();
		return  sal;
	}
	
}
