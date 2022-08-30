package Logica.Usuario;

import java.util.Date;

public class DTProveedor extends DTUsuario{

	
	public DTProveedor(String nombre, String nickname, String apellido, String email, Date nacimiento,
			String descripcion, String link) {
		super(nombre, nickname, apellido, email, nacimiento);
		this.descripcion = descripcion;
		this.link = link;
	}

	private String descripcion;
	private String link;
	
	public String getDescripcion() {
		return descripcion;
	}

	public String getLink() {
		return link;
	}
	
	
}
