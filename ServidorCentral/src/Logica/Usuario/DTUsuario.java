package Logica.Usuario;

import java.util.Date;

public class DTUsuario {

	private String nombre;
	private String nickname;
	private String apellido;
	private String email;
	private Date nacimiento;
	

	public DTUsuario(String nombre, String nickname, String apellido, String email, Date nacimiento) {
		this.nombre = nombre;
		this.nickname = nickname;
		this.apellido = apellido;
		this.email = email;
		this.nacimiento = nacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public String getNickname() {
		return nickname;
	}

	public String getApellido() {
		return apellido;
	}

	public Date getNacimiento() {
		return nacimiento;
	}

	public String getEmail() {
		return email;
	}
	
	
}
