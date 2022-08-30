package Logica.Usuario;

import java.util.Date;

public class Usuario {

	private String nombre;
	private String nickname;
	private String apellido;
	private String email;
	private Date nacimiento;
	
	public Usuario(String nickname, String nombre, String apellido, String email, Date nacimiento) {
		this.nombre = nombre;
		this.nickname = nickname;
		this.apellido = apellido;
		this.email = email;
		this.nacimiento = nacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}
	
	//funciones
	public DTUsuario datosUsuario() {		
		return new DTUsuario(nombre, nickname, apellido, email, nacimiento);
	}
	
}
