package Logica.Turistico;

import java.util.Date;

public class DTInfoSalida {

	private String nombre;
	private int cantMax;
	private Date fechaAlta;
	private Date fechaSalida;
	private String lugarSalida;
	private ActividadTuristica actividadAsociada;
	
	
	
	public DTInfoSalida(String nombre, int cantMax, Date fechaAlta, Date fechaSalida, String lugarSalida,
			ActividadTuristica actividadTuristica) {
		this.nombre = nombre;
		this.cantMax = cantMax;
		this.fechaAlta = fechaAlta;
		this.fechaSalida = fechaSalida;
		this.lugarSalida = lugarSalida;
		this.actividadAsociada = actividadTuristica;
	}


	public String getNombre() {
		return nombre;
	}


	public int getCantMax() {
		return cantMax;
	}


	public Date getFechaAlta() {
		return fechaAlta;
	}


	public Date getFechaSalida() {
		return fechaSalida;
	}


	public String getLugarSalida() {
		return lugarSalida;
	}


	public ActividadTuristica getActividadAsociada() {
		return actividadAsociada;
	}

}
